import java.util.Scanner;

public class Knapsack
{
	static int optimalWeight(int W, int[] w)
	{
		int n = w.length;

		int[][] v = new int[n + 1][W + 1];
		int val = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= W; j++)
			{
				v[i][j] = v[i - 1][j];

				if (w[i - 1] <= j)
				{
					val = v[i - 1][j - w[i - 1]] + w[i - 1];
					if (v[i][j] < val) v[i][j] = val;
				}
			}

		return v[n][W];
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++)
			w[i] = scanner.nextInt();
		scanner.close();
		System.out.println(optimalWeight(W, w));
	}
}
