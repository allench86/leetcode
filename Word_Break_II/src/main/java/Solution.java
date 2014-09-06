import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] input = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa" };
        System.out.println("S.length=" + s.length());
        // String s = "aaaaaaab";
        // String[] input = { "a", "aa", "aaa" };
        // String s = "catsanddog";
        // String[] input = { "cat", "cats", "and", "sand", "dogs" };
        Set<String> dict = buildDict(input);
        // dict.add("cat");
        // dict.add("cats");
        // dict.add("and");
        // dict.add("sand");
        // dict.add("dog");
        // dict.add("catsanddog");

        Solution solution = new Solution();
        solution.wordBreak(s, dict);
    }

    public static Set<String> buildDict(String[] input) {
        Set<String> dict = new HashSet<String>();
        for (String s : input) {
            dict.add(s);
        }
        return dict;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0 || dict == null) {
            return result;
        }
        Node root = new Node(-1, null);
        root.children.add(new Node(0, root));

        LinkedList<Node> starts = new LinkedList<Node>();
        starts.add(root);

        Queue<Node> currentLevel = new LinkedList<Node>();
        currentLevel.add(root);

        Node last = new Node(s.length(), null);

        while (!currentLevel.isEmpty()) {
            Node currentNode = currentLevel.poll();
            starts = currentNode.children;
            for (Node start : starts) {
                if (start.index != last.index) {
                    currentLevel.add(start);
                }
                for (int end = start.index + 1; end <= s.length(); end++) {
                    if (dict.contains(s.subSequence(start.index, end))) {
                        if (end == s.length()) {
                            last.children.add(start);
                            start.children.add(last);

                        }
                        else {
                            Node newEnd = new Node(end, start);
                            start.children.add(newEnd);
                        }
                    }
                }
            }
            // System.out.println(currentNode.index);
        }

        if (!last.children.isEmpty()) {
            for (Node pre : last.children) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(pre.index, last.index));
                Node parent = pre.parent;
                while (parent.index != -1) {
                    sb.insert(0, s.substring(parent.index, pre.index) + " ");
                    pre = parent;
                    parent = pre.parent;
                }
                System.out.println(sb);
            }
        }
        return result;
    }

    class Node {
        public int index;
        public LinkedList<Node> children = new LinkedList<Node>();
        public Node parent = null;

        public Node(int index, Node parent) {
            this.index = index;
            this.parent = parent;
        }
    }
}
