package ue4;

public class InterpolationSearch extends Search {

	@Override
	public boolean search(Long[] sortedList, Long key) {
		comparator = new CountingComparator();
		int l = 0;
		int r = sortedList.length - 1;
		int m = 0;
		int comparison = 0;

		double pos = 0.0;
		while (key >= sortedList[l] && key <= sortedList[r]) {

			a = key - sortedList[l];
			b = sortedList[r] - sortedList[l];

			pos = ((double) a / (double) b);
			// System.out.print("a:" + a + " b: " + b + " c:" + c + " pos:" +
			// pos);

			m = (int) (l + ((r - l) * pos));
			// System.out.print(" l:" + l + " m:" + m + " r:" + r);
			// System.out.print(" sl(m):" + sortedList[m] + " key:" + key);
			comparison = comparator.compare(key, sortedList[m]);
			// System.out.println("compare:" + comparison);
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
