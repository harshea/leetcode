

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
	
		public  static void print(TreeNode n) {
	        print("", n, false);
	    }

	    public  static void print(String prefix, TreeNode n, boolean isLeft) {
	        if (n != null) {
	            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
	            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
	            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
	        }
	    }
		
}
