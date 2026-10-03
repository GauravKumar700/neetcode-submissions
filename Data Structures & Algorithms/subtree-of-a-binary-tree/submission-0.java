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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (root.val == subRoot.val && isEqual(root, subRoot)) {
            return true;
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return left || right;
    }

    public boolean isEqual(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isEqual(p.left, q.left) && isEqual(p.right, q.right);
    }
}
