import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement
{
	private static int countElement(int a[], int left, int right, int num)
	{
		int c = 0;
		for (int i = left; i <= right; i++)
			if (a[i] == num) c++;
		return c;
	}

	private static int getMajorityElement(int[] a, int left, int right)
	{
		if (left == right) return a[left];

		if (right - left == 1)
		{
			if (a[left] == a[right])
				return a[left];
			else
				return -1;
		}

		int mid = (int) ((right - left) / 2) + left;
		int l = getMajorityElement(a, left, mid);
		int r = getMajorityElement(a, mid + 1, right);

		if (l == r) return l;

		if (l != -1)
		{
			int j = countElement(a, left, right, l);

			if (j > (right - left + 1) / 2) return l;
		}

		if (r != -1)
		{
			int k = countElement(a, left, right, r);

			if (k > (right - left + 1) / 2) return r;
		}

		return -1;
	}

	public static void main(String[] args)
	{
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = scanner.nextInt();

		if (a.length == 1)
			System.out.println(1);
		else
		{
			if (getMajorityElement(a, 0, a.length - 1) == -1)
				System.out.println(0);
			else
				System.out.println(1);
		}

	}

	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream)
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(stream));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		String next()
		{
			while (st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
}
