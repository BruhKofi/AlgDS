package ue;

public class UE1a41 {

	public static boolean p(int N, int[] a, int[] b) {
		boolean[] ac = new boolean[N + 1];
		boolean[] bc = new boolean[N + 1];
		boolean result = true;

		for (int i = 1; i <= N; i++) {
			ac[a[i]] = true;
			bc[b[i]] = true;
		}

		System.out.println("Auswertung:");
		for (int i = 1; i <= N; i++) {
			if (ac[i] != bc[i]) {
				result = false;
			};
			System.out.print(i + ":(" + ac[i] + "|" + bc[i] + ") ");
		}

		return result;
	}

	public static void main(String[] args) {
		final int N = 5;

		int[] a = new int[N + 1];
		int[] b = new int[N + 1];

		// init

		for (int count = 1; count <= N; count++) {
			a[count] = (int) (N * Math.random()) + 1;
			System.out.print(count + ": " + a[count] + "|");
		}
		System.out.println(" <> N:" + N);

		for (int count = 1; count <= N; count++) {
			b[count] = (int) (N * Math.random()) + 1;
			System.out.print(count + ": " + b[count] + "|");
		}
		System.out.println(" <> N:" + N);

		System.out.println(p(N, a, b));
	}

}
