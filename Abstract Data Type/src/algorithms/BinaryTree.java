package algorithms;

public class BinaryTree implements BinaryTreeTraversal
{	
	public TreeNode root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public BinaryTree(int dataIn)
	{
		root = new TreeNode(dataIn);
	}
	
	public void insert(int dataIn)
	{
		root = insert(root, dataIn);
	}
	
	public TreeNode insert(TreeNode nodeIn, int dataIn)
	{
		if (nodeIn == null)
		{
			nodeIn = new TreeNode(dataIn);
		}
		else if (nodeIn.left == null)
		{
			nodeIn.left = insert(nodeIn.left, dataIn);
		}
		else if (nodeIn.right == null)
		{
			nodeIn.right = insert(nodeIn.right, dataIn);
		}
		else
		{
			nodeIn.left = insert(nodeIn.left, dataIn);
		}
		return nodeIn;
	}
	
	// Return whether the BST contains NODE_IN
	public boolean contains(TreeNode nodeIn)
	{
		if (nodeIn == null)
			return false;
		
		return contains(root, nodeIn);
	}
	
	private boolean contains(TreeNode rootIn, TreeNode nodeIn)
	{
		if (rootIn == null || nodeIn == null)
			return false;
		
		if (rootIn.data == nodeIn.data)
			return true;
		
		return contains(rootIn.left, nodeIn) || contains(rootIn.right, nodeIn);
	}
	
	/**
	 * Print the pre-order traversal of the nodes in this binary tree
	 * starting from the root.
	 */
	public void printPreOrderTraversal()
	{
		BinaryTreeTraversal.printPreOrderTraversal(root);
	}
	
	/**
	 * Print the pre-order traversal of the nodes in this binary tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printPreOrderTraversal(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printPreOrderTraversal(nodeIn);
	}

	/**
	 * Print the in-order traversal of the nodes in this binary tree
	 * starting from the root.
	 */
	public void printInOrder()
	{
		BinaryTreeTraversal.printInOrder(root);
	}
	
	/**
	 * Print the in-order traversal of the nodes in this binary tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printInOrder(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printInOrder(nodeIn);
	}

	/**
	 * Print the post-order traversal of the nodes in this binary tree
	 * starting from the root.
	 */
	public void printPostOrderTraversal()
	{
		BinaryTreeTraversal.printPostOrderTraversal(root);
	}
	
	/**
	 * Print the post-order traversal of the nodes in this binary tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printPostOrderTraversal(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printPostOrderTraversal(nodeIn);
	}
}
