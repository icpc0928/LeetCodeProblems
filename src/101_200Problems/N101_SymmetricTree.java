public class N101_SymmetricTree {


    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root.left == null && root.right == null) return true;
            return checkSymmetric(root.left, root.right);
        }

        private boolean checkSymmetric(TreeNode l, TreeNode r){
            if(l == null && r == null) return true;
            if(l == null || r == null) return false;
            if(l.val != r.val) return false;

            return checkSymmetric(l.left, r.right) && checkSymmetric(l.right, r.left);
        }
    }
}
