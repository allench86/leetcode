public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // insert nodes;
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }

        // copy random pointer;
        p = head;
        while (p != null) {
            p.next.random = p.random != null ? p.random.next : null;
            p = p.next.next;
        }

        // break the link;
        p = head;
        RandomListNode newHead = p.next;
        RandomListNode q = p.next;

        while (p != null && q != null) {
            p.next = q.next;
            if (q.next != null) {
                q.next = q.next.next;
            }
            p = p.next;
            q = q.next;
        }

        return newHead;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };
}
