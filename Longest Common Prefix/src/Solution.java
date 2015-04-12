// Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0) {
            return prefix;
        }

        int minLength = Integer.MAX_VALUE;
        int minLengthIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minLengthIndex = i;
            }
        }

        boolean flag = true;
        prefix = strs[minLengthIndex];
        for (int i = 0; i < minLength; i++) {
            char p = strs[minLengthIndex].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != p) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                prefix = strs[minLengthIndex].substring(0, i);
                break;
            }
        }
        return prefix;
    }
}
