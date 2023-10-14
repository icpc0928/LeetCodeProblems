import java.util.ArrayList;
import java.util.List;

public class N94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution s = new Solution();
//        TreeNode root = TreeNodeMaker.arrayToTreeNodeWithoutUnnecessaryNull(new Integer[]{1,null,2,3});
        TreeNode root = TreeNodeMaker.arrayToTreeNodeWithoutUnnecessaryNull(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(s.inorderTraversal(root));
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderTra(root, result);
            return result;
        }

        private void inorderTra(TreeNode root, List<Integer> result){
            if(root == null) return;
            //先往左查詢
            inorderTra(root.left, result);
            result.add(root.val);
            inorderTra(root.right, result);
        }
    }
}
