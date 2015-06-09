package ue4;

public class BinarySearch extends Search {

	@Override
	public boolean search(Long[] sortedList, Long key) {
		comparator = new CountingComparator();
		int l = 0;
		int r = sortedList.length - 1;
		int m = 0;
		int comparison = 0;
		// System.out.println("l:" + l + " m:" + m + " r:" + r);
		while (l <= r) {
			m = l + ((r - l) / 2);
			// System.out.print("l:" + l + " m:" + m + " r:" + r);
			// System.out.println(" sl(m):" + sortedList[m] + " key:" + key);
			comparison = comparator.compare(key, sortedList[m]);
			if (comparison < 0) {
				r = m - 1;
			} else if (comparison > 0) {
				l = m + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
