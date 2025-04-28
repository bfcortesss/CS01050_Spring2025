
public class BinaryTreeTest
{

	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(4);
		tree.insert(2);
		tree.insert(6);
		tree.insert(0);
		tree.insert(4);

		int key = 2;
		if (tree.search(key))
		{
			System.out.println(key + " is in the tree");
		} else
		{
			System.out.println(key + " is not in tree");
		}

		key = 0;
		if (tree.search(key))
		{
			System.out.println(key + " is in the tree");
		} else
		{
			System.out.println(key + " is not in tree");
		}
	}

}

class BinarySearchTree
{

	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public boolean insert(int value)
	{
		if (root == null)
		{
			root = new TreeNode(value);
			return true;
		} else
		{
			return insertRecursive(root, value);
		}
	}

	private boolean insertRecursive(TreeNode current, int value)
	{
		System.out.println("Inserting " + value + " Visiting node: " + current.data);
		if (value < current.data)
		{
			if (current.left == null)
			{
				current.left = new TreeNode(value);
				return true;
			} else
			{
				return insertRecursive(current.left, value);
			}
		} else if (value > current.data)
		{
			if (current.right == null)
			{
				current.right = new TreeNode(value);
				return true;
			} else
			{
				return insertRecursive(current.right, value);
			}
		} else
		{
			System.out.println("Can't insert duplicate");
			return false;
		}
	}

	/*
	 * Non-recursive
	 * public boolean insert(int value) {
	 * 
	 * // If first node in the tree - then create root if (root == null) { root =
	 * new TreeNode(value); } else { // Locate the parent for the new node // Need a
	 * couple of references to help TreeNode parent = null; TreeNode current = root;
	 * 
	 * // While haven't reached bottom of tree while (current != null) { //
	 * Determine if value will be inserted to left or right of current if (value <
	 * current.data) { parent = current; current = current.left; } else if (value >
	 * current.data) { parent = current; current = current.right; } else { // Found
	 * a duplicate node - do not insert // this is a case for using a return in
	 * while loop return false; } } // while
	 * 
	 * if (value < parent.data) { parent.left = new TreeNode(value); } else {
	 * parent.right = new TreeNode(value); } } // else not root node
	 * 
	 * return true; } // insert
	 * 
	 */

	public boolean search(int key)
	{
		return searchRecursive(root, key);
	}

	private boolean searchRecursive(TreeNode current, int key)
	{
		if (current == null)
		{
			return false; // key not found
		} else if (key == current.data)
		{
			return true; // key found
		} else if (key < current.data)
		{
			return searchRecursive(current.left, key); // search left subtree
		} else
		{
			return searchRecursive(current.right, key); // search right subtree
		}
	}

	/*
	 * Non recursive
	 * Searches binary tree for a specific key public boolean search(int key) {
	 * boolean found = false; // Indicates if key is in tree TreeNode current =
	 * root; // Start at the root of the tree
	 * 
	 * // While the key is not found and end of tree is not reached while (!found &&
	 * current != null) {
	 * 
	 * // Move current either to the left or right child node if (key <
	 * current.data) { current = current.left; } else if (key > current.data) {
	 * current = current.right; } else { //notice a return doesn't need to be used
	 * found = true; } } // while
	 * 
	 * return found; } // search
	 */

	private static class TreeNode
	{
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}

	} // TreeNode

} // BinarySearch