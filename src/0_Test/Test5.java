import java.util.*;

public class Test5 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String treeStr = "[1,null,2,3]";
        Integer[] array = new Integer[] {1, null, 2, 3};
        TreeNode treeNode =  TreeNodeMaker.arrayToTreeNeedAllNull(array);
        System.out.println(treeNode.val);//1
        System.out.println(treeNode.left);//null
        System.out.println(treeNode.right);//2
        System.out.println(treeNode.right.left);
        System.out.println(treeNode.right.right);
//        var re = s.inorderTraversal2(treeNode);
//        System.out.println(re);

    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            //Inorder traversal (中序遍歷) 會先拜訪左子節點，
            // 再拜訪父節點，最後拜訪右子節點。
            // 我們需要盡量往左子節點前進，而途中經過的父節點們就先存在一個 stack 裡面，
            // 等到沒有更多左子節點時，就把 stack 中的父節點取出並拜訪其右子節點。
            List<Integer> result = new ArrayList<>();
            TreeNode temp = root;
            Stack<TreeNode> stack = new Stack<>();
            while(temp != null || !stack.empty()){
                if(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }else{
                    TreeNode t = stack.pop();
                    result.add(t.val);
                    temp = t.right;
                }
            }
            return result;
        }

        public List<Integer> inorderTraversal2(TreeNode root) {
            //Inorder traversal (中序遍歷) 會先拜訪左子節點，
            // 再拜訪父節點，最後拜訪右子節點。
            // 我們需要盡量往左子節點前進，而途中經過的父節點們就先存在一個 stack 裡面，
            // 等到沒有更多左子節點時，就把 stack 中的父節點取出並拜訪其右子節點。
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
