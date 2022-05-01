import java.util.HashSet;
import java.util.Set;

/**
 * Runtime: 78 ms, faster than 15.53% of Java online submissions for Check if Every Row and Column Contains All Numbers.
 * Memory Usage: 96.5 MB, less than 13.77% of Java online submissions for Check if Every Row and Column Contains All Numbers.
 */

public class N2133_CheckIfEveryRowAndColumnContainsAllNumbers {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3,},
                {3,1,2,},
                {2,3,1,},
        };
        System.out.println(solution.checkValid(matrix));

    }
    static class Solution {
        public boolean checkValid(int[][] matrix) {
            Set<Integer> check = new HashSet<>();

            //查橫向
            for(int i = 0; i < matrix.length; i++){
                check = new HashSet<>();
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] <= matrix.length && matrix[i][j] > 0 && !check.contains(matrix[i][j])){
                        check.add(matrix[i][j]);
                    }else return false;
                }
            }

            //查直向
            for(int j = 0; j < matrix[0].length; j++){
                check = new HashSet<>();
                for(int i = 0; i < matrix.length; i++){
                    if(matrix[i][j] <= matrix.length && matrix[i][j] > 0 && !check.contains(matrix[i][j])){
                        check.add(matrix[i][j]);
                    }else return false;
                }
            }
            return true;
        }
    }
}
