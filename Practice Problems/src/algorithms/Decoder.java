/**
 * A solution to a decoder problem.
 * a -> a
 * 1(a) -> a
 * 2(a(ab)) -> aabaab
 * 2(3(aba)2(bab)) -> abaabaababababaabaababab
 * 2(a(ab))2(3(aba)2(bab)) -> aabaababaabaababababaabaababab
 */
package algorithms;

import java.util.Stack;

/**
 * @author <a href = "mailto: connect.with.isidore@gmail.com">Isidore Sossa</a>
 */
public class Decoder 
{
	/**
	 * Takes no arguments.
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(getDecodedString("2(a(ab))2(3(aba)2(bab))"));
	}
	
	public static String getDecodedString(String encoded)
	{
	    if (encoded == null)
	        return null;

	    if (encoded.length() == 1)
	        return encoded;

	    StringBuilder decoded = new StringBuilder("");

	    Stack<Character> charStack = new Stack<>();

	    for (int index = 0; index < encoded.length(); index++)
	    {
	        char currentChar = encoded.charAt(index);
	        if (currentChar != ')')
	        {
	            charStack.push(currentChar);
	        }
	        else
	        {
	            StringBuilder subString = new StringBuilder("");
	            char topChar = charStack.pop();

	            while (topChar != '(')
	            {
	                subString.append(topChar);
	                topChar = charStack.pop();
	            }

	            int unfold = 1;
	            
	            if (!charStack.isEmpty() && Character.isDigit(charStack.peek()))
	            {
	            	unfold = Integer.parseInt(charStack.pop().toString());
	            }
	            
	            for (int i = 0; i < unfold; i++)
	            {
	                for (int j = subString.length() - 1; j >= 0 ; j--)
	                {
	                    charStack.push(subString.charAt(j));
	                }
	            }
	        }
	    }
	    while (!charStack.isEmpty())
	    {
	        decoded.append(charStack.pop());
	    }
	    return decoded.reverse().toString();
	}

}
