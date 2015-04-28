package ue;

public class UE1a31 {

	public static int p(int N, int[] a) {
		int x = 0;

		for (int i = 1; i <= N; i++) {
			if (a[i] > x) {
				x = a[i];
			}
			if (x > N) {
				x = N;
			}
		}

		return x;
	}

	public static void main(String[] args) {
		final int N = 15;

		int[] a = new int[N + 1];
		// init

		for (int count = 1; count <= N; count++) {
			a[count] = (int) (10 * Math.random());
			System.out.print(count + ": " + a[count] + "|");
		}

		System.out.println(" <> N:" + N);

		System.out.println(p(N, a));
	}

}
