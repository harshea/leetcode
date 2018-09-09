import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author ashuu
 *
 *Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *Example:
 *Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
public class Prob_95_UniqueBinarySearchTrees_II {

	 public List<TreeNode> generatreTrees(int number) {
		 
		 List<TreeNode> treeNodeList = new ArrayList<>();
		 if(number <= 0) {
			 return treeNodeList;
		 }
		
		 treeNodeList = calculateTrees(1,number);
		 
		 return treeNodeList;
	 }
	
	 public List<TreeNode> calculateTrees(int start, int end) {
		
		 List<TreeNode> result = new ArrayList<TreeNode>();
		 
		 if(start > end) {
			 result.add(null) ;
			 return result;
		 }
		 
		 for(int i = start ;i<=end ;i++) {
			List<TreeNode> leftTress =  calculateTrees(start,i-1);
			List<TreeNode> rightTrees = calculateTrees(i+1,end);
			for (TreeNode lt : leftTress) {
				for(TreeNode rt : rightTrees) {
					TreeNode current = new TreeNode(i);
					current.left = lt;
					current.right = rt;
					result.add(current);
				}
			}
		 }
		 
		 return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Prob_95_UniqueBinarySearchTrees_II obj = new Prob_95_UniqueBinarySearchTrees_II();
		List<TreeNode> results = obj.generatreTrees(3);
		System.out.println("results="+results.size());
		
		for(TreeNode ts : results){
			TreeNode.print(ts);
		}
		
		
	}

}
