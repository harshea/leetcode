import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 */

/**
 * @author ashuu
 *
 */
public class Prob_94_BinaryTreeInorderTraversal {
	
	
	/*
	 * Approach 1: Recursive Approach
	 * The first method to solve this problem is using recursion. This is the classical method and is straightforward. 
	 * Complexity Analysis
	 * Time complexity : O(n). The time complexity is O(n) because the recursive function is T(n) = 2 * T(n/2)+1.
	 * Space complexity : The worst case space required is O(n), and in the average case it's O(log(n)) where n is number of nodes. 
	
	 */
	
	public List<Integer> inorderTraversalRecursive(TreeNode root,List <Integer> returnList) {
       
        
        if(root == null){
            return null;
            
        }   
        inorderTraversalRecursive(root.left,returnList);
        returnList.add((Integer)root.data);
        inorderTraversalRecursive(root.right,returnList);
        return returnList;
    }
	
	/**
	 * Complexity Analysis

		Time complexity : O(n).
		Space complexity : O(n). 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversalIterative(TreeNode root) {
       
		List <Integer> returnList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
    		   
    	//exist considtion
		
		while(current != null || !stack.isEmpty()) {
			
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			returnList.add((Integer)current.data);
			current = current.right;
		}
		
        return returnList;
    }
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_94_BinaryTreeInorderTraversal obj = new Prob_94_BinaryTreeInorderTraversal();
		List <Integer> returnList = new ArrayList<Integer>();
		
				//create leaf nodes
				TreeNode ThreeNode = TreeNode.createNode(3,null,null);
				
				TreeNode TwoNode = TreeNode.createNode(2,ThreeNode,null);
				
				//Craete other nodes
				
				TreeNode RootNode = TreeNode.createNode(1,null,TwoNode);
				
				obj.inorderTraversalRecursive(RootNode, returnList);
				System.out.println("Recursive returnList="+returnList);
				
				List <Integer> returnList1  = obj.inorderTraversalIterative(RootNode);
				System.out.println("Iterative returnList="+returnList1);
	}

}
