package algorithms;

/**
 * Representation of a binary node element. It can be used to implement any possible abstract data types
 * that use binary binary node. No assumption is made about the ordering of the node and its relation with its 
 * elements.
 * 
 * Children node are added from left to write in such a way that the resulting tree is guaranteed to be complete.
 * 
 * It provides mechanisms for performing operations that could be expected for a binary node.
 * It relies on the implementation of the doubly-linked list as provided by the Java programming 
 * language API.
 * <br>
 * <br>
 * <b>This implementation is not synchronized.</b>
 * 
 * @author Isidore Sossa
 * @version 0.1.1
 * 
 * @param <T> The type of the elements held in this node.
 */
public class BinaryNode<T extends Comparable<T>> extends Node<T> implements Comparable<Node<T>>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int MAX_CHILDREN = 2;
	
	public BinaryNode(T dataIn) 
	{
		super(dataIn);
	}

	public void add(Node<T> node)
	{
		if (this.getNumberOfChildren() < MAX_CHILDREN)
		{
			super.add(node);
		}
	}
	
	public Node<T> getRightChild()
	{
		return this.getNumberOfChildren() == 0 ? null : this.getChildAt(0);
	}
	
	/**
	 * Retrieves the left child of this node.
	 * 
	 * @return The left child of this node. If none, returns null
	 */
	public Node<T> getLeftChild()
	{
		return this.getNumberOfChildren() < 2 ? null : this.getChildAt(1);
	}
	
	/**
	 * Checks if this is a full node.
	 * 
	 * @return Returns true if this node is a full node; otherwise false.
	 */
	public boolean isFull()
	{
		return this.getNumberOfChildren() == 2;
	}
}
