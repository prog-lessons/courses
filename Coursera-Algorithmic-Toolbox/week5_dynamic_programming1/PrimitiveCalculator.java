import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator
{
	private static List<Integer> optimal_sequence(int n)
	{
		List<Integer> sequence = new ArrayList<Integer>();
		while (n >= 1)
		{
			sequence.add(n);
			if (n % 3 == 0)
			{
				n /= 3;
			}
			else
				if (n % 2 == 0)
				{
					n /= 2;
				}
				else
				{
					n -= 1;
				}
		}
		Collections.reverse(sequence);
		return sequence;
	}

	private static List<Integer> dp_sequence(int n)
	{
		int i;
		int[] v = new int[n + 1];

		v[1] = 1;
		int ops = 0;
		int min1, min2, min3;

		List<Integer> sequence = new ArrayList<Integer>();

		sequence.add(n);

		for (i = 2; i < v.length; i++)
		{
			min1 = v[i - 1];
			min2 = min1 + 1;
			min3 = min2 + 1;

			if (i % 3 == 0) min3 = v[i / 3];
			if (i % 2 == 0) min2 = v[i / 2];

			ops = Math.min(Math.min(min1, min2), min3);

			v[i] = ops + 1;
		}

		while (n > 1)
		{
			if (n % 3 == 0 || n % 2 == 0)
			{
				if (n % 3 == 0 && n % 2 == 0)
					n /= 3;
				else
					if (n % 3 == 0)
					{
						if (v[n - 1] < v[n / 3])
							n--;
						else
							n /= 3;
					}
					else
					{
						if (v[n - 1] < v[n / 2])
							n--;
						else
							n /= 2;
					}
			}
			else
				n--;

			sequence.add(n);
		}

		Collections.reverse(sequence);
		return sequence;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = dp_sequence(n);
		try
		{
			System.out.println(sequence.size() - 1);
			for (Integer x : sequence)
			{
				System.out.print(x + " ");
			}
		}
		catch (Exception e)
		{
			System.out.println(n);
		}
		scanner.close();
	}
}
