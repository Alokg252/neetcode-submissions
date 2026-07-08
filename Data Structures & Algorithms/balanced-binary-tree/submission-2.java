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
class Solution {
    public boolean isBalanced(TreeNode root) {
        // If our height calculator returns -1, it means an imbalance was found
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) return 0;

        // 1. Ask Left Assistant for height
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // Pass the failure up!

        // 2. Ask Right Assistant for height
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // Pass the failure up!

        // 3. Boss Logic: Check current node's balance
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Found an imbalance! Break early.
        }

        // 4. If balanced, return the actual height normally
        return Math.max(leftHeight, rightHeight) + 1;
    }
}