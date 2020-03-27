import java.util.Scanner;

public class Fibonacci
{
	private static long calc_fib(int n)
	{
		if (n <= 1) return n;

		long i = 0, j = 1, k = 0;
		int x = 2;

		/*
		1 1 2 3 5 8
		 
		i j k
		1 1 2
		1 2 3
		2 3 5
		*/

		while (x <= n)
		{
			k = i + j;
			i = j;
			j = k;
			x++;
		}

		return k;
	}

	public static void main2(String args[])
	{
		/*
		for (int n = 0; n <= 8; n++) System.out.println(n + " " + calc_fib(n));
		*/

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(calc_fib(n));
		in.close();

	}
}
