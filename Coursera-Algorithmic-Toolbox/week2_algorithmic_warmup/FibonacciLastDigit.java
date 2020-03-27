import java.util.Scanner;

public class FibonacciLastDigit
{
	static int fibo_l_digs[] = new int[60];

	private static int getFibonacciLastDigitNaive(int n)
	{
		if (n <= 1) return n;

		int previous = 0;
		int current = 1;

		for (int i = 0; i < n - 1; ++i)
		{
			int tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % 10;
	}

	private static void storeFiboLastDigits()
	{
		long i = 0, j = 1, k = 0;
		int x = 2;

		fibo_l_digs[0] = 0;
		fibo_l_digs[1] = 1;

		while (x <= 59)
		{
			k = i + j;
			fibo_l_digs[x] = (int) ((long) (k % 10));
			i = j;
			j = k;
			x++;
		}
	}

	private static int getFibonacciLastDigit(int n)
	{
		return fibo_l_digs[n % 60];
	}

	public static void main(String[] args)
	{
		storeFiboLastDigits();

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//int c = getFibonacciLastDigitNaive(n);

		int c = getFibonacciLastDigit(n);

		System.out.println(c);
		scanner.close();
	}
}
