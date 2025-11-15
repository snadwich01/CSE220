public class StackAndQueueAssgnTaskTester {

    public static void evalMathExpression(String expression) {
        int len = expression.length();

        // Create ONLY ONE Stack and ONE Queue to be reused throughout
        Stack stack = new Stack();
        Queue queue = new Queue();

        // Step 1: Check parentheses balance
        for(int i = 0; i < len; i++) {
            char check = expression.charAt(i);

            if(check == '(' || check == '{' || check == '[') {
                stack.push(check);
            } else if(check == ')' || check == '}' || check == ']'){
                if(stack.peek() == null) {
                    System.out.println("Invalid Expression");
                    return;
                }
                char open = (char) stack.pop();
                
                if((check == ')' && open != '(') || 
                   (check == '}' && open != '{') || 
                   (check == ']' && open != '[')) {
                    System.out.println("Invalid Expression");
                    return;
                }
            }
        }
        
        // Check for leftover opening brackets
        if(stack.peek() != null) {
            System.out.println("Invalid Expression");
            return;
        }

        // Step 2: Convert infix to postfix (reusing the same stack, now empty)
        String currentNumber = "";
        
        for(int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            
            // Handle spaces
            if(ch == ' ') {
                if(currentNumber.length() > 0) {
                    queue.enqueue(currentNumber);
                    currentNumber = "";
                }
            } else if(ch >= '0' && ch <= '9') {
                // If digit, build the number
                currentNumber = currentNumber + ch;
            } else {
                // Save any number we were building
                if(currentNumber.length() > 0) {
                    queue.enqueue(currentNumber);
                    currentNumber = "";
                }
                
                // Handle opening brackets
                if(ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                // Handle closing brackets
                else if(ch == ')' || ch == '}' || ch == ']') {
                    char openBracket = (ch == ')') ? '(' : (ch == '}') ? '{' : '[';
                    
                    while(stack.peek() != null) {
                        char top = (char) stack.pop();
                        if(top == openBracket) {
                            break;
                        }
                        String opString = "";
                        opString = opString + top;
                        queue.enqueue(opString);
                    }
                }
                // Handle operators
                else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                    // Get precedence of current operator
                    int currentPrecedence = 0;
                    if(ch == '^') currentPrecedence = 3;
                    else if(ch == '*' || ch == '/') currentPrecedence = 2;
                    else if(ch == '+' || ch == '-') currentPrecedence = 1;
                    
                    // Pop operators with higher or equal precedence
                    while(stack.peek() != null) {
                        char top = (char) stack.peek();
                        
                        // Don't pop brackets
                        if(top == '(' || top == '{' || top == '[') {
                            break;
                        }
                        
                        // Get precedence of top operator
                        int topPrecedence = 0;
                        if(top == '^') topPrecedence = 3;
                        else if(top == '*' || top == '/') topPrecedence = 2;
                        else if(top == '+' || top == '-') topPrecedence = 1;
                        
                        // Check precedence (^ is right-associative)
                        if(topPrecedence > currentPrecedence || 
                           (topPrecedence == currentPrecedence && ch != '^')) {
                            stack.pop();
                            String opString = "";
                            opString = opString + top;
                            queue.enqueue(opString);
                        } else {
                            break;
                        }
                    }
                    stack.push(ch);
                }
            }
        }
        
        // Add last number if any
        if(currentNumber.length() > 0) {
            queue.enqueue(currentNumber);
        }
        
        // Pop remaining operators from stack to queue
        while(stack.peek() != null) {
            char op = (char) stack.pop();
            String opString = "";
            opString = opString + op;
            queue.enqueue(opString);
        }
        
        // Step 3: Print postfix by rotating the queue
        System.out.print("Postfix: ");
        int queueSize = queue.size();
        for(int i = 0; i < queueSize; i++) {
            String item = (String) queue.dequeue();
            System.out.print(item + " ");
            queue.enqueue(item);
        }
        System.out.println();
        
        // Step 4: Evaluate postfix (reusing the same stack, now empty)
        int evalSize = queue.size();
        for(int i = 0; i < evalSize; i++) {
            String token = (String) queue.dequeue();
            
            // Check if it's a number
            char firstChar = token.charAt(0);
            if(firstChar >= '0' && firstChar <= '9') {
                // Manual string to double conversion
                double num = 0;
                for(int j = 0; j < token.length(); j++) {
                    char digit = token.charAt(j);
                    num = num * 10 + (digit - '0');
                }
                stack.push(num);
            } else {
                // It's an operator, pop two operands
                double operand2 = (double) stack.pop();
                double operand1 = (double) stack.pop();
                double result = 0;
                
                char operator = token.charAt(0);
                if(operator == '+') {
                    result = operand1 + operand2;
                } else if(operator == '-') {
                    result = operand1 - operand2;
                } else if(operator == '*') {
                    result = operand1 * operand2;
                } else if(operator == '/') {
                    result = operand1 / operand2;
                } else if(operator == '^') {
                    // Manual power calculation
                    result = 1;
                    for(int p = 0; p < (int)operand2; p++) {
                        result = result * operand1;
                    }
                }
                
                stack.push(result);
            }
        }
        
        double finalResult = (double) stack.pop();
        System.out.println("Result: " + (int)finalResult);
    }

    public static void main(String[] args) {
        
        System.out.println("================ Test 01 ================");
        System.out.println("This should print:");
        System.out.println("Postfix: 3 5 2 8 - * +\nResult: -27");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("3 + 5 * (2 - 8)");
        System.out.println("=========================================");

        System.out.println("================ Test 02 ================");
        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(2 + 3)) * ((4 - 1)");
        System.out.println("=========================================");

        System.out.println("================ Test 03 ================");
        System.out.println("This should print:");
        System.out.println("Postfix: 7 6 5 2 ^ * 3 + + 4 2 / -\nResult: 158");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("7 + (6 * 5^2 + 3) - (4 / 2)");
        System.out.println("=========================================");

        System.out.println("================ Test 04 ================");
        System.out.println("This should print:");
        System.out.println("Postfix: 10 2 + 6 * 3 /\nResult: 24");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(10 + 2) * 6 / 3");
        System.out.println("=========================================");

        System.out.println("================ Test 05 ================");
        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("[2 + 3) * (4 - (5 * 6))]");
        System.out.println("=========================================");
    }
}
