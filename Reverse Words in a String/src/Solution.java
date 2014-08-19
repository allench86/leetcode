public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int end = s.length() - 1;
		int start = 0;
		while (end >= 0) {
			if (s.charAt(end) != ' ') {
				for (start = end; start >= 0; start--) {
					if (s.charAt(start) != ' ') {
						continue;
					} else {
						if (sb.length() != 0) {
							sb.append(" ");
						}
						sb.append(s.subSequence(start + 1, end + 1));
						end = start;
						break;
					}
				}
				if (start < 0) {
					if (sb.length() != 0) {
						sb.append(" ");
					}
					sb.append(s.subSequence(start + 1, end + 1));
					break;
				}
			}
			end--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println("\"" + solution.reverseWords("sdf fwerr  ") + "\"");
	}
}
