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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1. Go as far left as possible (down to the smallest elements)
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. Process the smallest available node
            curr = stack.pop();
            k--; // We've visited one element!

            // 3. If k hits 0, this is our kth smallest element!
            if (k == 0) {
                return curr.val;
            }

            // 4. Move to the right child
            curr = curr.right;
        }

        return -1;
    }
}