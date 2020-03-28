import java.util.Scanner;

public class CarFueling
{
	static int computeMinRefills(int n, int tank, int[] stops)
	{
		int numRefills = 0, curRefill = 0, lastRefill;

		while (curRefill <= n)
		{
			lastRefill = curRefill;

			while (curRefill <= n && stops[curRefill + 1] - stops[lastRefill] <= tank)
			{
				curRefill++;
			}

			if (curRefill == lastRefill) return -1;

			if (curRefill <= n) numRefills++;
		}

		return numRefills;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n + 2];
		for (int i = 1; i < n + 1; i++)
		{
			stops[i] = scanner.nextInt();
		}

		stops[stops.length - 1] = dist;

		scanner.close();

		System.out.println(computeMinRefills(n, tank, stops));
	}
}
