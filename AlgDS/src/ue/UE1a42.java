package ue;

public class UE1a42 {

	public static int[] p(int N, int[] a, int[] b) {

		// INIT
		int[] result = new int[N + 1];
		int[] apos = new int[N + 1];
		int[] bpos = new int[N + 1];

		// INIT finished

		for (int i = 1; i <= N; i++) {
			apos[a[i]] = i;
			bpos[b[i]] = i;
		}

		for (int i = 1; i <= N; i++) {
			result[i] = bpos[i] - apos[i];
			if (result[i] > 0)
				result[i] = 1;
			if (result[i] == 0)
				result[i] = 2;
			if (result[i] < 0)
				result[i] = 3;
		}

		return result;
	}

	public static void main(String[] args) {
		final int N = 15;

		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		int[] c = new int[N + 1];
		int i, j, dummy = 0;

		// init

		for (int count = 1; count <= N; count++) {
			a[count] = count;
			b[count] = count;
			System.out.print(" " + count);
		}
		System.out.println("");

		for (int count = 1; count <= 10 * N; count++) {
			i = (int) (N * Math.random()) + 1;
			j = (int) (N * Math.random()) + 1;
			dummy = a[i];
			a[i] = a[j];
			a[j] = dummy;
		}

		for (int count = 1; count <= 10 * N; count++) {
			i = (int) (N * Math.random()) + 1;
			j = (int) (N * Math.random()) + 1;
			dummy = b[i];
			b[i] = b[j];
			b[j] = dummy;
		}

		for (int count = 1; count <= N; count++) {
			System.out.print(count + ": " + a[count] + "|");
		}
		System.out.println(" <> N:" + N);

		for (int count = 1; count <= N; count++) {
			System.out.print(count + ": " + b[count] + "|");
		}
		System.out.println(" <> N:" + N);

		// INIT finished

		c = (p(N, a, b));

		// output

		for (int count = 1; count <= N; count++) {
			System.out.print(count + ": " + c[count] + "|");
		}
		System.out.println(" <> N:" + N);
	}

}
