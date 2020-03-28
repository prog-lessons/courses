import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber
{
	public static class LargerNumberComparator implements Comparator<String>
	{
		@Override
		public int compare(String a, String b)
		{
			String order1 = a + b;
			String order2 = b + a;
			//System.out.println("Comparing " + a + " <-> " + b);
			return order2.compareTo(order1);
		}
	}

	public static String largestNumber(String[] arr)
	{
		Arrays.sort(arr, new LargerNumberComparator());

		/*
		int n = arr.length;
		String temp = "";
		String xy, yx;
		
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 1; j < (n - i); j++)
			{
				xy = arr[j - 1] + arr[j];
				yx = arr[j] + arr[j - 1];
		
				if (xy.compareTo(yx) <= 0) //esquerda menor == -1, esquerda maior = 1
				{
					//swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		*/
		String result = "";

		for (String s : arr)
			result += s;

		return result;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++)
			a[i] = scanner.next();
		System.out.println(largestNumber(a));
		scanner.close();

	}
}
