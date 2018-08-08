/**
 * 
 */


/**
 * @author ashuu
 * This class used for all the problems related to Binary Tree
 */
public class TreeNode {

		Object data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			data = x;
			
		}
		
		/**
		 * @param data
		 * @param leafNode
		 * @param rightNode
		 */
		public TreeNode(Object data, TreeNode leafNode, TreeNode rightNode) {
			super();
			this.data = data;
			this.left = leafNode;
			this.right = rightNode;
		}
		
		public static TreeNode createNode(Object data,TreeNode leftNode,TreeNode rightNode) {
			TreeNode node = new TreeNode(data, leftNode, rightNode);
			return node;
		}
	
}
