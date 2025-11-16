
public class StackAndQueueAssgnTaskTester {

    // You have to write this method
    // YOU MUST SUBMIT THIS METHOD
    // Hint: You need to traverse each characters of the String
    public static void evalMathExpression(String expression) {
        // You can create Stack and Queue object here to use
        // To Do

        int len = expression.length();

        //checking stacktheses
        Stack stack = new Stack();
        LinkedListQueue queue = new LinkedListQueue();

        for(int i = 0; i < len; i++) {
            char check = expression.charAt(i);

            if(check == '(' || check == '{' || check == '[') {
                stack.push(check); //create stack
            } else if(check == ')' || check == '}' || check == ']'){

                if(stack.peek() == null) {
                    //if no open stacktheses in stack
                    System.out.println("Invalid Expression");
                    return;
                }

                char open = (char) stack.pop();
                
                if((check == ')' && open != '(') || (check == '}' && open != '{') || (check == ']' && open != '[')) {
                    //if no matching parentheses in stack
                    System.out.println("Invalid Expression");
                    return;
                }
            }
            
        //parentheses check complete
        }

        //for leftover openings
        if(stack.peek() != null) {
            System.out.println("Invalid Expression");
            return;
        }


        //CONVERSIONNN  (INFIX -> POSTFIX) AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        String num = "";
        int queueCount = 0;

        for(int i = 0; i < len; i++) {
            char check = expression.charAt(i);

            //NUMBERS----------------------------------------------------
            if(check == ' ') {
                if(num.length() > 0) {
                    queue.enqueue(num);
                    queueCount++;
                    num = "";
                }
            } else if(check >= '0' && check <= '9') {
                num = num + check;
            } else {
                if(num.length() > 0) {
                    queue.enqueue(num);
                    queueCount++;
                    num = "";
                }

                //BRACKETS-----------------------------------------------
                if(check == '(' || check == '{' || check == '[') {
                    stack.push(check);
                } else if(check == ')' || check == '}' || check == ']') {
                    while(stack.peek() != null) {
                        char lastin = (char) stack.pop();

                    if((check == ')' && lastin == '(') || (check == '}' && lastin == '{') ||(check == ']' && lastin == '[')) {
                        break;
                    }

                    String operator = "";
                    operator = operator + lastin;
                    queue.enqueue(operator);
                    queueCount++;
                    }
                } //OPERATORS--------------------------------------------
                else if(check == '+' || check == '-' || check == '*' || check == '/' || check == '^') {
                    int order = 0;
                    if(check == '^') {
                        order = 3;
                    } else if (check == '*' || check == '/') {
                        order = 2;
                    } else if(check == '+' || check == '-') {
                        order = 1;
                    }

                    while(stack.peek() != null) {
                        char lastin = (char) stack.peek();

                        if(lastin == '(' || lastin == '{' || lastin == '[') {
                            break;
                        }

                        int lastorder = 0;

                    if(lastin == '^') {
                        lastorder = 3;
                    } else if (lastin == '*' || lastin == '/') {
                        lastorder = 2;
                    } else if(lastin == '+' || lastin == '-') {
                        lastorder = 1;
                    }

                    if(lastorder > order || (lastorder == order && check != '^')) {
                        stack.pop();
                        String op = "";
                        op = op + lastin;
                        queue.enqueue(op);
                        queueCount++;
                    } else {
                        break;
                    }
                    }
                    stack.push(check);
                }
            }
        }

        if(num.length() > 0) {
            queue.enqueue(num);
            queueCount++;
        }

        while(stack.peek() != null) {
            char op = (char) stack.pop();
            String opera = "";
            opera = opera + op;
            queue.enqueue(opera);
            queueCount++;
        }

        //print----------------------------------------------------------
        System.out.print("Postfix: ");
        for(int i = 0; i < queueCount; i++) {  // ← USE COUNTER FOR ROTATION
            String data = (String) queue.dequeue();
            System.out.print(data + " ");
            queue.enqueue(data);  // ← ROTATE: enqueue back immediately
        }
        System.out.println();

        //EVAL------------------------------------------------------------
        while(!queue.isEmpty()) {
            String token = (String) queue.dequeue();
            char first = token.charAt(0);
            
            //number---------------------------
            if(first >= '0' && first <= '9') {
                double n = Integer.parseInt(token);
                stack.push(n);
            } else { //smooth operator----------
                double num1 = (double) stack.pop();
                double num2 = (double) stack.pop();
                double res = 0;
                char op = token.charAt(0);
                
                if(op == '+') {
                    res = num1 + num2;
                } else if(op == '-') {
                    res = num2 - num1;
                } else if(op == '*') {
                    res = num1 * num2;
                } else if(op == '/') {
                    res = num2 / num1;
                } else if(op == '^') {
                    res = 1;
                    for(int k = 0; k < (int)num1; k++) {
                        res = res * num2;
                    }
                }
                stack.push(res);
            }
        }

        double finalres = (double) stack.pop();
        System.out.println("Result: " + (int)finalres);

    }

    // DO NOT CHANGE ANYTHING IN THE DRIVER CODE
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
