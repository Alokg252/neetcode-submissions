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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        if (head.next == null) return null;
        
        ListNode node = head;
        while (head != null) {
            len++;
            head = head.next;
        }

        len = len - n;
        if (len == 0) return node.next;
        
        head = node;
        while (len-- > 1) {
            head = head.next;
        }

        var first = head;
        var second = head.next;
        var third = head.next.next;

        second.next = null;
        first.next = third;

        return node;
    }
}
