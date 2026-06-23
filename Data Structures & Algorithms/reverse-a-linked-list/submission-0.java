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
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        
        head = new ListNode(stack.pop());
        ListNode node = head;
        while (!stack.isEmpty()) {
            node.next = new ListNode(stack.pop());
            node = node.next;
        }

        return head;
    }
}
