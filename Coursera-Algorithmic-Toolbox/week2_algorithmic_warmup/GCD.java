import java.util.Scanner;

public class GCD
{
	private static int gcd_naive(int a, int b)
	{
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d)
		{
			if (a % d == 0 && b % d == 0)
			{
				if (d > current_gcd)
				{
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	private static int gcd(int a, int b)
	{
		if (a == 0 && b == 0) return 0;
		if (a == 0 || a == b) return b;
		if (b == 0) return a;

		if (b > a)
		{
			int c = a;
			a = b;
			b = c;
		}

		int r;

		r = a % b;

		while (r > 0)
		{
			a = b;
			b = r;
			r = a % b;
		}

		return b;
	}

	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(gcd(a, b));

		scanner.close();
	}
}
