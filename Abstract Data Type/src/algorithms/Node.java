
package algorithms;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a node element. It can be used to implement any possible abstract data types
 * that use node. No assumption is made about the ordering of the node and its relation with its 
 * elements.
 * 
 * It provides mechanisms for performing operations that could be expected for a node.
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
public class Node <T extends Comparable<T>> implements Comparable<Node<T>>, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Children of this node. A node can have as many children as possible.
     */
    private LinkedList<Node<T>> children;
    
    private int currentIndex;
    
    /**
	 * Parent node of this node.
	 */
    private Node<T> parent;
    
    /**
     * Data or information held by this node.
     */
    private T root;
    
    /**
     * Constructs a new node by supplying it with its root.
     * 
     * @param dataIn Data held by this node.
     */
    public Node(T dataIn)
    {
        parent = null;
        children = new LinkedList<>();
        currentIndex = -1;
        setRoot(dataIn);
    }
    
    /**
     * Appends the specified element as a new child of this node.
     * 
     * @param node New child of this node.
     */
    public void add(Node<T> node)
    {
    	if (node != null)
    	{
    		node.parent = this;
    		children.add(node);
    	}
    }
    
    /**
     * Removes all the children but not the node itself.
     * 
     * @return The node whose children have been deleted.
     */
    public Node<T> clear()
    {
        children.clear();
        return this;
    }
    
    /**
     * Compares this node against another for equality.
     * 
     * @return an integer representing the comparison 
     * of the root held by this node. The returned integer 
     * is determined per compareTo method defined by the root 
     * element held by this node.
     */
	@Override
	public int compareTo(Node<T> otherNode) 
	{
		return (this.toString()).compareTo(otherNode.toString());
		
	}
    
	/**
	 * Indicates whether this node is "equal to" another node. Two nodes are equals
	 * when they have the same data.
	 * 
	 * @param otherNode Node to be compared against.
	 * @return true if this object is the same as the otherNode argument; false
	 *         otherwise.
	 */
	public boolean equals(Node<T> otherNode)
    {
		return this.compareTo(otherNode) == 0 ? true : false;
    }
    
    /**
     * Retrieves the element at the specified position.
     * 
     * @param index Index of the element to be retrieved.
     * @return The child at the specified position.
     * @throws IndexOutOfBoundsException if index out of range {@code (index < 0 || index >= getNumberOfChildren())}
     */
    public Node<T> getChildAt(int index) throws IndexOutOfBoundsException
    {
        if (validIndex(index))
        {
        	currentIndex = index;
        	return children.get(index);
        }
        
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Retrieves the list of children of this node.
     *  
     * @return Children of this node.
     */
    public List<Node<T>> getChildren()
    {
        return children;
    }
    
    /**
     * Retrieves the root about this node.
     * 
     * @return Data held by this node.
     */
    public T getData()
    {
        return root;
    }
    
    /**
     * Retrieves the next element of this node.
     * 
     * @return Returns the next element of this node.
     */
    public Node<T> getNext()
    {
    	if (!children.isEmpty() && currentIndex < children.size() - 1)
    	{
    		currentIndex++;
    		return children.get(currentIndex);
    	}
    	
    	return null;
    }
    
    /**
     * Retrieves the number of children of this node.
     * 
     * @return Number of children of this node.
     */
    public int getNumberOfChildren()
    {
        return children.size();
    }
    
    /**
     * Retrieves the parent node of this node.
     * 
     * @return Parent node of this node.
     */
    public Node<T> getParent()
    {
        return parent;
    }
    
    /**
     * Retrieves the previous element of this node.
     * 
     * @return Returns the previous element of this node.
     */
    public Node<T> getPrevious()
    {
    	if (currentIndex > 0)
    	{
    		currentIndex--;
    		return children.get(currentIndex);
    	}
    	
    	return null;
    }
    
    /**
	 * Implements the pre-ordering traversal.
	 * 
	 * @param rootIn Node to start printing.
	 * @return The pre-order traversal of this node; otherwise null if the argument
	 *         is null.
	 */
    public String printTreePreOrder(Node<T> rootIn)
    {
    	if (rootIn != null)
    	{
    		StringBuilder output = new StringBuilder(); 
    		
    		if (rootIn.getNumberOfChildren() != 0)
    		{
    			output.append(rootIn + "*");
    		}
    		else
    		{
    			output.append(" " + rootIn);
    		}
    		
    		int tempSize = rootIn.getNumberOfChildren();
    		
    		for (int index = 0; index < tempSize; index++)
    		{
    			output.append(printTreePreOrder(rootIn.getChildAt(index)));
    		}
    		
    		return output.toString();
    	}
    	return null;
    }
    
    /**
     * Removes the last child of this node.
     * 
     * @return The last child of this node.
     */
    public Node<T> remove()
    {
        return children.remove();
    }
    
    public Node<T> removeAt(int index)
    {
        if (validIndex(index))
            return children.remove(index);
        
        throw new IndexOutOfBoundsException("Cannot perform operation."
                + " Number of children: " + this.getNumberOfChildren());
    }
    
    /**
     * Sets the root held by this node.
     * 
     * @param dataIn Data held by this node.
     */
    public void setRoot(T dataIn)
    {
        root = dataIn;
        clear();
    }
    
    /**
     * Retrieve the size of this node.
     * 
     * The size is defined as the number of children plus one.
     * 
     * @return The size of this node.
     */
    public int size()
    {
        return children.size() + 1;
    }

    /**
	 * Returns a string representation of the root held by 
	 * this node.
	 * 
	 * @return The string representation of the root held by
	 * this node.
	 */
	@Override
	public String toString()
	{
		return getData().toString();
	}
	
	/**
     * Changes the root held by this node.
     * 
     * @param dataIn Data to be held by this node.
     * @return The modified node.
     */
    public Node<T> updateRoot(T dataIn)
    {
    	setRoot(dataIn);
    	return this;
    }
	
	/**
	 * Checks for validity of an index within the range of the 
	 * number of children of this node.
	 * 
	 * @param index Index to validate.
	 * @return true if the index is valid; otherwise false.
	 */
	private boolean validIndex(int index)
    {
        return (index >= 0 && index < children.size());
    }
}
