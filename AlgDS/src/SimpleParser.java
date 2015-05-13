
	public class SimpleParser {


	    /**
	     * An object of type ParseError represents a syntax error found in 
	     * the user's input.
	     */
	    private static class ParseError extends Exception {
	        ParseError(String message) {
	            super(message);
	        }
	    } // end nested class ParseError


		public static String parse(String expression) {

	        while (true) {
	            System.out.println("\n\nEnter a fully parenthesized expression,");
	            System.out.println("or press return to end.");
	            System.out.print("\n?  ");
	            if ( TextIO.peek() == '\n' )
	                break;
	            try {
	                double val = expressionValue();
	                TextIO.skipBlanks();
	                if ( TextIO.peek() != '\n' )
	                    throw new ParseError("Extra data after end of expression.");
	                TextIO.getln();
	                System.out.println("\nValue is " + val);
	            }
	            catch (ParseError e) {
	                System.out.println("\n*** Error in input:    " + e.getMessage());
	                System.out.println("*** Discarding input:  " + TextIO.getln());
	            }
	        }

	        System.out.println("\n\nDone.");

	    } // end main()


	    /**
	     * Read an expression from the current line of input and return its value.
	     * @throws ParseError if the input contains a syntax error
	     */
	    private static double expressionValue() throws ParseError {
	        if ( Character.isDigit(TextIO.peek()) ) {
	                // The next item in input is a number, so the expression
	                // must consist of just that number.  Read and return
	                // the number.
	            return TextIO.getDouble();
	        }
	        else if ( TextIO.peek() == '(' ) {
	                // The expression must be of the form 
	                //         "(" <expression> <operator> <expression> ")"
	                // Read all these items, perform the operation, and
	                // return the result.
	            TextIO.getAnyChar();  // Read the "("
	            double leftVal = expressionValue();  // Read and evaluate first operand.
	            char op = getOperator();             // Read the operator.
	            double rightVal = expressionValue(); // Read and evaluate second operand.
	            TextIO.skipBlanks();
	            if ( TextIO.peek() != ')' ) {
	                    // According to the rule, there must be a ")" here.
	                    // Since it's missing, throw a ParseError.
	                throw new ParseError("Missing right parenthesis.");
	            }
	            TextIO.getAnyChar();  // Read the ")"
	            switch (op) {   //  Apply the operator and return the result. 
	            case '+':  return leftVal + rightVal;
	            case '-':  return leftVal - rightVal;
	            case '*':  return leftVal * rightVal;
	            case '/':  return leftVal / rightVal;
	            default:   return 0;  // Can't occur since op is one of the above.
	            // (But Java syntax requires a return value.)
	            }
	        }
	        else {
	            throw new ParseError("Encountered unexpected character, \"" + 
	                    TextIO.peek() + "\" in input.");
	        }
	    } // end expressionValue()


	    /**
	     * If the next character in input is one of the legal operators,
	     * read it and return it.  Otherwise, throw a ParseError.
	     */
	    static char getOperator() throws ParseError {
	        TextIO.skipBlanks();
	        char op = TextIO.peek(); 
	        if ( op == '+' || op == '-' || op == '*' || op == '/' ) {
	            TextIO.getAnyChar();
	            return op;
	        }
	        else if (op == '\n')
	            throw new ParseError("Missing operator at end of line.");
	        else
	            throw new ParseError("Missing operator.  Found \"" +
	                    op + "\" instead of +, -, *, or /.");
	    } // end getOperator()


	} // end class SimpleParser1
	
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
