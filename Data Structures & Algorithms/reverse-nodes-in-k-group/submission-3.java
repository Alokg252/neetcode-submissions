class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are at least k nodes available
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Base Case: Fewer than k nodes remain, no reversal needed!
        if (count < k) return head;

        // Step 2: Delegate the remainder of the list to the assistant
        ListNode nextGroupHead = reverseKGroup(curr, k);

        // Step 3: Boss Logic — Reverse the current k nodes
        ListNode prev = nextGroupHead; // Connect tail directly to assistant's result
        curr = head;
        
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Return the new head of this reversed segment
        return prev;
    }
}