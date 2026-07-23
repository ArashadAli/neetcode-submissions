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
        if(root == null) return false;

        if(isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode sub) {
        if(root == null && sub == null) return root == sub;

        return ((root != null && sub != null) && root.val == sub.val) 
                && isSame(root.left, sub.left)
                && isSame(root.right, sub.right);

    }
}
