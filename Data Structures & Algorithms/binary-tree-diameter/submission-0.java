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
    private int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int h = maxDepth(root);
        return this.height;
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        this.height = Math.max(height, left + right);
        return Math.max(left, right) + 1;
    }
}
