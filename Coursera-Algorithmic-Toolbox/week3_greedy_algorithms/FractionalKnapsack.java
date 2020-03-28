import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack
{
	class OrderedValues implements Comparable<OrderedValues>
	{
		Double unit_value;
		int position;

		public int compareTo(OrderedValues ov)
		{
			if (this.unit_value < ov.unit_value) return -1;

			if (this.unit_value > ov.unit_value) return 1;

			return 0;
		}
	}

	private double getOptimalValue(int capacity, int[] values, int[] weights)
	{
		double value = 0;
		int a;

		if (capacity == 0) return value;

		ArrayList<OrderedValues> ovl = new ArrayList<OrderedValues>();

		int k = 0;
		int left_items = 0;
		for (int i : values)
		{
			OrderedValues ov = new OrderedValues();
			ov.unit_value = (double) i / weights[k];
			ov.position = k;
			ovl.add(ov);
			k++;
		}
		Collections.sort(ovl);

		int cur_item = ovl.size() - 1;

		while (true)
		{
			left_items = 0;

			for (int i : weights)
				if (i > 0)
				{
					left_items++;
					break;
				}

			if (capacity == 0 || left_items == 0) break;

			a = Math.min(weights[ovl.get(cur_item).position], capacity);

			value += (double) Math.round(((double) values[ovl.get(cur_item).position] / weights[ovl.get(cur_item).position]) * a * 1000) / 1000;

			weights[ovl.get(cur_item).position] -= a;
			capacity -= a;
			cur_item--;
		}

		return value;
	}

	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++)
		{
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		FractionalKnapsack FK = new FractionalKnapsack();
		System.out.println(FK.getOptimalValue(capacity, values, weights));
		scanner.close();
	}
}
