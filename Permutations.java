
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * A solution to the Permutations problem.
 * 
 * @author Isidore Sossa
 */
public class Permutations 
{
	/**
	 * Main method.
	 * 
	 * @param args No parameter required.
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		solution(in.nextLong());
		
		in.close();
	}
	
	/**
	 * Print a beautiful permutation of integers 1,2,…,n. If there are several 
	 * solutions, you may print any of them. If there are no solutions, 
	 * print "NO SOLUTION".
	 * 
	 * @param n Length of permutation.
	 */
	private static void solution(long n)
	{
		if (n >= 5)
		{
			long nextNumber = n;
			
			for (long i = 0; i < n; i++)
			{			
				System.out.printf("%d%s", nextNumber, (i == n - 1) ? "" : " ");
				
				nextNumber -= 2;
				
				if (nextNumber < 0)
				{
					nextNumber += n;
				}
				else if (nextNumber == 0)
				{
					nextNumber += (n - 1);
				}
			}
		}
		else
		{
			System.out.println("NO SOLUTION");
		}
	}
}
