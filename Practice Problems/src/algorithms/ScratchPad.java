package algorithms;

import java.util.*;

public class ScratchPad
{
	public static void main(String[] args)
	{	
		/*
		int [] array = new int[] {1, 3, 0, 5};
		int a = array[0];
		System.out.println(Arrays.toString(array));
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == 0)
			{
				a = array[i];
			}
			
			int temp = array[i];
			array[i] = a;
			a = temp;
		}
		System.out.println(Arrays.toString(array));
		*/
		
		String[] words = {"b", "a", "c", "H", "h", "S"};
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println(Math.ceil(2.5));
	}
}
