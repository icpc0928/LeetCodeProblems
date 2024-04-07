public class N111_MinimumDepthOfBinaryTree {


    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            return dfs(root, 0);
        }

        private int dfs(TreeNode treeNode, int depth){

            if(treeNode == null) return Integer.MAX_VALUE;

            if(treeNode.right == null && treeNode.left == null) {
                return depth;
            }

            return Math.min(dfs(treeNode.right, depth + 1), dfs(treeNode.left, depth + 1));
        }
    }
}
