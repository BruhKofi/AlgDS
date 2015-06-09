package ue4;

public class FibonacciSearch extends Search {

	@Override
	public boolean search(Long[] sortedList, Long key) {
		comparator = new CountingComparator();
		int l = 0;
		int r = sortedList.length - 1;
		int m = 0;
		int comparison = 0;
		int swap = 0;

		// compute max fib - first fib0 > r
		int fib2 = 1;
		int fib1 = 1;
		int fib0 = 2;
		while (fib0 <= r) {
			fib2 = fib1;
			fib1 = fib0;
			fib0 = fib1 + fib2;
		}

		// and now search...
		m = fib2;

		while (true) {
			System.out
					.print("fib2:" + fib2 + " fib1:" + fib1 + " fib0:" + fib0);
			comparison = comparator.compare(key, sortedList[m]);
			System.out.println(" sl(m):" + sortedList[m] + " key:" + key);

			if (comparison < 0) {
				if (fib1 == 0) {
					return false;
				} else {
					m = m + fib1;
					swap = fib1;
					fib1 = fib2 - fib1;
					fib2 = swap;
				}
			} else if (comparison > 0) {
				if (fib2 == 1) {
					return false;
				} else {
					m = m - fib1;
					fib2 = fib2 - fib1;
					fib1 = fib1 - fib2;
				}

			} else {
				return true;
			}
		}

	}
}
