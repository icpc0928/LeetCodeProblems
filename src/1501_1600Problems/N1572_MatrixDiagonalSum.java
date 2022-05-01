import java.util.ArrayList;
import java.util.List;

public class N1572_MatrixDiagonalSum {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
     * Memory Usage: 47.5 MB, less than 70.90% of Java online submissions for Matrix Diagonal Sum.
     */

    public static void main(String[] args){

    }

    static class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;

            for(int i = 0; i < mat.length; i++){
                sum += mat[i][i] + mat[i][mat.length - i - 1];
            }
            if(mat.length % 2 != 0)
                sum -= mat[mat.length / 2][mat.length / 2];
            return sum;
        }
    }
}
