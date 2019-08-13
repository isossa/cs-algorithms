
package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a node element. It can be used to implement any possible abstract data types
 * that use node.
 * 
 * It provides mechanisms for running operations that could be expected for a node.
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
 * @param <E> The type of the information about the element of this node.
 */
public class Node <T, E extends Comparable<E>> implements Comparable<Node<T, E>>
{
	/**
	 * Parent node of this node.
	 */
    private Node<T, E> parent;
    
    /**
     * Children of this node. A node can have as many children as possible.
     */
    private LinkedList<Node<T, E>> children;
    
    /**
     * Data or information held by this node.
     */
    private E data;
    
    /**
     * Constructs a new node by supplying it with its data.
     * 
     * @param dataIn Data held by this node.
     */
    public Node(E dataIn)
    {
        parent = null;
        children = new LinkedList<>();
        setData(dataIn);
    }
    
    /**
     * Sets the data held by this node.
     * 
     * @param dataIn Data held by this node.
     */
    public void setData(E dataIn)
    {
        data = dataIn;
    }
    
    /**
     * Retrieves the data about this node.
     * 
     * @return Data held by this node.
     */
    public E getData()
    {
        return data;
    }
    
    /**
     * Retrieves the parent node of this node.
     * 
     * @return Parent node of this node.
     */
    public Node<T, E> getParent()
    {
        return parent;
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
     * Retrieves the list of children of this node.
     *  
     * @return Children of this node.
     */
    public List<Node<T, E>> getChildren()
    {
        return children;
    }
    
    /**
     * Retrieves the element at the specified position.
     * 
     * @param index Index of the element to be retrieved.
     * @return The child at the specified position.
     * @throws IndexOutOfBoundsException if index out of range (index < 0 || index >= getNumberOfChildren())
     */
    public Node<T, E> getChildAt(int index) throws IndexOutOfBoundsException
    {
        if (validIndex(index))
            return children.get(index);
        
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * Appends the specified element as a new child of this node.
     * 
     * @param node New child of this node.
     */
    public void add(Node<T, E> node)
    {
        node.parent = this;
        children.add(node);
    }
    
    /**
     * Removes the last child of this node.
     * 
     * @return The last child of this node.
     */
    public Node<T, E> remove()
    {
        return children.remove();
    }
    
    public Node<T, E> removeAt(int index)
    {
        if (validIndex(index))
            return children.remove(index);
        
        throw new IndexOutOfBoundsException("Cannot perform operation."
                + " Number of children: " + this.getNumberOfChildren());
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
     * Removes all the children but not the node itself.
     * 
     * @return The node whose children have been deleted.
     */
    public Node<T, E> delete()
    {
        children.clear();
        return this;
    }
    
    /**
     * Changes the data held by this node.
     * 
     * @param dataIn Data to be held by this node.
     * @return The modified node.
     */
    public Node<T, E> updateData(E dataIn)
    {
    	setData(dataIn);
    	return this;
    }

    /**
     * Compares this node against another for equality.
     * 
     * @return an integer representing the comparison 
     * of the data held by this node. The returned integer 
     * is determined per compareTo method defined by the data 
     * element held by this node.
     */
	@Override
	public int compareTo(Node<T, E> otherNode) 
	{
		return (this.getData()).compareTo(otherNode.getData());
		
	}
	
	/**
	 * Returns a string representation of the data held by 
	 * this node.
	 * 
	 * @return The string representation of the data held by
	 * this node.
	 */
	@Override
	public String toString()
	{
		return getData().toString();
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
