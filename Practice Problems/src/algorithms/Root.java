package algorithms;

public class Root
{
	public static void main(String[] args)
	{
		System.out.println(root(7, 3));
		int[] array = new int[15];
		
		System.out.println(array.length);
	}
	
	static double root(double x, int n)
	{
	    if (x == 0)
	        return 0;

	    double lowerBound = 0;
	    double upperBound = Math.max(1, x);
	    double approxRoot = (upperBound + lowerBound) / 2;
	    final double ERROR = 0.001;

	    while (approxRoot - lowerBound >= ERROR)
	    {
	        if (Math.pow(approxRoot, n) > x)
	            upperBound = approxRoot;
	        else if (Math.pow(approxRoot, n) < x)
	            lowerBound = approxRoot;
	        else
	            break;

	        approxRoot = (upperBound + lowerBound) / 2;
	    }
	    return approxRoot;
	}

}
