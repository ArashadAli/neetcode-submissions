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
        int ans = calHeight(root);
        if(ans == -1) return false;
        return true;
    }

    public int calHeight(TreeNode root) {
        if(root == null) return 0;
        // here i am finding the left height
        int lh = calHeight(root.left);

        if(lh == -1) return -1;
        // here i am finding the right height
        int rh = calHeight(root.right);
        if(rh == -1) return -1;
        // and checking the diff lh - rh > 1 then the tree is not the balance binary tree
        if(Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
