import java.util.Arrays;

public class N240_SearchA2DMatrixII {

    public static void main(String[] args){
        Solution solution = new Solution();
        int target = 15;
        int[][] matrix = {
                { 1, 4, 7,11,15},
                { 2, 5, 8,12,19},
                { 3, 6, 9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30},
        };



        boolean ans = solution.searchMatrix(matrix, target);
        System.out.println(ans);
    }


    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
                return false;

            int i = matrix.length - 1;
            int j = 0;

            //左下至右上找 這條對角線分割出 小跟大 如果提早到邊上了,會繼續做直到頂點或過頭惹則跳出
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] == target)
                    return true;
                else if (target > matrix[i][j]) //目標大於目前 =>往右走(往大的方向)
                    j++;
                else                            //目標小於目前 =>往上走(往小的方向)
                    i--;
            }
            return false;

        }
    }
}
