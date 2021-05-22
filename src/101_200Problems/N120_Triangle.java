import java.util.ArrayList;
import java.util.List;

public class N120_Triangle {

    //Runtime: 3 ms, faster than 55.11% of Java online submissions for Triangle.
    //Memory Usage: 38.6 MB, less than 97.35% of Java online submissions for Triangle.

    public static void main(String[] args){
        Solution solution = new Solution();
        List<Integer> a1 = new ArrayList<>();
        a1.add(2);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        List<Integer> a3 = new ArrayList<>();
        a3.add(6);
        a3.add(5);
        a3.add(7);
        List<Integer> a4 = new ArrayList<>();
        a4.add(4);
        a4.add(1);
        a4.add(8);
        a4.add(3);
        List<List<Integer>> a = new ArrayList<>();

        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        System.out.println(solution.minimumTotal(a));




    }

    //用 N118 帕斯卡三角形的方式做,加總下去(但是以取最小值來做) 做到最底層 然後在最底層取最小值

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            List<Integer> row = triangle.get(0);
            for(int i = 1; i < triangle.size(); i++){       //index 1 這層開始做 (第二層)

                row = triangle.get(i);        //這一層
                List<Integer> preRow = triangle.get(i - 1); //上一層
                row.set(0, row.get(0) + preRow.get(0)); //第一個直上直下 加總

                System.out.println("I: " + i + " , row: " + row.toString() + " pRow: " + preRow.toString());

                for(int j = 1; j < row.size() - 1; j++){            //,第二個~倒數第二個 才要比對
                    row.set(j, row.get(j) + Math.min(preRow.get(j - 1), preRow.get(j)));
                }
                row.set(row.size() - 1, row.get(row.size() - 1) + preRow.get(preRow.size() - 1));    //最後一個 直上直下
            }
            int minNum = Integer.MAX_VALUE;

            for (Integer integer : row) {
                minNum = Math.min(minNum, integer);
            }
            return minNum;
        }
    }
}
