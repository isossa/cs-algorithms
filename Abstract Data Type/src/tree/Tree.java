/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Isidore Sossa
 */
public class Tree<T, E extends Comparable<E>>
{
    private Node<T, E> root;
    
    public Tree(Node<T, E> rootIn)
    {
        setRoot(rootIn);
    }
    
    public Node<T, E> getRoot()
    {
        return root;
    }
    
    public long getNumberOfNode(Node<T, E> root)
    {
        long count = 1;
        
        if (root.getNumberOfChildren() != 0)
        {
            for (Node<T, E> node : root.getChildren())
                count += node.getNumberOfChildren() 
                        + getNumberOfNode(node);
        }
        
        return count;
    }
    
    public long getNumberOfNodeInTree()
    {
        return getNumberOfNode(root);
    }
    
    public void changeNode(Node<T, E> oldNode, Node<T, E> newNode, int index)
    {
        if (index > 0 && index < oldNode.getNumberOfChildren())
        {
            oldNode.getChildren().set(index, newNode);
        }
    }
    
    // insert
    public void add(Node<T, E> node)
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
    
    public boolean isEmpty()
    {
    	return root == null;
    }
    
    // search
    public Node<T, E> contains(Node<T, E> node)
    {
    	return null;
    }
    
    // delete
    
    // update
    
    // compare
	public int compareTo(Node<T, E> node1, Node<T, E> node2) 
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
	
    /**
     * Check if two node has the exact same children regardless of they
	 * having the same data.
	 * 
     * @param node1
     * @param node2
     * @return
     */
	public boolean hasSameChildren(Node<T, E> node1, Node<T, E> node2)
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
	
    
    private void setRoot(Node<T, E> rootIn)
    {
        root = rootIn;
    }
}
