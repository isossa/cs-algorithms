package algorithms;

import java.util.List;

public interface BinaryTreeTraversal
{
	/**
	 * @param nodeIn
	 */
	static void printInOrder(TreeNode nodeIn)
	{
		if (nodeIn != null)
		{
			printInOrder(nodeIn.left);
			System.out.println(nodeIn.data + " ");
			printInOrder(nodeIn.right);
		}
		return;
	}
	
	/**
	 * @param nodeIn
	 */
	static void printPreOrderTraversal(TreeNode nodeIn)
	{
		if (nodeIn != null)
		{
			System.out.println(nodeIn.data + " ");
			printPreOrderTraversal(nodeIn.left);
			printPreOrderTraversal(nodeIn.right);
		}
		return;
	}
	
	/**
	 * @param nodeIn
	 */
	static void printPostOrderTraversal(TreeNode nodeIn)
	{
		if (nodeIn != null)
		{
			printPostOrderTraversal(nodeIn.left);
			printPostOrderTraversal(nodeIn.right);
			System.out.println(nodeIn.data);
		}
	}
	
	/**
	 * @param nodeIn
	 * @return
	 */
	static List<TreeNode> postOrderTraversal(TreeNode nodeIn)
	{
		return null;
	}
}
