import java.util.Arrays;

/**
 * 
 */

/**
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 * @author ashuu
 *
 */
public class Prob_88_MergeSortedArray {

	public static void mergeSortedArray(int[] nums1,int[] nums2,int lengthNums1,int lengthNums2) {
		System.out.println("lengthNums1="+lengthNums1+" and lengthNums2="+lengthNums2);
		int nums1Index = lengthNums1;
		int nums2Index = lengthNums2;
		int mergedIndex = lengthNums1 + lengthNums2 - 2;
		System.out.println("mergedIndex="+mergedIndex);
		
		while(nums1Index >= 0 && nums2Index >= 0) {
			if(nums1[nums1Index] > nums2[nums2Index]) {
				nums1[mergedIndex] = nums1[nums1Index];
				nums1Index--;
			}else {
				nums1[mergedIndex] = nums2[nums2Index];
				nums2Index--;
				nums1Index--; //do I need this condition, I didnt added this cond in leetcode and code is working fine
			}
			mergedIndex--;
		}
		
		//in case first array is less than second array, there will be some elements left in second array which need to take case
		//copy rest of the elements from second array
		
		if( mergedIndex == -1) {
			mergedIndex = lengthNums2 -1;
		}
		
		while(nums2Index >= 0) {
			nums1[mergedIndex] = nums2[nums2Index];
			nums2Index--;
			mergedIndex--;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = new int[6];
		array1[0] = 1;
		array1[1] = 2;
		array1[2] = 3;
		array1[3] = 0;
		array1[4] = 0;
		array1[5] = 0;
		
		
		int array2[] = new int[3];
		array2[0] = 4;
		array2[1] = 5;
		array2[2] = 6;
		mergeSortedArray(array1,array2,array1.length-1,array2.length-1);
		
		//display array
		
		System.out.println("Result:"+Arrays.toString(array1));
	}

}
