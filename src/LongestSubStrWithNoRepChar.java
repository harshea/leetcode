import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author ashuu 
 * Given a string, find the length of the longest substring
 *         without repeating characters.
 * 
 *         Examples:
 * 
 *         Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 *         Given "bbbbb", the answer is "b", with the length of 1.
 * 
 *         Given "pwwkew", the answer is "wke", with the length of 3. Note that
 *         the answer must be a substring, "pwke" is a subsequence and not a
 *         substring.
 */
public class LongestSubStrWithNoRepChar {

	/**
	 * Approach 2: Sliding Window Algorithm
	 * 
	 * The naive approach is very straightforward. But it is too slow. So how can we
	 * optimize it?
	 * 
	 * In the naive approaches, we repeatedly check a substring to see if it has
	 * duplicate character. But it is unnecessary. If a substring s_{ij}s ​ij ​​
	 * from index ii to j - 1j−1 is already checked to have no duplicate characters.
	 * We only need to check if s[j]s[j] is already in the substring s_{ij}s ​ij ​​
	 * .
	 * 
	 * To check if a character is already in the substring, we can scan the
	 * substring, which leads to an O(n^2)O(n ​2 ​​ ) algorithm. But we can do
	 * better.
	 * 
	 * By using HashSet as a sliding window, checking if a character in the current
	 * can be done in O(1)O(1).
	 * 
	 * A sliding window is an abstract concept commonly used in array/string
	 * problems. A window is a range of elements in the array/string which usually
	 * defined by the start and end indices, i.e. [i, j)[i,j) (left-closed,
	 * right-open). A sliding window is a window "slides" its two boundaries to the
	 * certain direction. For example, if we slide [i, j)[i,j) to the right by 11
	 * element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).
	 * 
	 * Back to our problem. We use HashSet to store the characters in current window
	 * [i, j)[i,j) (j = ij=i initially). Then we slide the index jj to the right. If
	 * it is not in the HashSet, we slide jj further. Doing so until s[j] is already
	 * in the HashSet. At this point, we found the maximum size of substrings
	 * without duplicate characters start with index ii. If we do this for all ii,
	 * we get our answer.
	 * 
	 * @param s
	 * @return
	 */

	public static int lengthOfLongestSubstring(String s) {

		int i = 0;
		int j = 0;
		int ans = 0;
		int len = s.length();
		Set<Character> charSet = new HashSet<Character>();
		while (i <len && j <len) {
			Character chr = s.charAt(j);
			if (!charSet.contains(chr)) {
				charSet.add(chr);
				j++;
				ans = Math.max(ans, j - i);
			} else {
				charSet.remove(s.charAt(i));
				i++;
			}
		}
		return ans;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = lengthOfLongestSubstring("abcabcbb");
		System.out.println("Longest stbstr len for abcabcbb ="+ans);
		ans = lengthOfLongestSubstring("bbbbb");
		System.out.println("Longest stbstr len for bbbbb ="+ans);
		ans = lengthOfLongestSubstring("pwwkew");
		System.out.println("Longest stbstr len for pwwkew ="+ans);
		
	}

}
