import java.util.Stack;

public class StackUser {

	public static void main(String[] args) {
		System.out.println("Beginne mit leerer Liste:");
		Stack stack = new Stack();
		stack.push(new Item("as"));
		stack.push(new Item("you"));
		System.out.println("\t" + stack);

	}

}
