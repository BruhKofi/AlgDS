package ue;

public class UE1a32 {

	public static int p(int[] a, int i, int j) {
		int x = 0;

		if (j - i <= 1) {
			x = a[i];
		} else {
			x = p(a, i + 1, j - 1);
		}

		return x;
	}

	public static void main(String[] args) {
		final int N = 15;
		int i, j = 0;
		int[] a = new int[N + 1];
		// init

		for (int count = 1; count <= N; count++) {
			a[count] = (int) (100 * Math.random());
			System.out.print(count + ": " + a[count] + "|");
		}

		i = (int) (N * Math.random());
		j = (int) ((N - i) * Math.random() + i);

		i = 1;
		j = N;
		
		System.out.println(" <> N:" + N + " i:" + i + " j:" + j);

		System.out.println(p(a, i, j));
	}

}
