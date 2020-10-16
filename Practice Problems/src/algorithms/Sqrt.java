package algorithms;

public class Sqrt
{
	public static void main(String[] args)
	{
		System.out.println(solution(30));
	}
	
	public static int solution(int n)
	{
		if (n < 0)
			return -1;
		
		if (n == 1)
			return 1;
		
		int base = 2;
		double low = 0;
		double high = n;
		final double ERROR = 0.00001;
		double mid = low + (high - low) / 2;
		
		while (high - low > ERROR)
		{			
			if (Math.pow(mid, base) == n)
				return (int) mid;
			else if (Math.pow(mid, base) > n)
				high = mid;
			else
				low = mid;
			
			System.out.println("low = " + low + " high = " + high);
			
			mid = low + (high - low) / 2;
		}
		return (int) high;
	}

}
