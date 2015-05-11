/**
 * An element of a list that stores a Java object alongside pointers to the previous and next element.
 */
public class Element {
	private Object value;
	private Element prev, next;

	public Element(Object value) {
		this.value = value;
		prev = next = null;
	}

	/**
	 * Returns the value of this element.
	 * 
	 * @return the value of this element
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Returns the element next to this element.
	 * 
	 * @return the element next to this element
	 */
	public Element getNext() {
		return next;
	}

	/**
	 * Returns the element previous to this element.
	 * 
	 * @return the element previous to this element
	 */
	public Element getPrev() {
		return prev;
	}

	/**
	 * Assigns an element as being next to this element.
	 * 
	 * @param next
	 *            the element which is to be assigned as being next to this element
	 */
	public void setNext(Element next) {
		this.next = next;
	}

	/**
	 * Assigns an element as being previous to this element.
	 * 
	 * @param prev
	 *            the element which is to be assigned as being previous to this element
	 */
	public void setPrev(Element prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return getValue().toString();
	}
}
