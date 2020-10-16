package test;

import algorithms.BST;
import algorithms.BinaryTree;
import algorithms.TreeNode;

public class Main
{
	public static void main(String[] args)
	{
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
	}
}
