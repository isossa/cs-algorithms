package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tree.Node;
import tree.OrderedNode;

public class OrderedNodeTests 
{
	@Test
	public void testAddWhenOneElementToAdd()
	{
		Node<Integer, Integer> node = new OrderedNode<Integer, Integer>(9);
		node.add(new Node<Integer, Integer>(4));
		
		assertEquals(4, node.getChildAt(0).getData().intValue());
	}

	@Test
	public void testAddWhenAddingSmallestElement()
	{
		OrderedNode<Integer, Integer> node = new OrderedNode<Integer, Integer>(9);
		
		int[] array = {-1, -2, -3};
		
		for (Integer i : array)
		{
			node.add(new OrderedNode<Integer, Integer>(i));
		}
		
		assertEquals(-3, node.getChildAt(0).getData().intValue());
	}
	
	@Test
	public void testAddWhenAddingLargestElement()
	{
		OrderedNode<Integer, Integer> node = new OrderedNode<Integer, Integer>(9);
		
		int[] array = {4, 7, 9};
		
		for (Integer i : array)
		{
			node.add(new OrderedNode<Integer, Integer>(i));
		}
		
		assertEquals(9, node.getChildAt(2).getData().intValue());
	}
	
	@Test
	public void testAddWhenAddingNewElement()
	{
		OrderedNode<Integer, Integer> node = new OrderedNode<Integer, Integer>(9);
		node.add(new OrderedNode<Integer, Integer>(-5));
		node.add(new OrderedNode<Integer, Integer>(2));
		
		node.add(new OrderedNode<Integer, Integer>(0));
		
		assertEquals(0, node.getChildAt(1).getData().intValue());
	}
}
