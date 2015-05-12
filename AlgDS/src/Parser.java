/**
 * A class for parsing arithmetic expressions
 */

import java.math.BigInteger;

class Element {
	private Element next;
	private Object value;

	public Element(Object value) {
		this.value = value;
		next = null;
	}

	public Object getValue() {
		return value;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return getValue().toString();
	}

}

public class Parser {

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

	/**
	 * Returns true if the arithmetic expression is well-formed
	 * 
	 * @param expression
	 *            the expression that is to be checked
	 * @return true if the arithmetic expression is well-formed
	 */
	private static boolean isWellFormed(String expression) {

		// TODO: implementation of well-formedness check

		return false;
	}

	/**
	 * Returns the result of a given arithmetic expression
	 * 
	 * @param expression
	 *            a given arithmetic expression that is to be computed
	 * @return the result of a given arithmetic expression
	 */
	private static BigInteger compute(String expression) {

		// TODO: implementation of computation
		return new BigInteger("0");
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
