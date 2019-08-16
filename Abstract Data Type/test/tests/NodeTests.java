package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import collections.Node;

/**
 *
 * @author Isidore Sossa
 */
public class NodeTests 
{
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testCompareToWhenDifferentData()
    {
    	Node<Integer> node1 = new Node<>(2);
    	Node<Integer> node2 = new Node<>(3);
    	assertEquals("2".compareTo("3"), node1.compareTo(node2));
    }
    
    @Test
    public void testCompareToWhenSameData()
    {
    	Node<Integer> node1 = new Node<>(3);
    	Node<Integer> node2 = new Node<>(3);
    	assertEquals(0, node1.compareTo(node2));
    }
    
    @Test
    public void testDelete()
    {
    	Node<Integer> node = new Node<>(3);
    	assertEquals(3, node.clear().getData().intValue());
    }
    
    @Test
    public void testEqualsWhenSame()
    {
    	Node<Integer> node1 = new Node<>(5);
    	Node<Integer> node2 = new Node<>(5);
    	
    	assertTrue(node1.equals(node2));
    }
    
    @Test
    public void testEqualsWhenDifferent()
    {
    	Node<Integer> node1 = new Node<>(5);
    	Node<Integer> node2 = new Node<>(8);
    	
    	assertFalse(node1.equals(node2));
    }
    
    @Test
	public void testGetChildAtAfterCallingGetNext()
	{
		Node<Integer> node = new Node<>(5);
	    node.add(new Node<Integer>(3));
	    node.add(new Node<Integer>(2));
	    node.add(new Node<Integer>(4));
	    
	    assertEquals(3, node.getNext().getData().intValue());
	    assertEquals(2, node.getChildAt(1).getData().intValue());
	    assertEquals(4, node.getNext().getData().intValue());
	}
    
    @Test
	public void testGetChildAtOnInvalidIndex()
	{
		Node<Integer> node = new Node<>(90);
	    node.add(new Node<Integer>(7));
	    exception.expect(IndexOutOfBoundsException.class);
	    node.getChildAt(1);
	}
    
    @Test
    public void testGetChildAtOnValidIndex()
    {
        Node<Integer> node = new Node<>(90);
        node.add(new Node<Integer>(7));
        assertEquals(7, node.getChildAt(0).getData().intValue());
    }
    
    @Test
    public void testGetChildrenReturnCorrectChildren()
    {
    	Node<Integer> node = new Node<>(4);
    	node.add(new Node<Integer>(0));
    	
    	List<Node<Integer>> expected = new LinkedList<Node<Integer>>();
    	expected.add(new Node<Integer>(0));
    	assertEquals(expected.get(0).getData(), node.getChildren().get(0).getData());
    }
    
    @Test
    public void testGetChildrenReturnCorrectNumberOfChildren()
    {
    	Node<Integer> node = new Node<>(4);
    	node.add(new Node<Integer>(0));
    	
    	List<Node<Integer>> expected = new LinkedList<Node<Integer>>();
    	expected.add(new Node<Integer>(0));
    	assertEquals(expected.size(), node.getChildren().size());
    }
    
    @Test
    public void testGetData()
    {
        Node<Integer> node = new Node<>(1);
        assertEquals(1, node.getData().intValue());
    }
    
    @Test
    public void testGetDataWhenAddingNull()
    {
        Node<Integer> node = new Node<>(1);
	    node.add(null);
	    assertEquals(null, node.getNext());
    }
    
    @Test
    public void testGetNextAfterCallingGetChildAt()
    {
    	Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        node.add(new Node<Integer>(4));
        
        assertEquals(3, node.getChildAt(0).getData().intValue());
        assertEquals(2, node.getNext().getData().intValue());
    }
    
    @Test
    public void testGetNextWhenManyChildren()
    {
    	Node<Integer> node = new Node<>(90);
        node.add(new Node<>(4));
        node.add(new Node<>(5));
        node.add(new Node<>(8));
        node.getNext();
        node.getNext();
        assertEquals(8, node.getNext().getData().intValue());
    }
    
    @Test
    public void testGetNextWhenNoChild()
    {
    	Node<Integer> node = new Node<>(90);
    	assertEquals(null, node.getNext());
    }
    
    @Test
    public void testGetNextWhenOneChild()
    {
    	Node<Integer> node = new Node<>(90);
        node.add(new Node<>(4));
        assertEquals(4, node.getNext().getData().intValue());
    }
    
    @Test
    public void testGetNumberOfChildrenAfterRemoving()
    {
        Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(11));
        node.remove();
        assertEquals(0, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetNumberOfChildrenWhenChild()
    {
        Node<Integer> node = new Node<>(-1);
        node.add(new Node<Integer>(9));
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(4));
        assertEquals(3, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetNumberOfChildrenWhenNoChild()
    {
        Node<Integer> node = new Node<>(5);
        assertEquals(0, node.getNumberOfChildren());
    }
    
    
    @Test
    public void testGetNumberOfChildrenWhenRemovingAtValidIndex()
    {
        Node<Integer> node = new Node<>(19);
        node.add(new Node<Integer>(7));
        node.add(new Node<Integer>(4));
        node.add(new Node<Integer>(0));
        node.removeAt(1);
        assertEquals(2, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetPreviousAfterCallingGetChildAt()
    {
    	Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        node.add(new Node<Integer>(4));
        
        assertEquals(2, node.getChildAt(1).getData().intValue());
        assertEquals(3, node.getPrevious().getData().intValue());
    }
    
    @Test
    public void testGetPreviousAfterCallingGetChildAtZero()
    {
    	Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        node.add(new Node<Integer>(4));
        
        assertEquals(3, node.getChildAt(0).getData().intValue());
        assertEquals(null, node.getPrevious());
    }
    
    @Test
    public void testGetPreviousAfterCallingGetNext()
    {
    	Node<Integer> node = new Node<>(90);
        node.add(new Node<>(4));
        node.add(new Node<>(5));
        node.add(new Node<>(8));
        node.getNext();
        node.getNext();
        assertEquals(4, node.getPrevious().getData().intValue());
    }
    
    @Test
    public void testGetPreviousOneChild()
    {
    	Node<Integer> node = new Node<>(90);
    	assertEquals(null, node.getPrevious());
    }
    
    @Test
    public void testGetPreviousWhenNoChild()
    {
    	Node<Integer> node = new Node<>(90);
        assertEquals(null, node.getPrevious());
    }
    
    
    @Test
   public void testGetSize()
   {
	Node<Integer> node = new Node<>(4);
	node.add(new Node<Integer>(2));
	assertEquals(2, node.size());
   }
    
    @Test
    public void testGetSizeAfterRemoving()
    {
        Node<Integer> node = new Node<>(10);
        node.add(new Node<Integer>(5));
        node.remove();
        assertEquals(0, node.getNumberOfChildren());
    }
    
    @Test
    public void testGrandParent()
    {
        Node<Integer> node = new Node<>(9);
        node.add(new Node<Integer>(4));
        node.add(new Node<Integer>(0));
        node.getChildAt(0).add(new Node<Integer>(-4));
        assertEquals(4, node.getChildAt(0).getChildAt(0).getParent().getData().intValue());
    }
    
    @Test
    public void testParent()
    {
        Node<Integer> node = new Node<>(3);
        assertEquals(null, node.getParent());
    }
    
    @Test
    public void testParentAfterAddingChildren()
    {
        Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(7));
        node.add(new Node<Integer>(4));
        node.add(new Node<Integer>(0));
        assertEquals(5, node.getChildAt(0).getParent().getData().intValue());
    }
    
    @Test
    public void testPrintTreePreOrderOnGrandChild()
    {
    	Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        node.add(new Node<Integer>(4));
        
        node.getChildAt(0).add(new Node<Integer>(90));
        node.getChildAt(0).add(new Node<Integer>(13));
        node.getChildAt(0).add(new Node<Integer>(32));
        node.getChildAt(0).add(new Node<Integer>(35));
        node.getChildAt(0).add(new Node<Integer>(23));
        node.getChildAt(0).add(new Node<Integer>(83));
        
        String expected = new String("3* 90 13 32 35 23 83");
        assertEquals(expected, node.printTreePreOrder(node.getChildAt(0)));
    }
    
    @Test
    public void testPrintTreePreOrderWhenNoGrandChildren()
    {
    	Node<Integer> node = new Node<>(5);
        node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        node.add(new Node<Integer>(4));
        node.add(new Node<Integer>(6));
        node.add(new Node<Integer>(8));
        node.add(new Node<Integer>(12));
        
        String expected = new String("5* 3 2 4 6 8 12");
        assertEquals(expected, node.printTreePreOrder(node));
    }
    
    @Test
    public void testPrintTreePreOrderWhenNull()
    {
    	Node<Integer> node = new Node<>(5);
    	node.add(new Node<Integer>(3));
        node.add(new Node<Integer>(2));
        
        assertEquals(null, node.printTreePreOrder(null));
    }
    
    @Test
    public void testRemoveAtIndexGreaterThanSize()
    {
        Node<Integer> node = new Node<>(9);
        node.add(new Node<Integer>(3));
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Cannot perform operation."
                + " Number of children: 1");
        node.removeAt(1);
    }
    
    @Test
    public void testRemoveAtIndexLessThanZero()
    {
        Node<Integer> node = new Node<>(9);
        node.add(new Node<Integer>(3));
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Cannot perform operation."
                + " Number of children: 1");
        node.removeAt(-1);
    }
 
    @Test
    public void testRemoveWhenOneChild()
    {
        Node<Integer> node = new Node<>(10);
        node.add(new Node<Integer>(-2));
        Node<Integer> temp = node.remove();
        assertEquals(-2, temp.getData().intValue());
    }
    
    @Test
    public void testToString()
    {
    	Node<Integer> node = new Node<>(4);
    	assertEquals("4", node.toString());
    }
    
    @Test
    public void testUpdateData()
    {
    	Node<Integer> node = new Node<>(90);
    	node.updateRoot(2);
    	assertEquals(2, node.getData().intValue());
    }
}
