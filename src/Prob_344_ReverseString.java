/**
 * 
 */

/**
 * 
 * Write a function that takes a string as input and returns the string reversed.
Example 1:
Input: "hello"
Output: "olleh"
Example 2:
Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"


 * @author ashuu
 *
 */
public class Prob_344_ReverseString {
	
	/**
	 * here we are using swap method to reverse string
	 * @param inputStr
	 * @return
	 */
	public String reverseString(String inputStr) {
		char[] charArray = inputStr.toCharArray();
		int i =0;
		int j = inputStr.length() -1;
		
		while(i <= j) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			i++;j--;
		}
		
				
		return String.valueOf(charArray);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob_344_ReverseString obj = new Prob_344_ReverseString();
		String input = "A man, a plan, a canal: Panama";
		
		System.out.println(obj.reverseString(input));
		
		input = "hello";
		System.out.println(obj.reverseString(input));
	}

}
