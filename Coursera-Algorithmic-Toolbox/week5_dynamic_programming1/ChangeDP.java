import java.util.Scanner;

public class ChangeDP
{
	private static int getChange(int m)
	{
		int[] coins = { 1, 3, 4 };

		int[] ways = new int[m + 1];
		int k = 0;

		for (int i = 1; i <= m; i++)
		{
			ways[i] = (int) Double.POSITIVE_INFINITY;
			for (int j = 0; j < coins.length; j++)
				if (i >= coins[j])
				{
					k = ways[i - coins[j]] + 1;
					if (k < ways[i]) ways[i] = k;
				}
		}
		return ways[m];
	}

	private static int fibo(int n)
	{
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		int i = 2;

		while (i <= n)
		{
			f[i] = f[i - 1] + f[i - 2];
			//f[i - 2] = f[i - 1];
			//f[i - 1] = f[i];
			i++;
		}
		return f[n];
	}

	public static void main(String[] args)
	{
		//System.out.println(getChange(11));

		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));
		scanner.close();

		//System.out.println(fibo(6));
	}
}
