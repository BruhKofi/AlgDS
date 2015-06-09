package ue4;

public class LinearSearch extends Search {

	@Override
	public boolean search(Long[] sortedList, Long key) {
		comparator = new CountingComparator();
		for (int i = 0; i < sortedList.length; i++) {
			// compare returns a negative integer, zero, or a positive integer
			// as the first argument is less than, equal to, or greater than the
			// second.
			int comparison = comparator.compare(sortedList[i], key);
			if (comparison == 0) {
				return true;
			}
		}
		return false;
	}
}
