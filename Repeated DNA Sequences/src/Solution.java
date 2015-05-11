import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "GAGAGAGAGAGA";
        List<String> results = s.findRepeatedDnaSequences(a);
        for (String i : results) {
            System.out.print(i + ", ");
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<String>();

        if (s != null && !s.isEmpty() && s.length() > 10) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('A', 0);
            map.put('C', 1);
            map.put('G', 2);
            map.put('T', 3);

            HashMap<Integer, Integer> seqCount = new HashMap<Integer, Integer>();

            int highBitMark = 0x000fffff;
            int strToInt = 0;

            for (int i = 0; i < 10; i++) {
                char c = s.charAt(i);
                int j = map.get(c);
                strToInt += j;
                strToInt <<= 2;
            }
            strToInt >>= 2;
            seqCount.put(strToInt, 1);

            for (int i = 10; i < s.length(); i++) {
                char c = s.charAt(i);
                int j = map.get(c);
                strToInt <<= 2;
                strToInt &= highBitMark;
                strToInt += j;

                if (!seqCount.containsKey(strToInt)) {
                    seqCount.put(strToInt, 1);
                }
                else {
                    int count = seqCount.get(strToInt);
                    if (count == 1) {
                        results.add(s.substring(i - 10 + 1, i + 1));
                    }
                    seqCount.put(strToInt, count + 1);
                }
            }
        }

        return results;
    }
}
