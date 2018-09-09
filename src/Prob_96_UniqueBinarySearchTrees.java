/**
 * 
 */

/**
 * @author ashuu
 *Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 *Example:
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 *
 *
 */
public class Prob_96_UniqueBinarySearchTrees {

	
	    public int numTrees(int n) {
	        int[] count = new int[n+1];
	        count[0] = 1;
	        count[1] = 1;
	        
	        //loop throught
	        for(int i= 2 ; i<= n ;i++){
	            for(int j = 0; j<i ;j++){
	                count[i] = count[i] + count[j] * count[i-j-1];
	            }
	        }
	        return count[n];
	    }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_96_UniqueBinarySearchTrees obj = new Prob_96_UniqueBinarySearchTrees();
		int output = obj.numTrees(3);
		System.out.println("No of Tree for input 3 is "+output);
		output = obj.numTrees(4);
		System.out.println("No of Tree for input 4 is "+output);
		output = obj.numTrees(5);
		System.out.println("No of Tree for input 5 is "+output);
	}

}
