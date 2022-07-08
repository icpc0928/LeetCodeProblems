import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Runtime: 7 ms, faster than 14.96% of Java online submissions for The K Weakest Rows in a Matrix.
 * Memory Usage: 49 MB, less than 23.97% of Java online submissions for The K Weakest Rows in a Matrix.
 */
public class N1337_TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = {
                {1,1,1,1,1,},
                {1,1,1,1,1,},
                {1,1,1,1,1,},
                {1,1,1,1,1,},
                {1,1,1,1,1,},
//                {1,1,1,1,0,},
//                {1,0,0,0,0,},
//                {1,1,0,0,0,},
//                {1,1,1,1,1,},

        };
        int k = 3;
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, k)));
    }


    static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int[] result = new int[k];
            List<Integer> list = new ArrayList<>();
            int i = 0;


            for(int n = 0; n < mat[0].length; n++){
                for(int m = 0; m < mat.length; m++){
                    if(list.contains(m)){
                        continue;
                    }else{
                        if(mat[m][n] == 0){
                            result[i] = m;
                            list.add(m);
                            i++;
                            if(i == k) return result;
                        }
                    }
                }
            }

            for(int j = 0; j < mat.length; j++){
                if(list.contains(j)){
                    continue;
                }else{
                    result[i] = j;
                    i++;
                    if(i == k) return result;
                }
            }



            return result;
        }
    }
}
