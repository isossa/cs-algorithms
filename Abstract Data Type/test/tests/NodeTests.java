package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import tree.Node;

/**
 *
 * @author Isidore Sossa
 */
public class NodeTests 
{
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void testGetData()
    {
        Node<Integer, Integer> node = new Node<>(1);
        assertEquals(1, node.getData().intValue());
    }
    
    @Test
    public void testParent()
    {
        Node<Integer, Integer> node = new Node<>(3);
        assertEquals(null, node.getParent());
    }
    
    @Test
    public void testGrandParent()
    {
        Node<Integer, Integer> node = new Node<>(9);
        node.add(new Node<Integer, Integer>(4));
        node.add(new Node<Integer, Integer>(0));
        node.getChildAt(0).add(new Node<Integer, Integer>(-4));
        assertEquals(4, node.getChildAt(0).getChildAt(0).getParent().getData().intValue());
    }
    
        @Test
    public void testGetSize()
    {
        Node<Integer, Integer> node = new Node<>(4);
        node.add(new Node<Integer, Integer>(2));
        assertEquals(2, node.size());
    }
    
    @Test
    public void testGetChildAtOnValidIndex()
    {
        Node<Integer, Integer> node = new Node<>(90);
        node.add(new Node<Integer, Integer>(7));
        assertEquals(7, node.getChildAt(0).getData().intValue());
    }
    
    @Test
    public void testGetChildAtOnInvalidIndex()
    {
    	Node<Integer, Integer> node = new Node<>(90);
        node.add(new Node<Integer, Integer>(7));
        expectedException.expect(IndexOutOfBoundsException.class);
        node.getChildAt(1);
    }
    
    
    @Test
    public void testParentAfterAddingChildren()
    {
        Node<Integer, Integer> node = new Node<>(5);
        node.add(new Node<Integer, Integer>(7));
        node.add(new Node<Integer, Integer>(4));
        node.add(new Node<Integer, Integer>(0));
        assertEquals(5, node.getChildAt(0).getParent().getData().intValue());
    }
    
    @Test
    public void testGetNumberOfChildrenWhenNoChild()
    {
        Node<Integer, Integer> node = new Node<>(5);
        assertEquals(0, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetNumberOfChildrenWhenChild()
    {
        Node<Integer, Integer> node = new Node<>(-1);
        node.add(new Node<Integer, Integer>(9));
        node.add(new Node<Integer, Integer>(3));
        node.add(new Node<Integer, Integer>(4));
        assertEquals(3, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetNumberOfChildrenAfterRemoving()
    {
        Node<Integer, Integer> node = new Node<>(5);
        node.add(new Node<Integer, Integer>(11));
        node.remove();
        assertEquals(0, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetNumberOfChildrenWhenRemovingAtValidIndex()
    {
        Node<Integer, Integer> node = new Node<>(19);
        node.add(new Node<Integer, Integer>(7));
        node.add(new Node<Integer, Integer>(4));
        node.add(new Node<Integer, Integer>(0));
        node.removeAt(1);
        assertEquals(2, node.getNumberOfChildren());
    }
    
    @Test
    public void testRemoveWhenOneChild()
    {
        Node<Integer, Integer> node = new Node<>(10);
        node.add(new Node<Integer, Integer>(-2));
        Node<Integer, Integer> temp = node.remove();
        assertEquals(-2, temp.getData().intValue());
    }
    
    
    @Test
    public void testRemoveAtIndexGreaterThanSize()
    {
        Node<Integer, Integer> node = new Node<>(9);
        node.add(new Node<Integer, Integer>(3));
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Cannot perform operation."
                + " Number of children: 1");
        node.removeAt(1);
    }
    
    @Test
    public void testRemoveAtIndexLessThanZero()
    {
        Node<Integer, Integer> node = new Node<>(9);
        node.add(new Node<Integer, Integer>(3));
        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Cannot perform operation."
                + " Number of children: 1");
        node.removeAt(-1);
    }
    
    @Test
    public void testGetSizeAfterRemoving()
    {
        Node<Integer, Integer> node = new Node<>(10);
        node.add(new Node<Integer, Integer>(5));
        node.remove();
        assertEquals(0, node.getNumberOfChildren());
    }
    
    @Test
    public void testGetChildrenReturnCorrectNumberOfChildren()
    {
    	Node<Integer, Integer> node = new Node<>(4);
    	node.add(new Node<Integer, Integer>(0));
    	
    	List<Node<Integer, Integer>> expected = new LinkedList<Node<Integer, Integer>>();
    	expected.add(new Node<Integer, Integer>(0));
    	assertEquals(expected.size(), node.getChildren().size());
    }
    
    @Test
    public void testGetChildrenReturnCorrectChildren()
    {
    	Node<Integer, Integer> node = new Node<>(4);
    	node.add(new Node<Integer, Integer>(0));
    	
    	List<Node<Integer, Integer>> expected = new LinkedList<Node<Integer, Integer>>();
    	expected.add(new Node<Integer, Integer>(0));
    	assertEquals(expected.get(0).getData(), node.getChildren().get(0).getData());
    }
    
    @Test
    public void testDelete()
    {
    	Node<Integer, Integer> node = new Node<>(3);
    	assertEquals(3, node.delete().getData().intValue());
    }
    
    @Test
    public void testUpdateData()
    {
    	Node<Integer, Integer> node = new Node<>(90);
    	node.updateData(2);
    	assertEquals(2, node.getData().intValue());
    }
 
    @Test
    public void testToString()
    {
    	Node<Integer, Integer> node = new Node<>(4);
    	assertEquals("4", node.toString());
    }
    
    @Test
    public void testCompareToWhenSameData()
    {
    	Node<Integer, Integer> node1 = new Node<>(3);
    	Node<Integer, Integer> node2 = new Node<>(3);
    	assertEquals(0, node1.compareTo(node2));
    }
    
    @Test
    public void testCompareToWhenDifferentData()
    {
    	Node<Integer, Integer> node1 = new Node<>(2);
    	Node<Integer, Integer> node2 = new Node<>(3);
    	assertEquals("2".compareTo("3"), node1.compareTo(node2));
    }
}
