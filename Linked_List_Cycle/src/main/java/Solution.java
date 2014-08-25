public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        // n1.next = n1;
        // n2.next = n1;
        // n3.next = n4;
        // n4.next = n1;
        Solution s = new Solution();
        boolean result = s.hasCycle(n1);
        System.out.println(result);
    }

    public boolean hasCycle(ListNode head) {
        boolean result = false;
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
                result = true;
                break;
            }
        }

        return result;
    }
}
