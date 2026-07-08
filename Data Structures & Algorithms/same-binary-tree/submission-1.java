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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Base Case: If both rooms are empty, they are identical
        if (p == null && q == null) return true;
        
        // 2. Base Case: If only ONE is null (since we passed the check above), 
        // or if their values don't match, they are structurally different!
        if (p == null || q == null || p.val != q.val) return false;
        
        // 3. Delegate to Assistants: Check if left subtrees match AND right subtrees match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}