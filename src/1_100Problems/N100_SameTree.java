public class N100_SameTree {


    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {

            return checkSame(p, q);
        }

        private boolean checkSame(TreeNode p, TreeNode q) {
            if(p == null && q == null){
                return true;
            }
            if(p == null || q == null) return false;

            // p & q != null
            if(p.val != q.val) return false;

            return checkSame(p.left, q.left) &&
            checkSame(p.right, q.right);

        }
    }
}
