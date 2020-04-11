package algorithms.introductoryProblems;

/*
 * PROBLEM STATEMENT
 * 
 * Consider an algorithm that takes as input a positive integer n. 
 * If n is even, the algorithm divides it by two, and if n is odd, 
 * the algorithm multiplies it by three and adds one. The algorithm 
 * repeats this, until n is one. 
 * 
 * For example, the sequence for n=3 is as follows:
 * 3→10→5→16→8→4→2→1
 * 
 * Your task is to simulate the execution of the algorithm for a given value of n.
 * 
 * Source: https://cses.fi/problemset/task/1068
 */

/**
 * 
 * @author Isidore Sossa
 */
public class WeirdAlgorithm 
{
	/**
	 * Main method.
	 * 
	 * @param args No parameter required.
	 */
	public static void main(String [] args)
	{
		solution(3);
	}
	
	/**
	 * Method solution to the given problem.
	 * 
	 * Problem solved using recursion.
	 * 
	 * @param n positive integer.
	 */
	private static void solution(int n)
	{
		System.out.println(helper(n, ""));
	}
	
	/**
	 * Helper method.
	 * 
	 * @param n      positive integer
	 * @param output output string
	 * @return output string representing sequence of integers.
	 */
	private static String helper(int n, String output)
	{
		if (n <= 1)
		{
			return output + 1;
		}
		
		output += n + " -> ";
		
		if (n % 2 == 0)
		{
			return helper(n / 2, output);
		}
		else
		{
			return helper((n * 3) + 1, output);
		}
	}
}
