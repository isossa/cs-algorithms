package tree;

/**
 * 
 * @author Isidore Sossa
 *
 * @param <T>
 */
public class OrderedNode<T, E extends Comparable<E>> extends Node<T, E> 
{
	public OrderedNode(E dataIn) 
	{
		super(dataIn);
	}
	
	@Override
	public void add(Node<T, E> node)
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
