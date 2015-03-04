public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                return words[i].length();
            }
        }

        return 0;
    }
}