

public class N112_PathSum {

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


    public static void main(String[] args){
        Solution sol = new Solution();
        String str = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        int target = 22;
        TreeNode root = TreeNode.makeTree(str);
        System.out.println(sol.hasPathSum(root, target));
    }

    static class Solution {
        boolean ans = false;
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            goTree(root, targetSum, 0);
            return ans;
        }
        public void goTree(TreeNode cur, int target, int curSum){
            if(cur == null) return;
            if(cur.left == null && cur.right == null && target == curSum + cur.val){
                ans = true;
                return;
            }
            goTree(cur.left, target, curSum + cur.val);
            goTree(cur.right, target, curSum + cur.val);

        }
    }
}
