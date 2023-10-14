import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeMaker {

    /**
     * 陣列轉TreeNode, 需要所有null底下的null (也就是null不能省略)
     * @param input
     * @return
     */
    public static TreeNode arrayToTreeNeedAllNull(Integer[] input){
        TreeNode root = createTreeNode(input, 1);
        return root;
    }

    private static TreeNode createTreeNode(Integer[] input, int index){
        if(index <= input.length){
            Integer value = input[index - 1];
            if(value != null){
                TreeNode t = new TreeNode(value);
                t.left = createTreeNode(input, index * 2);
                t.right = createTreeNode(input, index * 2 +1);
                return t;
            }
        }
        return null;
    }

    /**
     * 陣列轉TreeNode 並且可以省略非必要的null  (null節點的下層必定是null, 所以可以不用列在陣列中)
     * @param tree
     * @return
     */
    public static TreeNode arrayToTreeNodeWithoutUnnecessaryNull(Integer[] tree){
        if(tree.length == 0) return null;
        TreeNode root = new TreeNode(tree[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isLeft = true;
        for(int i = 1; i < tree.length; i++){
            TreeNode node = q.peek();
            if(node == null) continue;
            if(node.left == null && isLeft){
                if(tree[i] != null) {
                    node.left = new TreeNode(tree[i]);
                    q.add(node.left);
                }
                isLeft = false;
            }else if(node.right == null){
                if(tree[i] != null){
                    node.right = new TreeNode(tree[i]);
                    q.add(node.right);
                }
                q.remove();
                isLeft = true;
            }
        }
        return root;
    }



    //測試數據
    public static void main(String[] args) {
        Integer[] tree = new Integer[]{1, null, 2, 3};

        TreeNode treeNode = TreeNodeMaker.arrayToTreeNodeWithoutUnnecessaryNull(tree);

//        System.out.println(treeNode.val);//1
//        System.out.println(treeNode.left);//null
//        System.out.println(treeNode.right);//2
//        System.out.println(treeNode.right.left);//3
//        System.out.println(treeNode.right.right);//null
//        list.forEach(System.out::println); // postOrder is 3 2 1

        //另個測試
        /**
         *           5
         *      4            8
         *  11     n     13     4
         * 7  2  *n *n  n  n   n  1
         * (其中兩個*n 在陣列中省略了)
         */
        Integer[] tree2 = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}; //(,2後面已經省略兩個null)

        TreeNode t2 = TreeNodeMaker.arrayToTreeNodeWithoutUnnecessaryNull(tree2);
        System.out.println(t2);
        System.out.println(t2.left + "  " + t2.right);
        System.out.println(t2.left.left + "  " + t2.left.right + " , " + t2.right.left + "  " + t2.right.right);
        System.out.println(t2.left.left.left + "  " + t2.left.left.right);
        System.out.println("13下: " + t2.right.left.left + "  " + t2.right.left.right);
        System.out.println("4下: " + t2.right.right.left + "  " + t2.right.right.right);

    }



    public static Integer[] strToIntArray(String str){
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Integer[] arr = new Integer[strs.length];

        for(int i = 0; i < arr.length; i++){
            if(strs[i].equals("null")){
                arr[i] = null;
            }else{
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        return arr;
    }
}
