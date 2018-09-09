import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

/**
 * 
 */

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
Example 1: 
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.


 * @author ashuu
 *
 */
public class Prob_728_SelfDividingNumbers {

	public boolean checkDivisibility(int number){
        int temp = number;
      while(temp > 0){
          int digit = temp % 10;
          if( digit == 0 || (digit != 0 && number % digit >0 )){
               return false;      
          }
          temp = temp / 10; 
      }
      return true ;
  }
  
  public List<Integer> selfDividingNumbers(int left, int right) {
      List<Integer> result = new ArrayList<Integer>();
      for(int i = left ;i<=right ; i++){
             if(checkDivisibility(i)){
                 result.add(i);
             }
              
      }
       return result;
  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_728_SelfDividingNumbers obj = new Prob_728_SelfDividingNumbers();
		List<Integer> result = obj.selfDividingNumbers(20,21);
		result.stream().forEach(System.out::println);
		
		
		
	}
	

}
