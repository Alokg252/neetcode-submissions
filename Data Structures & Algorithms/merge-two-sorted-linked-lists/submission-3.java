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
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return n1 == null ? n2 : n1;

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (n1 != null && n2 != null) {

            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            }
            else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        cur.next = n1 == null ? n2 : n1;
        return dummy.next;
    }
}