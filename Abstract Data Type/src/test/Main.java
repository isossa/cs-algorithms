package test;

import algorithms.BST;
import algorithms.BinaryTree;
import algorithms.CustomLinkedStack;
import algorithms.LinkedStack;
import algorithms.Stack;
import algorithms.TreeNode;

public class Main
{
	public static void main(String[] args)
	{
		/*
		System.out.println("BINARY SEARCH TREE");
		BST tree = new BST();
		int[] values = {4, 3, 1, 2, 5};
		
		for (int value : values)
		{
			tree.insert(value);
		}
		
		tree.printInOrder(tree.root);
		
		for (int value : values)
		{
			System.out.println(tree.contains(new TreeNode(value)));
		}
		
		tree.printPreOrderTraversal();
		
		// BinaryTree
		System.out.println("\nBINARY TREE");
		BinaryTree btree = new BinaryTree();
		
		for (int value : values)
		{
			btree.insert(value);
		}
		
		tree.printInOrder(btree.root);
		
		for (int value : values)
		{
			System.out.println(btree.contains(new TreeNode(value - 1)));
		}
		
		btree.printPreOrderTraversal(btree.root);
		*/
		
		/*
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		LinkedStack linkedStack = new LinkedStack();
		linkedStack.push(1);
		linkedStack.push(2);
		linkedStack.push(3);
		System.out.println(linkedStack.pop());
		System.out.println(linkedStack.pop());
		*/
		
		CustomLinkedStack<Integer> customLinkedStack = new CustomLinkedStack<Integer>();
		System.out.println(customLinkedStack);
		
		customLinkedStack.push(1);
		customLinkedStack.push(2);
		customLinkedStack.push(3);
		customLinkedStack.push(4);
		
		int n = Integer.valueOf(String.valueOf(customLinkedStack.pop()));
		System.out.println(n + 10);
		
		System.out.println(customLinkedStack.pop());
		System.out.println(customLinkedStack.pop());
		System.out.println(customLinkedStack.peek());
		
		System.out.println(customLinkedStack);
	}
}
