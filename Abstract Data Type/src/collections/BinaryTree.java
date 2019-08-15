
package collections;

/**
 * Implementation of a binary tree.
 * 
 * @author Isidore Sossa
 *
 * @param <T> The type of the elements held in this node.
 */
public class BinaryTree<T extends Comparable<T>>
{
    private Node<T> root;
    
    public BinaryTree(Node<T> rootIn)
    {
        setRoot(rootIn);
    }
    
    /**
     * Adds a new node to the tree. If the tree was previously empty, the added node 
     * is set to be the root of the tree.
     * 
     * @param node
     */
    public void add(Node<T> node)
    {
    	if (isEmpty())
    	{
    		setRoot(node);
    	}
    	else
    	{
    		root.add(node);
    	}
    }
    
    public void replace(int index, Node<T> oldNode, Node<T> newNode)
    {
    	oldNode = newNode;
        if (index > 0 && index < oldNode.getNumberOfChildren())
        {
            oldNode.getChildren().set(index, newNode);
        }
    }
    
    /**
     * Retrieves the size of this tree.
     * 
     * @return The size of this tree.
     */
    public int size()
    {
    	return 0;
    }
    
    /**
     * Replaces the first occurrence of old node with the previous node. 
     * Replacement is equivalent to substitution. Any data about the old 
     * node is lost. 
     * 
     * @param parent
     * @param oldNode
     * @param newNode
     * @return
     */
    public Node<T> replace(Node<T> parent, Node<T> oldNode, Node<T> newNode)
    {
    	return null;
    }
    
    // compare
	public int compareTo(Node<T> node1, Node<T> node2) 
	{
		if (!(node1.getData().equals(node2.getData())))
		{
			System.out.println(" Comparing " 
					+ toString() + " with " + node1.toString() 
					+ " Result = " + toString().compareTo(node1.toString()));
			return toString().compareTo(node1.toString());
		}
		
		if (node1.getNumberOfChildren() != node2.getNumberOfChildren())
		{
			System.out.println(" Comparing " 
					+ toString() + " with " + node1.toString() 
					+ " Result = " + toString().compareTo(node1.toString()));
			return node1.getNumberOfChildren() - node2.getNumberOfChildren();
		}
		
		for(int i = 0; i < node1.getNumberOfChildren(); i++)
		{
			compareTo(node1.getChildAt(i), node2.getChildAt(i));
		}
		return 0;
	}
    
    // search
    public Node<T> contains(Node<T> node)
    {
    	return null;
    }
    
    public long getNumberOfNode(Node<T> root)
    {
        long count = 1;
        
        if (root.getNumberOfChildren() != 0)
        {
            for (Node<T> node : root.getChildren())
                count += node.getNumberOfChildren() 
                        + getNumberOfNode(node);
        }
        
        return count;
    }
    
    public long getNumberOfNodeInTree()
    {
        return getNumberOfNode(root);
    }
    
    public Node<T> getRoot()
    {
        return root;
    }
    
    // delete
    
    // update
    
    /**
     * Check if two node has the exact same children regardless of they
	 * having the same data.
	 * 
     * @param node1
     * @param node2
     * @return
     */
	public boolean hasSameChildren(Node<T> node1, Node<T> node2)
	{
		if (node1.getNumberOfChildren() == node2.getNumberOfChildren())
		{
			for(int i = 0; i < node1.getNumberOfChildren(); i++)
			{
				if (node1.getChildAt(i).getData().equals(node2.getChildAt(i).getData()))
				{
					hasSameChildren(node1.getChildAt(i), node2.getChildAt(i));
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
    public boolean isEmpty()
    {
    	return root == null;
    }
	
    
    private void setRoot(Node<T> rootIn)
    {
        root = rootIn;
    }
}
