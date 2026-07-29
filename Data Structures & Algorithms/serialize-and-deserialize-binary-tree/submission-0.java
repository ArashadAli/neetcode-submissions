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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            TreeNode curr = que.poll();
            if(curr == null) {
                res.append("n ");
                continue;
            }

            res.append(curr.val + " ");
            que.add(curr.left);
            que.add(curr.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] value = data.split(" ");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));

        que.add(root);

        for(int i = 1; i < value.length;) {
            TreeNode parent = que.poll();

            if(!value[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                parent.left = left;
                que.add(left);
            }
            i++;
            if(i < value.length && !value[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                parent.right = right;
                que.add(right);
            }
            i++;
        }

        return root;
    } 
}
