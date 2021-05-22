import java.util.ArrayList;
import java.util.List;

public class N119_PascalsTriangleII {
    //只需rowIndex那層的List
    public static void main(String[] args){
        Solution solution = new Solution();
        int rowIndex = 6;
        List<Integer> row = solution.getRow(rowIndex);
        System.out.println(row.toString());
    }

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1); //<-第0層

            for(int i = 1; i <= rowIndex; i++){
                int j = i - 1;
                while (j > 0){
                    ans.set(j, ans.get(j) + ans.get(j - 1));
                    j--;
                }

                ans.add(1);     //<-該層最後一個
            }
            return ans;
        }
    }
}
