package algorithms.introductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * PROBLEM STATEMENT
 * 
 * You are given a DNA sequence: a string consisting of characters A, C, G, and T. 
 * Your task is to find the longest repetition in the sequence. This is a 
 * maximum-length substring containing only one type of character.
 * 
 * Input: The only input line contains a string of n characters.
 * Output: Print one integer: the length of the longest repetition.
 * Constraints: 1≤n≤10^6
 * 
 * Example
 * Input:
 * ATTCGGGA
 * Output:
 * 3
 * 
 * Source: https://cses.fi/problemset/task/1069
 */
/**
 * A solution to the Repetitions problem.
 * 
 * @author Isidore Sossa
 */
public class Repetitions 
{
	/**
	 * Main method.
	 * 
	 * @param args No parameter required.
	 * @throws IOException if exception occurs.
	 */
	public static void main(String[] args) throws IOException
	{
		InputStreamReader inStream = new InputStreamReader(System.in);
		
		Scanner in = new Scanner(new BufferedReader(inStream));
		
		// Cool solution
		System.out.println(solution_1(in.nextLine()));
		
		// Cooler solution
		System.out.println(solution_2(inStream));
		
		in.close();
	}
	
	/**
	 * Finds the longest repetition in the input sequence.
	 * 
	 * @param input Input string.
	 * @return Length of the longest substring with identical characters.
	 */
	private static int solution_1(String input)
	{
		int i = 0;
		int max_length = 1;
		int local_length = 1;
		
		for (int j = 1; j < input.length(); j++)
		{
			if (input.charAt(i) == input.charAt(j))
			{
				local_length++;
			}
			else
			{
				i = j;
				
				max_length = (local_length > max_length) ? local_length : max_length;
				
				local_length = 1;
			}
		}
		
		max_length = (local_length > max_length) ? local_length : max_length;
		
		return max_length;
	}
	
	/**
	 * Finds the longest repetition in the input sequence.
	 * 
	 * @param in Input string.
	 * @return Length of the longest substring with identical characters.
	 * @throws IOException if exception occurs.
	 */
	private static int solution_2(InputStreamReader in) throws IOException
	{
		int max_length = 1;
		int local_length = 1;
		
		int start_char = in.read();
		
		int current_char = in.read();
		
		// Look for end-of-line
		while (current_char != (int)('\r'))
		{			
			if (start_char == current_char)
			{
				local_length++;
			}
			else
			{
				start_char = current_char;
				
				max_length = (local_length > max_length) ? local_length : max_length;
				
				local_length = 1;
			}
			
			current_char = in.read();
		}
		
		max_length = (local_length > max_length) ? local_length : max_length;
		
		return max_length;
	}
}
