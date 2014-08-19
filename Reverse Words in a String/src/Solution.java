public class Solution {
	public String reverseWords(String s) {
		String result = reverseString(s, 0, s.length() - 1);
		int startIndex = 0;
		int endIndex = result.indexOf(' ', startIndex);
		while (endIndex != -1) {
			result = reverseString(result, startIndex, endIndex - 1);
			startIndex = endIndex + 1;
			endIndex = result.indexOf(' ', startIndex);
		}
		result = reverseString(result, startIndex, result.length() - 1);
		return result;
	}

	public String reverseString(String s, int startIndex, int endIndex) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		if (startIndex > endIndex || startIndex < 0 || endIndex < 0) {
			return s;
		}
		char temp = 0;
		char[] temp_s = s.toCharArray();
		while (startIndex < endIndex) {
			temp = temp_s[startIndex];
			temp_s[startIndex] = temp_s[endIndex];
			temp_s[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		return String.copyValueOf(temp_s);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String test = "abc   def";
		System.out.println("\""
				+ solution.reverseString(test, 0, test.length() - 1) + "\"");
		System.out.println("\"" + solution.reverseWords(test) + "\"");
	}
}
