/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// boss logic 
class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null || result != -1) return; // Stop if empty or already found

        // 1. Delegate to Left Assistant (smaller elements)
        inOrder(root.left);

        // 2. Boss Logic: Visit current node
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }

        // 3. Delegate to Right Assistant (larger elements)
        inOrder(root.right);
    }
}