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
    // The Global Record Board to track the largest diameter seen anywhere
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; // Reset for safety
        calculateHeight(root);
        return maxDiameter; // The board holds our final winner
    }

    private int calculateHeight(TreeNode root) {
        // Step 1: Base Case
        if (root == null) return 0;

        // Step 2: Delegate to assistants to get HEIGHTS
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // Step 3: Boss's Secret Side-Calculation
        // The path through the current node would be left path + right path
        int currentDiameter = leftHeight + rightHeight;
        
        // If this path breaks the record, update the global board!
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Step 4: Normal Return (Pass your height up to your own boss)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}