package ue4;

public class FibonacciSearch extends Search {

	@Override
	public boolean search(Long[] sortedList, Long key) {
		comparator = new CountingComparator();
		int l = 0;
		int r = sortedList.length - 1;
		final int N = sortedList.length;
		int m = 0;
		int comparison = 0;
		int swap = 0;

		// compute max fib - first fib0 > r
		int fib2 = 1;
		int fib1 = 1;
		int fib0 = 2;
		while (fib0 <= N) {
			fib2 = fib1;
			fib1 = fib0;
			fib0 = fib1 + fib2;
		}

		// and now search...
		while (fib0 > 1) {

			m = l + fib2;
			if (m > N) { // secure array outofbound
				m = N;
			};

			// System.out.println("fib2:" + fib2 + " fib1:" + fib1 + " fib0:"
			// + fib0);
			comparison = comparator.compare(key, sortedList[m - 1]);
			// System.out.println("key:" + key + " sl(m):" + sortedList[m - 1]
			// + " compare:" + comparison);
			if (comparison < 0) { // c<A[m] - c in [l,fib2-1]
				r = fib2 - 1;
				fib0 = fib2;
				fib1 = fib1 - fib2;
				fib2 = fib0 - fib1;
			} else if (comparison > 0) { // c>A[m] - c in [l+fib2+1,l+fib-1]
				l = m;
				fib0 = fib1;
				fib1 = fib2;
				fib2 = fib0 - fib1;
			} else {
				return true;
			}
		}
		return false;
	}

}
