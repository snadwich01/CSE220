public static void evalMathExpression(String expression) {

    // ---------- STEP 1: CHECK BALANCED PARENTHESES ----------
    Stack stack = new Stack();

    for (int i = 0; i < expression.length(); i++) {
        char ch = expression.charAt(i);

        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        }
        else if (ch == ')' || ch == ']' || ch == '}') {
            if (stack.isEmpty()) {
                System.out.println("Invalid Expression");
                return;
            }

            char open = (char) stack.pop();

            if ((ch == ')' && open != '(') ||
                (ch == ']' && open != '[') ||
                (ch == '}' && open != '{')) {

                System.out.println("Invalid Expression");
                return;
            }
        }
    }

    if (!stack.isEmpty()) {
        System.out.println("Invalid Expression");
        return;
    }

    // ---------- STEP 2: INFIX → POSTFIX USING STACK + QUEUE ----------
    Stack opStack = new Stack();
    LinkedListQueue output = new LinkedListQueue();

    // precedence helper
    java.util.HashMap<Character, Integer> prec = new java.util.HashMap<>();
    prec.put('+', 1);
    prec.put('-', 1);
    prec.put('*', 2);
    prec.put('/', 2);
    prec.put('^', 3);

    for (int i = 0; i < expression.length(); i++) {
        char ch = expression.charAt(i);

        if (Character.isWhitespace(ch)) continue;

        // --- number (multi-digit) ---
        if (Character.isDigit(ch)) {
            String num = "";
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num += expression.charAt(i);
                i++;
            }
            i--;
            output.enqueue(num);
        }

        // --- opening bracket ---
        else if (ch == '(' || ch == '[' || ch == '{') {
            opStack.push(ch);
        }

        // --- closing bracket ---
        else if (ch == ')' || ch == ']' || ch == '}') {
            while (!opStack.isEmpty() &&
                   !isMatchingOpen((char)opStack.peek(), ch)) {
                output.enqueue(opStack.pop());
            }
            opStack.pop(); // remove the matching opening bracket
        }

        // --- operator ---
        else if ("+-*/^".indexOf(ch) != -1) {
            while (!opStack.isEmpty() &&
                    isOperator((char)opStack.peek()) &&
                    prec.get((char)opStack.peek()) >= prec.get(ch)) {

                output.enqueue(opStack.pop());
            }
            opStack.push(ch);
        }

    }

    // pop remaining operators
    while (!opStack.isEmpty()) {
        output.enqueue(opStack.pop());
    }

    // ---------- PRINT POSTFIX ----------
    System.out.print("Postfix: ");
    LinkedListQueue tempQ = new LinkedListQueue();

    while (!output.isEmpty()) {
        Object e = output.dequeue();
        System.out.print(e + " ");
        tempQ.enqueue(e);   // save for evaluation
    }
    System.out.println();

    // ---------- STEP 3: EVALUATE POSTFIX ----------
    Stack eval = new Stack();

    while (!tempQ.isEmpty()) {
        String token = tempQ.dequeue().toString();

        if (token.matches("-?\\d+")) {  
            eval.push(Integer.parseInt(token));
        } else {
            int b = (int) eval.pop();
            int a = (int) eval.pop();

            int res = 0;
            switch (token) {
                case "+": res = a + b; break;
                case "-": res = a - b; break;
                case "*": res = a * b; break;
                case "/": res = a / b; break;
                case "^": res = (int)Math.pow(a, b); break;
            }
            eval.push(res);
        }
    }

    System.out.println("Result: " + eval.pop());
}


// ---------- SMALL HELPER METHODS ----------
private static boolean isMatchingOpen(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '[' && close == ']') ||
           (open == '{' && close == '}');
}

private static boolean isOperator(char c) {
    return "+-*/^".indexOf(c) != -1;
}
