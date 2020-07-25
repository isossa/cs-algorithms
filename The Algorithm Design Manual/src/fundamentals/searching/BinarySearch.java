package fundamentals.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch<T extends Comparable<T>>
{
	public static void main(String[] args)
	{
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6}));
		
		System.out.println(binarySearch(l1, 6));
	}
	
	public static int binarySearch(List<Integer> list, Integer toFind)
	{
		int left = 0;
		int right = list.size() - 1;
		
		while (left <= right)
		{
			int middle = left + (right - left) / 2;
			
			if (list.get(middle) == toFind)
			{
				return middle;
			}
			else if (toFind < list.get(middle))
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		return -1;
	}
}
