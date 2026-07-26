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
        List<Integer> store = new ArrayList<>();
        inOrderTraverse(root, store);
        return store.get(k - 1);
    }

    public void inOrderTraverse(TreeNode root, List<Integer> store) {
        if(root == null) return;
        inOrderTraverse(root.left, store);
        store.add(root.val);
        inOrderTraverse(root.right, store);
    }
}
