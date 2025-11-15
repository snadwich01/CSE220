public class StackAndQueueAssgnTaskTester {

    public static void evalMathExpression(String expression) {
        int len = expression.length();

        // Step 1: Check parentheses balance
        Stack parenCheck = new Stack();
        
        for(int i = 0; i < len; i++) {
            char check = expression.charAt(i);

            if(check == '(' || check == '{' || check == '[') {
                parenCheck.push(check);
            } else if(check == ')' || check == '}' || check == ']'){
                if(parenCheck.isEmpty()) {
                    System.out.println("Invalid Expression");
                    return;
                }
                char open = (char) parenCheck.pop();
                
                if((check == ')' && open != '(') || 
                   (check == '}' && open != '{') || 
                   (check == ']' && open != '[')) {
                    System.out.println("Invalid Expression");
                    return;
                }
            }
        }
        
        // Check for leftover opening brackets
        if(!parenCheck.isEmpty()) {
            System.out.println("Invalid Expression");
            return;
        }

        // Step 2: Convert infix to postfix
        Stack operatorStack = new Stack();
        Queue postfixQueue = new Queue();
        
        String currentNumber = "";
        
        for(int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            
            // Skip spaces
            if(ch == ' ') {
                if(!currentNumber.equals("")) {
                    postfixQueue.enqueue(currentNumber);
                    currentNumber = "";
                }
                continue;
            }
            
            // If digit, build the number
            if(Character.isDigit(ch)) {
                currentNumber += ch;
            } else {
                // Save any number we were building
                if(!currentNumber.equals("")) {
                    postfixQueue.enqueue(currentNumber);
                    currentNumber = "";
                }
                
                // Handle opening brackets
                if(ch == '(' || ch == '{' || ch == '[') {
                    operatorStack.push(ch);
                }
                // Handle closing brackets
                else if(ch == ')' || ch == '}' || ch == ']') {
                    char openBracket = (ch == ')') ? '(' : (ch == '}') ? '{' : '[';
                    
                    while(!operatorStack.isEmpty()) {
                        char top = (char) operatorStack.pop();
                        if(top == openBracket) {
                            break;
                        }
                        postfixQueue.enqueue(String.valueOf(top));
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
                    while(!operatorStack.isEmpty()) {
                        char top = (char) operatorStack.peek();
                        
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
                            operatorStack.pop();
                            postfixQueue.enqueue(String.valueOf(top));
                        } else {
                            break;
                        }
                    }
                    operatorStack.push(ch);
                }
            }
        }
        
        // Add last number if any
        if(!currentNumber.equals("")) {
            postfixQueue.enqueue(currentNumber);
        }
        
        // Pop remaining operators
        while(!operatorStack.isEmpty()) {
            char op = (char) operatorStack.pop();
            postfixQueue.enqueue(String.valueOf(op));
        }
        
        // Step 3: Print postfix
        System.out.print("Postfix: ");
        Queue tempQueue = new Queue();
        while(!postfixQueue.isEmpty()) {
            String item = (String) postfixQueue.dequeue();
            System.out.print(item + " ");
            tempQueue.enqueue(item);
        }
        System.out.println();
        
        // Step 4: Evaluate postfix
        Stack evalStack = new Stack();
        
        while(!tempQueue.isEmpty()) {
            String token = (String) tempQueue.dequeue();
            
            // If it's a number, push it
            if(Character.isDigit(token.charAt(0))) {
                evalStack.push(Double.parseDouble(token));
            } else {
                // It's an operator, pop two operands
                double operand2 = (double) evalStack.pop();
                double operand1 = (double) evalStack.pop();
                double result = 0;
                
                switch(token.charAt(0)) {
                    case '+': result = operand1 + operand2; break;
                    case '-': result = operand1 - operand2; break;
                    case '*': result = operand1 * operand2; break;
                    case '/': result = operand1 / operand2; break;
                    case '^': result = Math.pow(operand1, operand2); break;
                }
                
                evalStack.push(result);
            }
        }
        
        double finalResult = (double) evalStack.pop();
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
