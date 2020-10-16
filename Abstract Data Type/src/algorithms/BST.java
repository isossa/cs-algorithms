package algorithms;

public class BST implements BinaryTreeTraversal
{
	/**
	 * Root of binary search tree.
	 */
	public TreeNode root;
	
	/**
	 * Default constructor.
	 */
	public BST()
	{
		root = null;
	}
	
	/**
	 * Custom constructor.
	 * @param dataIn value of this node.
	 */
	public BST(int dataIn)
	{
		root = new TreeNode(dataIn);
	}
	
	/**
	 * Insert a node into this tree.
	 * @param dataIn value of the node to add.
	 */
	public void insert(int dataIn)
	{
		root = insert(root, dataIn);
	}
	
	/**
	 * Insert a node after the specified node.
	 * @param nodeIn
	 * @param dataIn
	 * @return
	 */
	public TreeNode insert(TreeNode nodeIn, int dataIn)
	{
		if (nodeIn == null)
		{
			nodeIn = new TreeNode(dataIn);
		}
		else if (dataIn <= nodeIn.data)
		{
			nodeIn.left = insert(nodeIn.left, dataIn);
		}
		else
		{
			nodeIn.right = insert(nodeIn.right, dataIn);
		}
		return nodeIn;
	}
	
	/**
	 * Implements a binary search and return whether the binary search tree contains
	 * the specified node.
	 * 
	 * @param nodeIn node to search for.
	 * @return True if the node is in the binary search tree.
	 */
	public boolean contains(TreeNode nodeIn)
	{
		return contains(root, nodeIn);
	}
	
	/**
	 * Helper method that implements a binary search algorithm. 
	 * @param rootIn Root of this binary search tree.
	 * @param nodeIn Node to search for.
	 * @return True if the node is found otherwise false.
	 */
	private boolean contains(TreeNode rootIn, TreeNode nodeIn)
	{
		if (rootIn == null || nodeIn == null)
			return false;
		
		if (rootIn.data == nodeIn.data)
			return true;
		else if (nodeIn.data < rootIn.data)
			return contains(rootIn.left, nodeIn);
		else
			return contains(rootIn.right, nodeIn);
	}

	/**
	 * Print the pre-order traversal of the nodes in this binary search tree
	 * starting from the root.
	 */
	public void printPreOrderTraversal()
	{
		BinaryTreeTraversal.printPreOrderTraversal(root);
	}
	
	/**
	 * Print the pre-order traversal of the nodes in this binary search tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printPreOrderTraversal(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printPreOrderTraversal(nodeIn);
	}

	/**
	 * Print the in-order traversal of the nodes in this binary search tree
	 * starting from the root.
	 */
	public void printInOrder()
	{
		BinaryTreeTraversal.printInOrder(root);
	}
	
	/**
	 * Print the in-order traversal of the nodes in this binary search tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printInOrder(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printInOrder(nodeIn);
	}

	/**
	 * Print the post-order traversal of the nodes in this binary search tree
	 * starting from the root.
	 */
	public void printPostOrderTraversal()
	{
		BinaryTreeTraversal.printPostOrderTraversal(root);
	}
	
	/**
	 * Print the post-order traversal of the nodes in this binary search tree
	 * starting from the specified node if it is contained in the tree.
	 * 
	 * @param nodeIn root of the subtree considered.
	 */
	public void printPostOrderTraversal(TreeNode nodeIn)
	{
		BinaryTreeTraversal.printPostOrderTraversal(nodeIn);
	}
}
