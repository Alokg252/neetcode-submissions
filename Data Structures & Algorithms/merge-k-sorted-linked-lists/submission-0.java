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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(list);
        ListNode temp = new ListNode();
        ListNode head = temp;
        for (int i=0; i<list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            head.next = node;
            head = node;
        }

        return temp.next;
    }
}
