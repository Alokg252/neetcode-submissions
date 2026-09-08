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
        if (head == null || head.next == null || k<=1) return head;
        ListNode temp = new ListNode(0, head), finalHead, next;
        Pair lp = new Pair(null, null), p = new Pair(null, null);

        for (int i=0; i<k-1; i++) {
            head = head.next;
            if (head == null)
                return temp.next;

        }
        finalHead = head;
        next = head.next;
        head.next = null;
        lp = reverseLL(temp.next);

        head = next;
        temp.next = next;

        if (head == null) return finalHead;
        
        while (true) {
            for (int i=0; i<k-1; i++) {
                head = head.next;
                if (head == null) {
                    lp.tail.next = next;
                    return finalHead;
                }
            }

            next = head.next;
            head.next = null;
            p = reverseLL(temp.next);
            lp.tail.next = p.head;
            lp = p;
            head = next;
            temp.next = next;

            if (head == null) return finalHead;
        }
    }

    public Pair reverseLL(ListNode head) {
        ListNode pre = null, cur = null, nex = head;
        while (nex != null) {
            pre = cur;
            cur = nex;
            nex = cur.next;

            cur.next = pre;
        }

        return new Pair(cur, head);
    }

    public static class Pair {
        ListNode head;
        ListNode tail;

        public Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}
