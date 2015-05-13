/**
 * A class for parsing arithmetic expressions
 */

import java.math.BigInteger;

public class Parser_stack {

	static Boolean DebugWell = false;
	static Boolean DebugComp = true;
	static int DebugLvl = 2;

	// Stacker
	static class Item {
		private Item next;
		private Object value;

		public Item(Object value) {
			this.value = value;
			next = null;
		}

		public Object getValue() {
			return value;
		}

		public Item getNext() {
			return next;
		}

		public void setNext(Item next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return getValue().toString();
		}

	}
	static class Queue {
		private Item first;
		private Item last;
		private int hight;

		public Queue() {
			first = last = null;
			hight = 0;
		}
		public boolean isEmpty() {
			return first == null;
		}

		public int getHeight() {
			return hight;
		}

		public void push(String text) {

			Item item = new Item(text);

			if (isEmpty()) {
				first = item;
				last = item;
			} else {
				last.setNext(item);
				last = item;
			}
			hight++;
		}

		public String pop() {
			if (isEmpty()) {
				return null;
			} else {
				hight--;
				String result = first.toString();
				first = first.getNext();
				return result;
			}
		}

		public String peek() {
			if (isEmpty()) {
				return "";
			} else {
				String result = first.toString();
				return result;
			}
		}

		public void del() {
			if (isEmpty()) {
			} else {
				hight--;
				first = first.getNext();
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			Item runningElement = first;
			while (runningElement != null) {
				sb.append(runningElement.getValue().toString());
				if (!runningElement.equals(null)) {
					sb.append(" ");
				}
				runningElement = runningElement.getNext();
			}
			sb.append("]");
			return new String(sb.toString());
		}

	}
	// Stacker

	/**
	 * Returns true if the String argument is a natural number
	 * 
	 * @param input
	 *            the number that is to be checked
	 * @return true if the String argument is a natural number
	 */
	private static boolean isNatural(String input) {
		try {
			BigInteger bi = new BigInteger(input);
			if (bi.compareTo(new BigInteger("0")) < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * Returns true if the String argument is an operator ("+", "-", "*", or
	 * "/")
	 * 
	 * @param c
	 *            the character that is to be checked
	 * @return true if the String argument is an operator ("+", "-", "*", or
	 *         "/")
	 */
	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}

		return false;
	}

	private static boolean isBracket(char c) {
		if (c == '(' || c == ')') {
			return true;
		}

		return false;
	}

	/**
	 * Returns true if the arithmetic expression is well-formed
	 * 
	 * @param expression
	 *            the expression that is to be checked
	 * @return true if the arithmetic expression is well-formed
	 */
	private static boolean isWellFormed(String expression) {

		return false;
	}
	/**
	 * Returns the result of a given arithmetic expression
	 * 
	 * @param expression
	 *            a given arithmetic expression that is to be computed
	 * @return the result of a given arithmetic expression
	 */

	private static Queue queueit(String expression) {
		Queue stack = new Queue();
		String c, dummy = "";
		if (DebugWell)
			System.out.println("Compute #" + expression + "#:");
		int cutoff = 1;

		while (expression.length() != 0) {
			c = expression.substring(0, 1);
			if (DebugWell)
				System.out.print("Analyse:" + c);

			if (isBracket(c.charAt(0))) {
				stack.push(c);
				expression = expression.substring(1);
				if (DebugWell)
					System.out.println(" pushed Bracket " + c);
			}

			if (isOperator(c.charAt(0))) {
				stack.push(c);
				expression = expression.substring(1);
				if (DebugWell)
					System.out.println(" pushed Operator " + c);
			}

			if (isNatural(c)) {
				dummy = "";
				cutoff = 0;
				if (DebugWell)
					System.out.print(" push natural ");
				do {
					if (DebugWell)
						System.out.print(c);
					dummy = dummy + c;
					cutoff++;
					if (cutoff + 1 > c.length())
						break;
					c = expression.substring(cutoff, cutoff + 1);
				} while (isNatural(c));
				stack.push(dummy);
				if (DebugWell)
					System.out.println(" finally pushed " + dummy);
				expression = expression.substring(cutoff);
			}

		}

		return stack;
	}

	// ###################################

	private static BigInteger ausdruck(Queue exp) {
		// ausdruck = term ( +|- term )

		BigInteger left = new BigInteger("0");

		left = term(exp);
		if (exp.hight > 0) {
			if (DebugLvl > 2)
				System.out.println("Ausdruck (" + exp.toString() + ")"
						+ exp.peek());
			if (exp.peek().charAt(0) == '+' || exp.peek().charAt(0) == '-') {
				switch (exp.peek().charAt(0)) {
					case '+' :
						if (DebugLvl > 2)
							System.out.println("* A+" + exp.toString() + " '"
									+ exp.peek() + "'");
						if (DebugLvl > 1)
							System.out.print(exp.peek());
						exp.del();
						left.add(term(exp));
						break;
					case '-' :
						if (DebugLvl > 2)
							System.out.println("* A-" + exp.toString() + " '"
									+ exp.peek() + "'");
						if (DebugLvl > 1)
							System.out.print(exp.peek());
						exp.del();
						left.subtract(term(exp));
						break;
				}
			}
		}
		return left;
	}

	private static BigInteger term(Queue exp) {
		// term = faktor ( *|/ faktor )
		BigInteger left = new BigInteger("0");

		left = faktor(exp);
		if (exp.hight > 0) {
			if (DebugLvl > 2)
				System.out
						.println("Term (" + exp.toString() + ")" + exp.peek());
			if (exp.peek().charAt(0) == '*' || exp.peek().charAt(0) == '/') {
				switch (exp.peek().charAt(0)) {
					case '*' :
						if (DebugLvl > 2)
							System.out.println("* T* " + exp.toString() + " '"
									+ exp.peek() + "'");
						if (DebugLvl > 1)
							System.out.print(exp.peek());
						exp.del();
						left.multiply(term(exp));
						break;
					case '/' :
						if (DebugLvl > 2)
							System.out.println("* T/ " + exp.toString() + " '"
									+ exp.peek() + "'");
						if (DebugLvl > 1)
							System.out.print(exp.peek());
						exp.del();
						left.divide(term(exp));
						break;
				}
			}
		}
		return left;
	} // term

	private static BigInteger faktor(Queue exp) {
		// faktor = number | ( ausdruck )
		// BigInteger value = new BigInteger("0");
		BigInteger value = new BigInteger("0");
		if (DebugLvl > 2)
			System.out.println("Faktor " + exp.toString() + " '" + exp.peek()
					+ "'");
		if (isNatural(exp.peek())) {
			if (DebugLvl > 2)
				System.out.println("* FN " + exp.toString() + " '" + exp.peek()
						+ "'");
			value = new BigInteger(exp.peek());
			if (DebugLvl > 1)
				System.out.print(exp.peek());
			exp.del();
		} else {
			if (exp.peek().equals("(")) {

				if (DebugLvl > 2)
					System.out.println("* F( " + exp.toString() + " '"
							+ exp.peek() + "'");
				if (DebugLvl > 1)
					System.out.print(exp.peek());
				exp.del();
				value = ausdruck(exp);
				if (exp.peek() != ")") {
					if (DebugLvl > 2)
						System.out.println("Klammerfehler");
				};
				if (DebugLvl > 2)
					System.out.println("* F) " + exp.toString() + " '"
							+ exp.peek() + "'");
				if (DebugLvl > 1)
					System.out.print(exp.peek());
				exp.del();
			} else {
				if (DebugLvl > 2)
					System.out.println("Nummer oder () erwartet");
			}
		}
		return value;
	} // factor
		// #####################

	private static BigInteger compute(String expression) {
		Queue exp = queueit(expression);
		BigInteger result = new BigInteger("0");
		System.out.println("Queue:" + exp.toString());
		System.out.println("");
		result = ausdruck(exp);

		return result;
	}
	/**
	 * Parses a given String, determines, whether it is a well-formed
	 * expression, and computes the expression
	 * 
	 * @param expression
	 *            the expression that is to be conmputed
	 * @return "expression not well-formed", if the expression is not
	 *         well-formed, "error during computation", if there was an error
	 *         during computation (e.g., division by zero), or the result of the
	 *         computation
	 */
	public static String parse(String expression) {
		try {
			if (isWellFormed(expression)) {
				try {
					BigInteger bi = compute(expression);
					return bi.toString();
				} catch (RuntimeException e) {
					return "error during computation";
				}
			}
		} catch (RuntimeException e) {
			return "expression not well-formed";
		}

		return "expression not well-formed";
	}

	public static void main(String[] args) {

		System.out.println("=" + compute("8+6"));

		System.exit(-1);

		// should print "30"
		System.out.println("((8+7)*2)\n\t" + parse("((8+7)*2)"));

		// should print "0"
		System.out.println("((8+(7-1))-14)\n\t" + parse("((8+(7-1))-14)"));

		// should print "expression not well-formed"
		System.out.println(")8+)1(())\n\t" + parse(")8+)1(())"));

		// should print "expression not well-formed"
		System.out.println("(8+())\n\t" + parse("(8+())"));

		// should print "error during computation"
		System.out.println("(8/(7-7))\n\t" + parse("(8/(7-7))"));

		// should print "8"
		System.out.println("((1+1)*(2*2))\n\t" + parse("((1+1)*(2*2))"));

		// should print "error during computation"
		System.out.println("(1/0)\n\t" + parse("(1/0)"));
	}
}
