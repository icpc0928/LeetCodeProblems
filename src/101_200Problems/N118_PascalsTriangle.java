import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class N118_PascalsTriangle {

    public static void main(String[] args){
        Solution solution = new Solution();
        int numRows = 5;
        List<List<Integer>> arrayLists = solution.generate(numRows);
        System.out.println(arrayLists.toString());
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            ArrayList<List<Integer>> arrayList = new ArrayList<>();

            arrayList.add(new ArrayList<>());
            arrayList.get(0).add(1);            //至少一個 一定是1

            for(int i = 1; i < numRows; i++){   //從第二層開始做
                List<Integer> row = new ArrayList<>();
                List<Integer> upRow = arrayList.get(i - 1); //取上一層的ArrayList

                //該層第一個
                row.add(1);
                for(int j = 1; j < i; j++){     //該層從第二個開始加入 直到最後第二個
                    row.add(upRow.get(j - 1) + upRow.get(j));   //將上層的上面兩個加上去然後插入
                }
                //該層最後一個
                row.add(1);
                //加入ArrayList
                arrayList.add(row);


            }
            return arrayList;
        }
    }
}
