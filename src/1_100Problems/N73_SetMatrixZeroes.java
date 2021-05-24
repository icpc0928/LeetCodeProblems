import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N73_SetMatrixZeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 0},


        };
        solution.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);

            }
            System.out.println();
        }
    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            //對每格做檢查,如果是0,則上方與左方標記為0

            //做完後跑第一橫列的陣列 是0的話該垂直行 要全部變成0
            //跑第一縱行 是0的話該橫列全部變成0
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (row.contains(i) || col.contains(j))
                        matrix[i][j] = 0;
                }
            }


        }
    }
}
