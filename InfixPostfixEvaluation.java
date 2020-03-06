/*
 * Anisha Bhattacharya
 * Godbless Chille
 * Project1
 */

public class InfixPostfixEvaluation {

	public static String infix;
	public static String output;
	public static myStack<String> opStack;

	public static myStack<Double> valStack;

	public String postFixString = "";

	public static myQueue<String> numbers;

	public static String buildNumber = "";

	public boolean flag = false;

	public int i = 0;

	public InfixPostfixEvaluation(String infix) {

		opStack = new myStack<String>(null);
		numbers = new myQueue<String>(null);
		opStack.pop();
		numbers.dequeue();
// first element of our stack and queue will be null
		this.infix = infix;
	}

	public static void ShuntingYard() {

// the top elements in my stack and queue is null, I want to remove them before
// if start using them for getting my postFix expression

		for (int i = 0; i < infix.length(); i++) {
			String currChar = "" + infix.charAt(i);// current character from the string of infix expressions

			String whitespace = "" + ' ';
			if (currChar.equals(whitespace)) {
				continue;
			}

			if (isOperator(currChar)) {

// current character is an operator
				String top = opStack.peek();
				if (currChar.equalsIgnoreCase("" + 's') || currChar.equalsIgnoreCase("" + 't')
						|| currChar.equalsIgnoreCase("" + 'c')) {
					String triangle = "" + currChar + infix.charAt(i + 1) + infix.charAt(i + 2);
					currChar = triangle;
					i += 2;
				}

				if (currChar.equals(")")) {

					top = opStack.pop();

					while (!top.equals("(")) {

						numbers.enqueue(top);
						top = opStack.pop();

					}

					continue;

				} // inner if statement ends here

				String op = currChar;

				if (currChar.equals("(") || opStack.isEmpty() || opStack.peek().equals("(")) {

					opStack.push(op);
					continue;

				}

// checking for precedence of the operators
				while (precedence(top) >= precedence(op)) {

					String x = opStack.pop();

					numbers.enqueue(x);

					top = opStack.peek();

					if (top == null || top.equals("(")) {

						break;

					}

				}

				opStack.push(op);

			} else {
// current char is a number
// building the number for the queue....happens here

				buildNumber = "";

				while (isNumber(currChar)) {

					buildNumber += currChar;

					i++;

					if (i > infix.length() - 1) {

						break;

					}

					currChar = "" + infix.charAt(i);

				}

				/*
				 *
				 * currChar is a number ==> infix[i] is a number
				 *
				 */

				i--;

// buildNumber is the full number

				numbers.enqueue(buildNumber);
				// buildNumber is the full number(including decimals)
			}

		}

// for loop is over
		while (!opStack.isEmpty()) {

			String lastOperation = opStack.pop();
			numbers.enqueue(lastOperation);

		}

		postfixEval();

	}

	public static void postfixEval() {

		// if the postfix is empty then throw an excpetion cause we have nothing!!
		if (numbers.isEmpty()) {
			throw new NullPointerException();
		}

		valStack = new myStack<Double>(null);

		while (!numbers.isEmpty()) {

			String tops = numbers.peek();

			if (isNumber(tops)) {

				valStack.push(Double.parseDouble(tops));

				numbers.dequeue();

			}

			else {

				// it is an operator

				String operator = numbers.dequeue();
				String next = numbers.peek();

				if (operator.equals("(") || operator.equals(")")) {
					System.out.println("ERROR CAUGHT!!");
					return;
				}

				// checking for a unary operator

				if (operator.equals("!") || operator.equals("sin") || operator.equals("tan")
						|| operator.equals("cos")) {
					double angle;
					double onenum = valStack.pop();

					if (operator.equals("!")) {
						if (onenum == 1.0) {
							valStack.push(0.0);
						} else {
							valStack.push(1.0);
						}
						continue;

					} else if (operator.equals("sin")) {

						angle = (returnsValueAngle("sin", onenum));
						valStack.push(angle);
						continue;

					} else if (operator.equals("cos")) {

						angle = returnsValueAngle("cos", onenum);
						valStack.push(angle);
						continue;
					} else if (operator.equals("tan")) {

						angle = returnsValueAngle("tan", onenum);
						valStack.push(angle);
						continue;
					}

				}

				double firstnumD = valStack.pop();

				double secondnumD = valStack.pop();

				double value = returnsValue(operator, firstnumD, secondnumD);

				valStack.push(value);

			}

		}

		double outputD = valStack.peek();
		output = outputD + "0";
		System.out.println(output);

	}

	public static void ShuntingAlgoException() {
		try {
			ShuntingYard();
		} catch (Exception e) {
			System.out.println("INVALID EXPRESSION!!!.......");
		}
	}

	public static double returnsValueAngle(String op, double num) {
		double radians = Math.toRadians(num);

		switch (op) {
		case "sin":
			return Math.sin(radians);
		case "tan":
			return Math.tan(radians);
		case "cos":
			return Math.cos(radians);

		default:
			return -1.0;
		}

	}

	public static double returnsValue(String op, double num1, double num2) {

		switch (op.charAt(0)) {
		case '^':
			
			return Math.pow(num2, num1);
		case '%':
			
			return num2 % num1;
		case '+':
			return num2 + num1;

		case '-':
			return num2 - num1;

		case '/':
			return num2 / num1;

		case '*':
			return num2 * num1;

// now evaluate binary operators

		case '&':
			return num2 * num1;

		case '|':
			return num2 + num1 - (num2 * num1);

		case '=':
			if (num2 == num1) {
				return 1.0;
			} else {
				return 0.0;
			}

		case '>':
			if (num2 > num1) {
				return 1.0;
			} else {
				return 0.0;
			}

// return num2>num1? 1.0: 0.0;

		case '<':
			if (num2 < num1) {
				return 1.0;
			} else {
				return 0.0;
			}

		default:
			return 0.0;

		}

	}

	private static boolean isNumber(String currChar) {

		// catch an invalid number if there is

		try {
			if ("0123456789.".contains(currChar)) {
				return true;
			}
			double temp = Double.parseDouble(currChar);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

// some functions to help

	public static boolean isOperator(String op) {

// returns true if the character sent is an operator

		char c = op.charAt(0);

		switch (c) {

		case '+':
			return true;

		case '-':
			return true;

		case '*':
			return true;

		case '/':
			return true;

		case '%':
			return true;

		case '|':
			return true;

		case '&':
			return true;

		case '!':
			return true;

		case '=':
			return true;

		case '(':
			return true;

		case ')':
			return true;

		case '>':
			return true;

		case '<':
			return true;
		case '^':
			return true;
		case 's':
			return true;
		case 't':
			return true;
		case 'c':
			return true;

		default:// if none of the characters, returns false

			return false;

		}

	}

	public boolean extraOperator(String extra) {
		switch (extra) {
		case "sin":
			return true;
		case "cos":
			return true;
		case "tan":
			return true;
		default:
			return true;
		}
	}

// test

	public void numbers() {

		String y = numbers.toString();

		System.out.println(y);

	}

	public boolean isParentheses(String op) {

		return isParentheses(op.charAt(0));

	}

	public boolean isParentheses(char c) {

		return c == '(';

	}

	public static int precedence(String op) {

		switch (op.charAt(0)) {

		case '^':
			return 10;
		case '%':
			return 7;
		case '*':
			return 8;

		case '/':
			return 8;

		case '+':
			return 6;

		case '-':
			return 6;

		case '(':
			return -10;

		case '>':
			return 5;

		case '<':
			return 5;

		case '=':
			return 5;

		case '&':
			return 4;

		case '|':
			return 3;

		case '!':
			return -1;
		case 's':
			return 9;
		case 't':
			return 9;
		case 'c':
			return 9;

		default:
			return -12;

		}

	}

	public static void main(String args[]) {

		InfixPostfixEvaluation pE = new InfixPostfixEvaluation("apple");
		// here are the test cases for invalid, saved in an array for convenience
		String[] testInvalid = { "21.1+3*2)", "", "sinsin90", "()(53+3", "", ")(3-2", "()", "3-+3", "1&&0",
				"(3-1)*(6.7-6))", "6)7" };
		// here are the test cases for valid, saved in an array for convenience
		String[] testCases = { "sin90", "sin50", "sin60", "sin 70", "sin 89", "cos90", "cos50", "cos60", "cos70",
				"cos89", "tan90", "tan50", "tan60", "tan70", "tan45", "4.6+55%2", "0.99%54", "(2+3*5)%6", "12-45/3%10",
				"344.99+23%23", "4^3", "55^2", "3*3^2", "4+5*7^4", "(44-50)^2","27^3", "3^2", "33-20-2^2" };

		System.out.println("here are the invalid test cases which give an error message");
		System.out.println();

		for (String s : testInvalid) {
			System.out.println("the expression---- " + s);
			pE = new InfixPostfixEvaluation(s);
			ShuntingAlgoException();

		}

		System.out.println();
		

		System.out.println("here are test cases which implement sin,tan,cos,modulus and exponent--extra operators");

		for (String s : testCases) {
			System.out.println("current expression: " + s);
			pE = new InfixPostfixEvaluation(s);
			ShuntingAlgoException();

		}

	}

}