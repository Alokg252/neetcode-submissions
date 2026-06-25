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
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head.hashCode())) return true;
            head = head.next;
        }
        return false;
    }
}
