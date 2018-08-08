

/**
 * 
 */

/**
 * @author ashuu Given a binary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 *         
 *         Note: A leaf is a node with no children.
 * 
 *         Example:
 * 
 *         Given binary tree [3,9,20,null,null,15,7],
 */
public class Prob_104_MaximumDepthofBinaryTree {

	/**
	 * Definition for a binary tree node.
	 * 
	 * public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
	 * x) { val = x; } }
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			
		}
	}

	public TreeNode createNode(int data) {
		TreeNode node = new TreeNode(data);
		node.left = null;
		node.right = null;
		return node;
	}
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftTree = maxDepth(root.left);
		int rightTree = maxDepth(root.right);
		
		return Math.max(leftTree, rightTree) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_104_MaximumDepthofBinaryTree bt = new Prob_104_MaximumDepthofBinaryTree();
		//create leaf nodes
		TreeNode NinthNode = bt.createNode(9);
		TreeNode FifteenNode = bt.createNode(15);
		TreeNode SeventhNode = bt.createNode(7);
		TreeNode TwentyNode = bt.createNode(20);
		//Craete other nodes
		
		TreeNode RootNode = bt.createNode(3);
		RootNode.left = NinthNode;
		RootNode.right = TwentyNode;
		
		TwentyNode.left = SeventhNode;
		TwentyNode.right = FifteenNode;
		
		int heightOfBT = bt.maxDepth(RootNode);
		System.out.println("heightOfBT="+heightOfBT);
	}

}
