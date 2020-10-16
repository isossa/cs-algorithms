package fundamentals.math;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci
{
	public static void main(String[] args)
	{
		for (int n : new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
			System.out.println(fibonacci(n));
	}

	/*
	 * Return the nth Fibonacci number.
	 * fibonacci (0) = 0
	 * fibonacci (1) = 1
	 * fibonacci (n) = fibonacci (n - 1) + fibonacci (n - 2)
	 */
	private static long fibonacci(long n)
	{
		if (n == 0)
			return (0);
		else if (n == 1)
			return (1);
		
		long a = 0;
		long b = 1;
		
		for (int i = 0; i < n - 1; i++)
		{
			long temp = a;
			a = b;
			b = temp + a;
		}
		return b;
	}
}
