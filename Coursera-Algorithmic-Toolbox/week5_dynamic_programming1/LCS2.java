import java.util.Scanner;

public class LCS2
{

	private static int lcs2(int[] a, int[] b)
	{
		//Write your code here
		int n_rows = b.length + 1;
		int n_cols = a.length + 1;

		int[][] L = new int[n_rows][n_cols];

		for (int i = 1; i < n_rows; i++)
			for (int j = 1; j < n_cols; j++)
				if (a[j - 1] == b[i - 1])
					L[i][j] = 1 + L[i - 1][j - 1];
				else
					L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);

		//return Math.min(a.length, b.length);
		return L[b.length][a.length];
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
		{
			a[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++)
		{
			b[i] = scanner.nextInt();
		}

		scanner.close();
		System.out.println(lcs2(a, b));
	}
}
