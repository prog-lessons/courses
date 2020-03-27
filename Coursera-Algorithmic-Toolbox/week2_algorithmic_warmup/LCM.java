import java.util.Scanner;

public class LCM
{
	private static long lcm_naive(int a, int b)
	{
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0) return l;

		return (long) a * b;
	}

	private static long lcm(int a, int b)
	{
		return (long) ((long) a * b) / gcd(a, b);
	}

	private static long gcd(int a, int b)
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

		System.out.println(lcm(a, b));
		scanner.close();
	}
}
