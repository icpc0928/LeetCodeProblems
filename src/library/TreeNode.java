public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int val){
        this.val = val;
    }


    public String toString(){
//        if(val == null) return null;
        return Integer.toString(val);
    }


}
