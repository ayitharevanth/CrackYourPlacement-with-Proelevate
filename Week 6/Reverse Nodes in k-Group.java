/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode nodeBeforeStart = dummy, startNode = curr;

        int i = 0;
        while (curr != null) {
            if (i % k == 0) startNode = curr;
            else curr = reverseAndGetCurr(nodeBeforeStart, startNode, curr);

            if (i % k == k - 1) nodeBeforeStart = curr;

            if (curr.next == null && i % k < k - 1 && i % k > 0) {
                startNode = nodeBeforeStart.next;
                curr = startNode.next;
                while (curr != null) {
                    curr = reverseAndGetCurr(nodeBeforeStart, startNode, curr);
                    curr = curr.next;
                }
                break;
            }

            curr = curr.next;
            i++;
        }

        return dummy.next;
    }

    private ListNode reverseAndGetCurr(ListNode nodeBeforeStart, ListNode startNode, ListNode curr) {
        ListNode t = nodeBeforeStart.next;
        nodeBeforeStart.next = curr;
        startNode.next = curr.next;
        curr.next = t;

        return startNode;
    }
}
