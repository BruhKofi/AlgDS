package ue4;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Search search;
		Random random = new Random(1l);

		System.out.println("Preliminary testing. Initializing list [1, 2, 3].");
		Long[] list = {1l, 2l, 3l};
		System.out
				.println("Searching for Element \"0\", which should not be found.");
		search = new LinearSearch();
		boolean located = search.search(list, 0l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 0l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 0l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 0l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		System.out
				.println("Searching for Element \"1\", which should be found.");
		search = new LinearSearch();
		located = search.search(list, 1l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"1\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 1l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"1\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 1l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"1\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 1l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"1\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		System.out
				.println("Searching for Element \"2\", which should be found.");
		search = new LinearSearch();
		located = search.search(list, 2l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"2\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 2l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"2\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 2l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"2\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 2l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"2\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		System.out
				.println("Searching for Element \"3\", which should be found.");
		search = new LinearSearch();
		located = search.search(list, 3l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"3\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 3l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"3\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 3l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"3\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 3l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"3\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		System.out
				.println("Searching for Element \"4\", which should not be found.");
		search = new LinearSearch();
		located = search.search(list, 4l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"4\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 4l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"4\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 4l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"4\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 4l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"4\" ("
				+ search.getNumberOfComparisons() + " comparisons).");

		System.out
				.println("\nInitializing pseudo-randomized, sorted list with one million elements. The list starts with a zero and neighboring elements have a difference of 0-2.");
		list = new Long[1000000];
		list[0] = 0l;
		for (int i = 1; i < list.length; i++) {
			list[i] = list[i - 1] + random.nextInt(3);
		}
		System.out
				.println("Searching for Element \"0\", which should be the first element.");
		search = new LinearSearch();
		located = search.search(list, 0l);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, 0l);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, 0l);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, 0l);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \"0\" ("
				+ search.getNumberOfComparisons() + " comparisons).");

		System.out.println("Searching for the 300.000th element of the list.");
		search = new LinearSearch();
		located = search.search(list, list[300000]);
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate") + " element \""
				+ list[300000].intValue() + "\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new BinarySearch();
		located = search.search(list, list[300000]);
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate") + " element \""
				+ list[300000].intValue() + "\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, list[300000]);
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate") + " element \""
				+ list[300000].intValue() + "\" ("
				+ search.getNumberOfComparisons() + " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, list[300000]);
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate") + " element \""
				+ list[300000].intValue() + "\" ("
				+ search.getNumberOfComparisons() + " comparisons).");

		System.out
				.println("\nInitializing list with 63 elements. The list starts with a one and following elements have 2 times the value of its predecessor.");
		list = new Long[63];
		list[0] = 1l;
		for (int i = 1; i < list.length; i++) {
			list[i] = list[i - 1] * 2l;
		}
		System.out
				.println("Searching for Element \"2^31\", which should be right in the middle.");
		search = new LinearSearch();
		located = search.search(list, (long) Math.pow(2d, 31d));
		System.out.println("\tLinear search:        "
				+ (located ? "located" : "did not locate")
				+ " element \"2^31\" (" + search.getNumberOfComparisons()
				+ " comparisons).");
		search = new BinarySearch();
		located = search.search(list, (long) Math.pow(2d, 31d));
		System.out.println("\tBinary search:        "
				+ (located ? "located" : "did not locate")
				+ " element \"2^31\" (" + search.getNumberOfComparisons()
				+ " comparisons).");
		search = new FibonacciSearch();
		located = search.search(list, (long) Math.pow(2d, 31d));
		System.out.println("\tFibonacci search:     "
				+ (located ? "located" : "did not locate")
				+ " element \"2^31\" (" + search.getNumberOfComparisons()
				+ " comparisons).");
		search = new InterpolationSearch();
		located = search.search(list, (long) Math.pow(2d, 31d));
		System.out.println("\tInterpolation search: "
				+ (located ? "located" : "did not locate")
				+ " element \"2^31\" (" + search.getNumberOfComparisons()
				+ " comparisons).");
	}
}