import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting
{
	private static Random random = new Random();

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

	static class MyInt
	{
		public int value;
	}

	public static void main(String[] args)
	{
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = scanner.nextInt();

		HashMap<Integer, Integer> mapReps = new HashMap<Integer, Integer>();

		MyInt i = new MyInt();
		i.value = 0;

		prepare_array(a, b, i, mapReps);
		randomizedQuickSort(b, 0, i.value - 1);
		add_reps(b, a, i.value - 1, a.length, mapReps);

		for (int h = 0; h < n; h++)
		{
			System.out.print(a[h] + " ");
		}
	}

	/*private static int[] partition3(int[] a, int l, int r)
	{
		//write your code here
	
		int v[] = new int[a.length];
		int j[] = new int[a.length];
		int t[] = new int[a.length];
		int i[] = new int[3];
	
		int x = a[l];
	
		for (int n = l; n <= r; n++)
		{
			if (a[n] < x)
			{
				v[i[0]] = a[n];
				i[0]++;
				continue;
			}
	
			if (a[n] == x)
			{
				j[i[1]] = a[n];
				i[1]++;
				continue;
			}
	
			if (a[n] > x)
			{
				t[i[2]] = a[n];
				i[2]++;
			}
		}
	
		System.arraycopy(v, 0, a, 0, i[0]);
		System.arraycopy(j, 0, a, i[0], i[1]);
		System.arraycopy(t, 0, a, i[0] + i[1], i[2]);
	
		int m1, m2;
		if (i[0] == 0)
			m1 = 0;
		else
			m1 = i[0] - 1;
	
		m2 = i[0] + i[1];
	
		int[] m = { m1, m2 };
		return m;
	}*/

	private static int partition2(int[] a, int l, int r)
	{
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++)
		{
			if (a[i] <= x)
			{
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
	}

	private static void prepare_array(int a[], int b[], MyInt nElems, HashMap<Integer, Integer> reps)
	{
		for (int k = 0; k <= a.length - 1; k++)
		{
			if (reps.containsKey(a[k]))
				reps.put(a[k], reps.get(a[k]) + 1);
			else
			{
				reps.put(a[k], 1);
				b[nElems.value] = a[k];
				nElems.value++;
			}
		}
	}

	private static void add_reps(int a[], int b[], int r, int o, HashMap<Integer, Integer> reps)
	{
		int k = 0;

		for (int i = 0; i <= r; i++)
		{
			if (reps.get(a[i]) > 1)
			{
				int j = 1;
				while (j <= reps.get(a[i]))
				{
					b[k] = a[i];
					j++;
					k++;
				}
			}
			else
			{
				b[k] = a[i];
				k++;
			}
		}
	}

	private static void randomizedQuickSort(int[] a, int l, int r)
	{
		if (l >= r) return;

		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;

		int m = partition2(a, l, r);
		randomizedQuickSort(a, l, m - 1);
		randomizedQuickSort(a, m + 1, r);

		//use partition3
	}

}
