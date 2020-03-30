import java.util.Scanner;

public class PlacingParentheses
{
	private static long[] MinAndMax(int i, int j, long[][] M, long[][] m, char[] ops)
	{
		long[] min_max = new long[2];

		long min = (long) Double.POSITIVE_INFINITY, max = (long) Double.NEGATIVE_INFINITY;

		long a, b, c, d;

		for (int k = i; k <= j - 1; k++)
		{
			a = eval(M[i][k], M[k + 1][j], ops[k]);
			b = eval(M[i][k], m[k + 1][j], ops[k]);
			c = eval(m[i][k], M[k + 1][j], ops[k]);
			d = eval(m[i][k], m[k + 1][j], ops[k]);

			min = Math.min(min, Math.min(Math.min(a, b), Math.min(c, d)));
			max = Math.max(max, Math.max(Math.max(a, b), Math.max(c, d)));
		}
		min_max[0] = min;
		min_max[1] = max;

		return min_max;
	}

	private static long getMaximValue(String exp)
	{
		int[] digits = new int[(exp.length() / 2) + 1];
		char[] ops = new char[digits.length - 1];

		int n, i;
		String digit;

		for (n = 0, i = 0; n <= exp.length() - 3; n += 2, i++)
		{
			digit = "" + exp.charAt(n);
			digits[i] = Integer.parseInt(digit);
			ops[i] = exp.charAt(n + 1);
		}
		digit = "" + exp.charAt(n);
		digits[i] = Integer.parseInt(digit);

		n = digits.length;

		long[][] M = new long[n][n]; //Maximum values
		long[][] m = new long[n][n]; //Minimum values

		for (i = 0; i < n; i++)
		{
			M[i][i] = digits[i];
			m[i][i] = M[i][i];
		}

		int j;

		long min_max[] = new long[2];

		for (int s = 0; s < n; s++)
			for (i = 0; i < n - s - 1; i++)
			{
				j = i + s + 1;
				min_max = MinAndMax(i, j, M, m, ops);
				m[i][j] = min_max[0];
				M[i][j] = min_max[1];
			}

		return M[0][n - 1];
	}

	private static long eval(long a, long b, char op)
	{
		if (op == '+')
		{
			return a + b;
		}
		else
			if (op == '-')
			{
				return a - b;
			}
			else
				if (op == '*')
				{
					return a * b;
				}
				else
				{
					assert false;
					return 0;
				}
	}

	public static void main(String[] args)
	{
		//System.out.println(getMaximValue("2+3*7+4-9"));
		//System.out.println(getMaximValue("5-8+7*4-8+9"));

		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		scanner.close();
		System.out.println(getMaximValue(exp));
	}
}
