//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "ab";
        String b = "bc";
        System.out.println(s.minDistance(a, b));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int word1Length = word1.length();
        int word2Length = word2.length();

        if (word1Length == 0) {
            return word2Length;
        }

        if (word2Length == 0) {
            return word1Length;
        }

        int[][] distance = new int[word1Length + 1][word2Length + 1];

        for (int i = 0; i <= word1Length; i++) {
            // distance[i][0] is for case when word2 is an empty string
            distance[i][0] = i;
        }

        for (int j = 0; j <= word2Length; j++) {
            // distance[0][j] is for case when word1 is an empty string
            distance[0][j] = j;
        }

        for (int i = 1; i <= word1Length; i++) {
            for (int j = 1; j <= word2Length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                }
                else {
                    // set word1(i) is 'string1a', word2(j) is 'string2b'
                    // distance[i-1][j-1] -> change from word1(i-1) to word2(j-1) which is from 'string1' to 'string2'
                    // distance[i-1][j] -> change from word1(i-1) to word2(j) which is from 'string1' to 'string2b'
                    // distance[i][j-1] -> change from word1(i) to word2(j-1) which is from 'string1a' to 'string2'
                    int t = Math.min(distance[i - 1][j - 1], distance[i - 1][j]);
                    distance[i][j] = Math.min(t, distance[i][j - 1]) + 1;
                }
            }
        }

        return distance[word1Length][word2Length];
    }
}
