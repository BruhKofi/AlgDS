package ue4;

import java.util.Comparator;

public class CountingComparator implements Comparator<Long> {

	private int numberOfComparisons;

	public CountingComparator() {
		this.numberOfComparisons = 0;
	}

	@Override
	public int compare(Long o1, Long o2) {
		numberOfComparisons++;
		return o1.compareTo(o2);
	}

	public int getNumberOfComparisons() {
		return numberOfComparisons;
	}
}
