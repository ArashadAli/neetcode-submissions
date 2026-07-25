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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        goodNodeCheck(root, root.val);
        return count;
    }

    public void goodNodeCheck(TreeNode root, int maxVal) {
        if(root == null) return;
        if(root.val >= maxVal) count++;
        if(root.left != null) {
            maxVal = Math.max(maxVal, root.val);
            goodNodeCheck(root.left, maxVal);
        }
        if(root.right != null) {
            maxVal = Math.max(maxVal, root.val);
            goodNodeCheck(root.right, maxVal);
        }
    }
}
