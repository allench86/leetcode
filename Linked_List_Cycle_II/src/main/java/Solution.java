public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n1;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;
        Solution s = new Solution();
        ListNode result = s.detectCycle(n1);
        System.out.println(result.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode loopHead = null;
        ListNode collisionPoint = null;
        ListNode slowRunner = head;
        ListNode fastRunner = head;

        while (slowRunner != null && fastRunner != null) {
            fastRunner = fastRunner.next;
            if (fastRunner == null) {
                break;
            }
            else {
                fastRunner = fastRunner.next;
            }
            slowRunner = slowRunner.next;

            if (fastRunner == slowRunner) {
                collisionPoint = fastRunner;
                break;
            }
        }

        if (collisionPoint != null) {
            loopHead = head;
            while (loopHead != collisionPoint) {
                loopHead = loopHead.next;
                collisionPoint = collisionPoint.next;
            }
        }

        return loopHead;
    }
}
