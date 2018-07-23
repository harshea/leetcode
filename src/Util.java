/**
 * 
 */

/**
 * @author ashuu
 *
 */
public class Util {

	public static void printIntArray(int[] numbers) {
		System.out.print("[");
		for(int i=0;i<numbers.length;i++) {
			System.out.print(  numbers[i] );
			if(i != (numbers.length-1) ) {
				System.out.print(  "," );
			}
			
			
		}
		System.out.print("]");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
