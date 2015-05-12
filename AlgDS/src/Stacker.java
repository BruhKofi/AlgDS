public class Stacker {

	class Item {
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

	class Stack {
		private Item first;
		private int hight;

		public Stack() {
			first = null;
			hight = 0;
		}
		public boolean isEmpty() {
			return first == null;
		}

		public int getHeight() {
			return hight;
		}

		public void push(Item item) {
			if (isEmpty()) {
				first = item;
			} else {
				item.setNext(first);
				first = item;
			}
			hight++;
		}

		public Item pop() {
			if (isEmpty()) {
				return null;
			} else {
				hight--;
				Item result = first;
				first = first.getNext();;
				return result;
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			Item runningElement = first;
			while (runningElement != null) {
				sb.append(runningElement.getValue().toString());
				if (!runningElement.equals(null)) {
					sb.append(", ");
				}
				runningElement = runningElement.getNext();
			}
			sb.append("]");
			return new String(sb.toString());
		}

	}

	public static void main(String[] args) {
		System.out.println("Beginne mit leerer Liste:");
		Stack stack = new Stack();
		stack.push(new Item("as"));
		stack.push(new Item("you"));
		System.out.println("\t" + stack);

	}

}
