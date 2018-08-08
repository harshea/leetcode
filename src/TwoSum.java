import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author ashuu Given an array of integers, return indices of the two numbers
 *         such that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         Example:
 * 
 *         Given nums = [2, 7, 11, 15], target = 9,
 * 
 *         Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */
public class TwoSum {

	/**
	 * Approach 1: Brute Force The brute force approach is simple. Loop through each
	 * element x and find if there is another value that equals to target. 
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n^2). For each element, we try to find its complement by
	 * looping through the rest of array which takes O(n) time. Therefore, the time
	 * complexity is O(n^2)O(n ​2 ​​ ).
	 * 
	 * Space complexity : O(1).
	 * 
	 * 
	 */
	public static int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int j = i + 1;
			while (j < length) {
				if (j < length && (nums[i] + nums[j]) == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
				j++;

			}

		}
		return result;
	}
	
	/**
	 * Approach 3: One-pass Hash Table It turns out we can do it in one-pass. While
	 * we iterate and inserting elements into the table, we also look back to check
	 * if current element's complement already exists in the table. If it exists, we
	 * have found a solution and return immediately. Complexity Analysis:
	 * 
	 * Time complexity : O(n). We traverse the list containing n elements only
	 * once. Each look up in the table costs only O(1) time.
	 * 
	 * Space complexity : O(n). The extra space required depends on the number
	 * of items stored in the hash table, which stores at most n elements.
	 */
	public static int[] twoSumUsingHashMap(int[] nums, int target) {
		Map<Integer,Integer> IntMap = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			int complement = target - nums[i];
			if(IntMap.containsKey(complement)) {
				return new int[] {IntMap.get(complement),i};
			}
			IntMap.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
	/**
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 11, 15 };
		int target = 18;
		int[] results = twoSum(nums, target);
		Util.printIntArray(results);
		
		int[] results1 = twoSumUsingHashMap(nums, target);
		Util.printIntArray(results1);

	}

}
