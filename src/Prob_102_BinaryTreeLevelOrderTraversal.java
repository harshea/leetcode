import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 */

/**
 * @author ashuu
 *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class Prob_102_BinaryTreeLevelOrderTraversal {

	
	private List<List<Integer>> levelOrderTraversal(TreeNode rootNode) {
		Queue<TreeNode> parentQueue = new LinkedBlockingQueue<TreeNode>();
		Queue<TreeNode> childQueue = new LinkedBlockingQueue<TreeNode>();
		parentQueue.add(rootNode);
		
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		List<Integer> childList = new ArrayList<Integer>();
		
		while(!parentQueue.isEmpty() || !childQueue.isEmpty() ) {
			TreeNode currentNode = parentQueue.poll();
			if(currentNode != null) {
				//System.out.print(currentNode.data+" ");
				childList.add((Integer)currentNode.data);
				
				if(currentNode.left != null) {
					childQueue.add(currentNode.left);	
				}
				if(currentNode.right != null) {
					childQueue.add(currentNode.right);	
				}
				
			}
			
			
			//flip the queue childqueue is become parent queue
			if(parentQueue.isEmpty()) {
				Queue<TreeNode> tempQueue = childQueue;
				childQueue = parentQueue;
				parentQueue = tempQueue;
				//System.out.print("\n");
				returnList.add(childList);
				childList = new ArrayList<Integer>();
				
				
			}
		}
		return returnList;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//create Level 2 leaf nodes
				TreeNode FifteenNode = TreeNode.createNode(15, null, null);
				TreeNode SevenNode = TreeNode.createNode(7, null, null);				
				TreeNode OneNode = TreeNode.createNode(1, null, null);
				TreeNode TwoNode = TreeNode.createNode(2, null, null);	
				
				//create Level 1 leaf nodes
				TreeNode NineNode = TreeNode.createNode(9, OneNode, TwoNode);
				TreeNode TwentyNode = TreeNode.createNode(20, FifteenNode, SevenNode);				
						
						
				//create Level 0 leaf nodes
				TreeNode ThreeNode = TreeNode.createNode(3, NineNode, TwentyNode); //This is the root Node
				
				
				Prob_102_BinaryTreeLevelOrderTraversal btl = new Prob_102_BinaryTreeLevelOrderTraversal();
				List<List<Integer>> returnList = btl.levelOrderTraversal(ThreeNode);
				System.out.println("============");
				for (List<Integer> list : returnList) {
					System.out.println(Arrays.toString(list.toArray()));
				}
	}

	

}
