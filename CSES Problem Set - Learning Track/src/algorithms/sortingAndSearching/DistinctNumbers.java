package algorithms.sortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * PROBLEM STATEMENT
 * 
 * You are given a list of n integers, and your task is to calculate the number of distinct
 * values in the list.
 * Input: The first input line has an integer n: the number of values.
 * 		  The second line has n integers x1,x2,…,xn.
 * Output: Print one integers: the number of distinct values.
 * Constraints: 1≤n≤2*10^5
 * 				1≤xi≤10^9
 * Example
 * Input:
 * 5
 * 2 3 2 2 3
 * Output:
 * 2
 * 
 * Source: https://cses.fi/problemset/task/1621
 */
/**
 * @author Isidore Sossa
 */
public class DistinctNumbers 
{
	/**
	 * Main method.
	 * 
	 * @param args No parameter required.
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int arraySize = in.nextInt();
		int[] array = new int[arraySize];
		int i = 0;
		
		while (in.hasNextInt())
		{
			array[i++] = in.nextInt();
		}
		
		// Convert integer array to List of Integer
		List<Integer> numbers = Arrays.stream(array)
									  .boxed()
									  .collect(Collectors.toList());
		
		System.out.println(solution(numbers));
		
		in.close();
	}
	
	/**
	 * Finds number of distinct elements.
	 * 
	 * @param numbers List of integers.
	 * @return number of distinct elements.
	 */
	private static int solution(List<Integer> numbers)
	{
		Set<Integer> storage = new HashSet<>();
		
		storage.addAll(numbers);
		
		return storage.size();
	}
}
