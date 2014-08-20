public class Solution {
    public String reverseWords(String s) {
        String[] wordsArray = s.split(" ");
        reverseArrayInspace(wordsArray);
        return joinStringArray(wordsArray);
    }

    public void reverseArrayInspace(String[] original) {
        if (original == null) {
            return;
        }
        for (int i = 0; i < original.length / 2; i++) {
            String temp = original[i];
            original[i] = original[original.length - i - 1];
            original[original.length - i - 1] = temp;
        }
    }

    public String joinStringArray(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (!stringArray[i].isEmpty()) {
                result.append(stringArray[i] + " ");
            }
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length()-1);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "   aewrwa    ";
        System.out.println("\"" + solution.reverseWords(test) + "\"");
    }
}
