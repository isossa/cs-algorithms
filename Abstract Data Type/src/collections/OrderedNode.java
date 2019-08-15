package collections;

/**
 * Representation of a node element. It can be used to implement any possible abstract data types that 
 * assumes ordering relation between siblings elements.
 * 
 * It provides mechanisms for performing operations that could be expected for a node. It relies on the 
 * implementation of the doubly-linked list as provided by the Java programming language API.
 * <br>
 * <br>
 * <b>This implementation is not synchronized.</b>
 * 
 * @author Isidore Sossa
 * @version 0.1.1
 *
 * @param <T> The type of the elements held in this node.
 */
public class OrderedNode<T extends Comparable<T>> extends Node<T> 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new node by supplying it with its data.
	 * 
	 * @param dataIn Data held by this node.
	 */
	public OrderedNode(T dataIn) 
	{
		super(dataIn);
	}
	
	/**
	 * Appends the specified element as a new child of this node. 
	 * 
	 * The inserted element is logically compared with any previously inserted element 
	 * to determine where it should be inserted.
	 */
	@Override
	public void add(Node<T> node)
	{
		if (this.getNumberOfChildren() == 0)
		{
			super.add(node);
		}
		else
		{
			boolean hasBeenInserted = false;
			
			for (int i = 0; i < this.getNumberOfChildren(); i++)
			{	
				if (this.getChildAt(i).compareTo(node) > 0)
				{
					this.getChildren().add(i, node);
					hasBeenInserted = true;
					break;
				}
			}
			
			if (!hasBeenInserted)
			{
				super.add(node);
			}
		}
	}
}
