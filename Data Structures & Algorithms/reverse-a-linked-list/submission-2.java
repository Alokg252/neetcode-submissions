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

 /* three pointer approach*/
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, next = head.next;

        while (cur != null) {
            cur.next = pre;

            if (next == null) break;;

            pre = cur;
            cur = next;
            next = next.next;
        }
        return cur;
    }
}
