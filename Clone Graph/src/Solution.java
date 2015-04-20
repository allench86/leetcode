//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//OJ's undirected graph serialization:
//Nodes are labeled uniquely.
//
//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//Second node is labeled as 1. Connect node 1 to node 2.
//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//Visually, the graph looks like the following:
//
//       1
//      / \
//     /   \
//    0 --- 2
//         / \
//         \_/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode newGraph = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode child : node.neighbors) {
            stack.add(child);
        }
        visited.put(node, newGraph);

        while (!stack.isEmpty()) {
            UndirectedGraphNode curr = stack.pop();
            if (!visited.containsKey(curr)) {
                for (UndirectedGraphNode child : curr.neighbors) {
                    stack.add(child);
                }
                visited.put(curr, new UndirectedGraphNode(curr.label));
            }
        }

        Set<UndirectedGraphNode> keys = visited.keySet();
        for (UndirectedGraphNode key : keys) {
            UndirectedGraphNode newNode = visited.get(key);

            for (UndirectedGraphNode child : key.neighbors) {
                newNode.neighbors.add(visited.get(child));
            }
        }

        return newGraph;
    }

    public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };
}
