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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int in = inorder.length;
        int pre = preorder.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < in; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, pre - 1, inorder, 0, in - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int locateRoot = map.get(root.val);

        int leftEle = locateRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftEle, inorder, inStart, locateRoot - 1, map);

        root.right = buildTree(preorder, preStart + leftEle + 1, preEnd, inorder, locateRoot + 1, inEnd, map);

        return root;
    }
}
