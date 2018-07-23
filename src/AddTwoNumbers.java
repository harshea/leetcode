
/**
 * 
 */

/**
 * @author ashuu
 *
 *         You are given two non-empty linked lists representing two
 *         non-negative integers. The digits are stored in reverse order and
 *         each of their nodes contain a single digit. Add the two numbers and
 *         return it as a linked list.
 * 
 *         You may assume the two numbers do not contain any leading zero,
 *         except the number 0 itself.
 * 
 *         Example
 * 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation:
 *         342 + 465 = 807.
 * 
 *         Approach 1: Elementary Math Intuition
 * 
 *         Keep track of the carry using a variable and simulate
 *         digits-by-digits sum starting from the head of list, which contains
 *         the least-significant digit.
 * 
 *         Illustration of Adding two numbers
 * 
 *         Figure 1. Visualization of the addition of two numbers: 342 + 465 =
 *         807342+465=807. Each node contains a single digit and the digits are
 *         stored in reverse order.
 * 
 *         Algorithm
 * 
 *         Just like how you would sum two numbers on a piece of paper, we begin
 *         by summing the least-significant digits, which is the head of l1l1
 *         and l2l2. Since each digit is in the range of 0 \ldots 90…9, summing
 *         two digits may "overflow". For example 5 + 7 = 125+7=12. In this
 *         case, we set the current digit to 22 and bring over the carry =
 *         1carry=1 to the next iteration. carrycarry must be either 00 or 11
 *         because the largest possible sum of two digits (including the carry)
 *         is 9 + 9 + 1 = 199+9+1=19.
 * 
 *         The pseudo code is as following:
 * 
 *         1.Initialize current node to dummy head of the returning list.
 *         2. Initialize carry to 0. 
 *         3.Initialize p and q to head of l1 and l2 respectively.
 *         4.Loop through lists l1 and l2 until you reach both
 *         ends. 
	 *         1.Set x to node p value. If p has reached the end of l1,set to 0.
	 *         2.Set y to node 1 value. If qq has reached the end of l2,set to 0.
	 *         3.Set sum = x + y + carry. 
	 *         4.Update carry = sum / 10. 
	 *         Create a new node with the digit value of (sum mod 10)and set it to current node's next, then advance
	 *         current node to next.
	 *         5.Advance both p and q. 
 *         5.Check if carry = 1, if so append a new node with digit 11 to the returning list.
 *         6.Return dummy head's next node. 
 *         
 *         Note that we use a dummy head to
 *         simplify the code. Without a dummy head, you would have to write
 *         extra conditional statements to initialize the head's value
 */
public class AddTwoNumbers {

	/**
	 * case 1 : if length of l1 > l2 case 2 : if length of l2 <l1
	 * 
	 * @param
	 * @param l2
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode p = l1;
		ListNode q = l2;
		int carry = 0;
		ListNode current = dummy;

		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			// System.out.println("x="+x+" and y="+y+" and carry="+carry);
			int sum = x + y + carry;
//			System.out.println("sum="+sum);
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return dummy.next;

	}

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode l1 = obj.new ListNode(2);
		ListNode l2 = obj.new ListNode(4);
		ListNode l3 = obj.new ListNode(3);
		l1.append(l2);
		l2.append(l3);

		ListNode l11 = obj.new ListNode(5);
		ListNode l21 = obj.new ListNode(6);
		ListNode l31 = obj.new ListNode(4);
		l11.append(l21);
		l21.append(l31);

		System.out.println("First list =" + l1.toString());
		System.out.println("Second list =" + l11.toString());

		ListNode resultNode = obj.addTwoNumbers(l1, l11);
		System.out.println("Result list =" + resultNode.toString());

		// ######CASE2#########
		System.out.println("######## CASE2 #########");

		ListNode test1 = obj.new ListNode(2);
		ListNode test2 = obj.new ListNode(4);
		test1.append(test2);

		ListNode test11 = obj.new ListNode(5);
		ListNode test12 = obj.new ListNode(6);
		ListNode test13 = obj.new ListNode(4);
		test11.append(test12);
		test12.append(test13);

		System.out.println("First list =" + test1.toString());
		System.out.println("Second list =" + test11.toString());

		ListNode resultNode1 = obj.addTwoNumbers(test1, test11);
		System.out.println("Result list =" + resultNode1.toString());

		// ######CASE3#########
		System.out.println("######## CASE3 #########");
		ListNode test21 = obj.new ListNode(2);
		ListNode test22 = obj.new ListNode(4);
		ListNode test23 = obj.new ListNode(6);
		test21.append(test22);
		test22.append(test23);

		ListNode test211 = obj.new ListNode(5);
		ListNode test222 = obj.new ListNode(6);
		test211.append(test222);

		System.out.println("First list =" + test21.toString());
		System.out.println("Second list =" + test211.toString());

		ListNode resultNode21 = obj.addTwoNumbers(test21, test211);
		System.out.println("Result list =" + resultNode21.toString());

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}

		public void append(ListNode node) {
			this.next = node;
		}

		public int get() {
			return this.val;
		}

		public String toString() {
			String result = val + " ";
			if (next != null) {
				result += "->" + next.toString();
			}
			return result;
		}
	}

}
