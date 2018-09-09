/**
 * 
 */

/**
 * @author ashuu
 *
 */
public class Prob_231_PowerOfTwo {

	
	public int parseInt(String str) {
		
		int length = str.length();
		for(int i =0;i<length;i++) {
			char c = str.charAt(i);
			//now we need to convert c to int so he said imagine you hv method
			int num = cToI(c);
			//but I m failed here how I can put this num to get actually whole number
		}
		return length;
		
		
	}
	
	public int cToI(char c) {
		return Character.getNumericValue(c); //dummy
	}
	
	public static boolean isPowerOfTwo(int num) {
		if (num == 0) {
			return false;
		}
		while(num % 2 == 0) {
			num = num / 2;
		}
		if(num == 1) {
			return true;
		}
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(6));
		//Integer.parseInt(s)
		
	}

}
