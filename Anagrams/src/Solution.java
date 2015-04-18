import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs != null && strs.length > 0) {
            HashMap<String, List<String>> dict = new HashMap<String, List<String>>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String toS = new String(chars);
                if (dict.containsKey(toS)) {
                    List<String> value = dict.get(toS);
                    value.add(s);
                }
                else {
                    List<String> value = new ArrayList<String>();
                    value.add(s);
                    dict.put(toS, value);
                }
            }
            Set<String> keys = dict.keySet();
            for (String key : keys) {
                if (dict.get(key).size() > 1) {
                    result.addAll(dict.get(key));
                }
            }
        }

        return result;
    }
}
