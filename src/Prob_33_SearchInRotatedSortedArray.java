/**
 * 
 */

/**
 * @author ashuu
 *
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 */
public class Prob_33_SearchInRotatedSortedArray {

	
	 public int search1(int[] nums, int low,int high, int target) {
	        if(nums.length <= 0) {
	        	return -1;
	        }
	        if(high < low) {
	        	return -1;
	        }
	        int result = 0;
	        int mid = (low + high)/2;
	        
	        if(target == nums[mid]) {
	        	return mid;
	        }
	        if(nums[low] < nums[mid]) { //left is ordered normally
	        	if(target >= nums[low] && target <= nums[mid]) { //serach left
	        		search1(nums,low,mid-1,target);
	        	}else {
	        		search1(nums,mid+1,high,target);
	        	}
	        }else if( nums[mid]< nums[low]) { //right is ordered normally
	        	if (target > nums[mid] && target <= nums[high]) {
	        			return search1(nums, mid+ 1, high, target);// Search right
	        		} else {
	        		
	        			return search1(nums, low, mid - 1, target);// Search left
	        		}
	        		
	        	
	        	
	        }else if(nums[low] == nums[mid]){
	        	
	        	
	        	if (nums[mid] != nums[high]) {//If right is different, search it
	        		return search1(nums, mid+ 1, high, target);// search right
	        		} else {//Else, we have to search both halves
	        		
	        			int result1 = search1(nums, low, mid - 1, target);// Search left
	        		
	        			if (result1 == -1) {
	        				return search1(nums, mid+ 1, high, target);// Search right
	        			} else {
	        				return result1;
	        		}
	        		}
	        
	        	
	        }
	        
	        
	        return result;
	    }
	 
	 public int search(int[] nums, int target) {
	        if(nums.length <= 0) {
	        	return -1;
	        }
	        int high = nums.length -1;
	        int low = 0;
	        int result = 0;
	        while(low < high){
	            //calculate mid
	            int mid = ( low + high ) /2;
	            result = mid;
	            if(nums[mid] == target){
	                return result;
	            }else if (nums[low] <= nums[mid]){
	                 if(target >= nums[low] && target < nums[mid]){
	                     high = mid -1;
	                 }else{
	                     low = mid +1;
	                 }
	                
	            }else {
	                
	                if(target > nums[mid] && target <= nums[high]){
	                    low = mid +1;
	                }else{
	                    high = mid -1;
	                }
	                
	            }
	           
	        }
	        result = nums[low] == target ? low : -1;
	        return result;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_33_SearchInRotatedSortedArray obj = new Prob_33_SearchInRotatedSortedArray();
		 int[] nums = {4,5,6,7,0,1,2};
		// int[] nums1 = new int[0];
		 int target = 3;
		// int result = obj.search(nums, target);
		 //System.out.println("result="+result);
		 
		 int[] nums1 = {11,10,9,8,7,6,5};
		 target = 5;
		 int result1 = obj.search1(nums1, 0,nums1.length-1 ,target);
		 System.out.println("result="+result1);
	}

}
