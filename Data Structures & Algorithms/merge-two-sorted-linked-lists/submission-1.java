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

        ListNode head = null, temp = null;
        while (n1 != null && n2 != null) {

            if (n1.val <= n2.val) {
                if (head == null) head = n1;
                if (n1.next != null && (n1.next.val <= n2.val)) n1 = n1.next;
                else {
                    temp = n1.next;
                    n1.next = n2;
                    n1 = n2;
                    n2 = temp;
                }
            }
            else {
                if (head == null) head = n2;
                if (n2.next != null && (n2.next.val <= n1.val)) n2 = n2.next;
                else {
                    temp = n2.next;
                    n2.next = n1;
                    n2 = n1;
                    n1 = temp;
                }
            }
        }

        return head;
    }
}