package algorithms.introductoryProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * PROBLEM STATEMENT
 * 
 * You are given all numbers between 1,2,…,n except one. 
 * Your task is to find the missing number.
 * 
 * Input: The first input line contains an integer n.
 * 		  The second line contains n−1 numbers. Each number is distinct and between 1 and n (inclusive).
 * Output: Print the missing number.
 * For example: 
 * 
 * Input:
 * 5
 * 2 3 1 5
 * Output:
 * 4
 * 
 * Source: https://cses.fi/problemset/task/1083 
 */
/**
 * A solution to the Missing Number problem.
 * 
 * @author Isidore Sossa
 */
public class MissingNumber 
{
	/**
	 * Main method.
	 * 
	 * @param args No parameter required.
	 */
	public static void main(String[] args)
	{
		solution();
	}
	
	/**
	 * Method solution.
	 */
	private static void solution()
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		long numberOfIntegers = in.nextLong();
		in.nextLine();
		
		long expectedSum = (numberOfIntegers * (numberOfIntegers + 1)) / 2;
		long sum = 0;
		
		while (in.hasNextLong())
		{
			sum += in.nextLong();
		}
		
		in.close();
		
		System.out.println(expectedSum - sum);
	}
}
