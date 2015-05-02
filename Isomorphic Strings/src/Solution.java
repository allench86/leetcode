//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> value = map.get(c);
                value.add(i);
            }
            else {
                List<Integer> value = new ArrayList<Integer>();
                value.add(i);
                map.put(c, value);
            }
        }

        Set<Character> checkedChar = new HashSet<Character>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!checkedChar.contains(c)) {
                char key = s.charAt(i);
                List<Integer> value = map.get(key);
                for (int j = 0; j < value.size(); j++) {
                    if (t.charAt(value.get(j)) != c) {
                        return false;
                    }
                }
                map.remove(key);
                checkedChar.add(c);
            }
        }
        if (!map.isEmpty()) {
            return false;
        }
        return true;
    }
}
