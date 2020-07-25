package algorithms.sortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * PROBLEM STATEMENT
 * 
 * There are n applicants and m free apartments. Your task is to distribute the 
 * apartments so that as many applicants as possible will get an apartment. 
 * Each applicant has a desired apartment size, and they will accept any apartment 
 * whose size is close enough to the desired size.
 * 
 * Input: The first input line has three integers n, m, and k: the number of applicants, 
 * 		  the number of apartments, and the maximum allowed difference.
 * 		  The next line contains n integers a1,a2,…,an: the desired apartment size of 
 * 		  each applicant. If the desired size of an applicant is x, he or she will 
 * 		  accept any apartment whose size is between x−k and x+k.
 * 		  The last line contains m integers b1,b2,…,bm: the size of each apartment.
 * 
 * Output: Print one integer: the number of applicants who will get an apartment.
 * 
 * Constraints: 1≤n,m≤2*10^5
 * 				0≤k≤10^9
 * 				1≤a_i,b_i≤10^9
 * 
 * Example
 * Input:
 * 4 3 5
 * 60 45 80 60
 * 30 60 75
 * 
 * Output:
 * 2
 * 
 * Source: https://cses.fi/problemset/task/1084
 */

/**
 * A solution to the Apartment problem.
 * 
 * @author Isidore Sossa
 *
 */
public class Apartments 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int numberOfApplicants = in.nextInt();
		int numberOfApartments = in.nextInt();
		int allowedDifference = in.nextInt();
		
		ArrayList<Long> desiredApartmentSize = new ArrayList<Long>(numberOfApplicants);
		
		for (int i = 0; i < numberOfApplicants; i++)
		{
			desiredApartmentSize.add((long) in.nextInt());
		}
		
		ArrayList<Long> allocatedApartments = new ArrayList<Long>(numberOfApplicants);
		
		for (long i = 0; i < numberOfApartments; i++)
		{
			long apartmentSize = in.nextInt();
			
			for (int j = 0; j < numberOfApplicants; j++)
			{
				if (allowedDifference >=
						Math.abs(apartmentSize - desiredApartmentSize.get(j)))
				{
					allocatedApartments.add(apartmentSize);
					break;
				}
			}
		}
		
		System.out.println(allocatedApartments.size());
		in.close();
	}
}
