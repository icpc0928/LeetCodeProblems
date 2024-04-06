import java.util.Stack;

public class N98_ValidateBinarySearchTree {
    //Inorder Traversal 中序遍歷
    //Inorder traversal (中序遍歷) 會先拜訪左子節點，再拜訪父節點，最後拜訪右子節點。我們需要盡量往左子節點前進，而途中經過的父節點們就先存在一個 stack 裡面，等到沒有更多左子節點時，就把 stack 中的父節點取出並拜訪其右子節點。

     public static void main(String[] args) {
        Solution s = new Solution();
//        TreeNode root = TreeNodeMaker.arrayToTreeNeedAllNull(new Integer[]{5,4,6,null,null, 3, 7});
         TreeNode root = TreeNodeMaker.arrayToTreeNeedAllNull(new Integer[]{5,1,4,null,null, 3,6});
        System.out.println(s.isValidBST(root));
    }


    //做到中序遍歷 要呈現遞增狀態
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            Integer maxValue = null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode temp = root;
            while(temp != null || !stack.empty()){
                if(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }else{
                    TreeNode node = stack.pop();
                    if(maxValue!= null){
                        if(maxValue >= node.val) return false;
                    }else{
                        maxValue = node.val;
                    }
                    temp = node.right;
                }
            }
            return true;
        }


    }
}
