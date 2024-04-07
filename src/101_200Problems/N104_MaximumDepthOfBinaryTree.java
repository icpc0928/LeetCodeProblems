public class N104_MaximumDepthOfBinaryTree {

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
    static class Solution {
        public int maxDepth(TreeNode root) {

            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int depth){
            if(node == null) return depth;
            return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
        }
    }
}
