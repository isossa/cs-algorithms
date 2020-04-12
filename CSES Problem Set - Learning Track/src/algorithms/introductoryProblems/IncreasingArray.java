package algorithms.introductoryProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// INCOMPLETE
/*
 * PROBLEM STATEMENT
 * 
 * You are given an array of n integers. You want to modify the array so that it is 
 * increasing, i.e., every element is at least as large as the previous element.
 * On each turn, you may increase the value of any element by one. What is the 
 * minimum number of turns required?
 * 
 * Input: The first input line contains an integer n: the size of the array. Then, 
 * the second line contains n integers x1,x2,…,xn: the contents of the array.
 * Output: Print the minimum number of turns.
 * Constraints: 1≤n≤2*10^5
 * 				1≤xi≤10^9
 * Example
 * Input:
 * 5
 * 3 2 5 1 7
 * Output:
 * 5
 * 
 * Source: https://cses.fi/problemset/task/1094
 * 
 * Extension to try: Return an array with increasing elements as per described above. 	
 */

/**
 * A solution to the Increasing Array problem.
 * 
 * @author Isidore Sossa
 */
public class IncreasingArray 
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
		int i = 0;
		
		int[] array = new int[arraySize];
		
		in.nextLine();
		
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
		
		//increament(numbers, solution(numbers));
	}
	
	public static void increament(List<Integer> numbers, int n)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < numbers.size(); j++)
			{
				numbers.set(j, numbers.get(j) + 1);
				System.out.println(numbers);
			}
		}
	}
	
	/**
	 * Finds the minimum number of turns such that every element is at 
	 * least as large as the previous element
	 * 
	 * @param numbers
	 * @return
	 */
	private static int solution(List<Integer> numbers)
	{
		List<Integer> difference = new ArrayList<Integer>();
		
		int minimumTurn = 0;
		
		for (int i = 0; i < numbers.size(); i++)
		{
			if (i == 0)
			{
				difference.add(0);
			}
			else
			{
				difference.add(numbers.get(i) - numbers.get(i - 1));
			}
		}
		
		int localMinimum = -1;
		
		for (int i = 0; i < difference.size(); i++)
		{
			minimumTurn += (difference.get(i) <= localMinimum) 
					? Math.abs(difference.get(i)) : 0;
		}
		
		System.out.println(difference);
		
		return minimumTurn;
	}
}
