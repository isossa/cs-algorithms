package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bitwise
{
	public static void main(String[] args)
	{
		int value = 2;
		System.out.println(value = value << 1);
		System.out.println(value << 1);
		System.out.println((128 | 16));
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 6, 7));
		
		Integer result[] = new Integer[list.size()];
		list.toArray(result);
		System.out.println(Arrays.toString(result));
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
	}
}
