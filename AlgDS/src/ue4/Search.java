package ue4;

public abstract class Search {

	protected CountingComparator comparator;

	public Search() {
		this.comparator = new CountingComparator();
	}

	public abstract boolean search(Long[] sortedList, Long key);

	public int getNumberOfComparisons() {
		return comparator.getNumberOfComparisons();
	}
}
