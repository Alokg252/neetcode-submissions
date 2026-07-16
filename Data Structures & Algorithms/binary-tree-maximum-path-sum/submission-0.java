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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateGain(root);
        return maxSum;
    }

    private int calculateGain(TreeNode node) {
        if (node == null) return 0;

        // Get max gain from subtrees; ignore negative values
        int leftGain = Math.max(calculateGain(node.left), 0);
        int rightGain = Math.max(calculateGain(node.right), 0);

        // Update global max (path through this node as the "bridge")
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        // Return best path to parent (node + max of one side)
        return node.val + Math.max(leftGain, rightGain);
    }
}
