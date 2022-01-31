public class N931_MinimumFallingPathSum {
    //n == matrix.length == matrix[i].length
    //1 <= n <= 100
    //-100 <= matrix[i][j] <= 100

    //Runtime: 4 ms, faster than 69.69% of Java online submissions for Minimum Falling Path Sum.
    //Memory Usage: 47.4 MB, less than 6.00% of Java online submissions for Minimum Falling Path Sum.

    public static void main(String[] args){
        int[][] matrix = {
                {2,1,3,},
                {6,5,4,},
                {7,8,9,},
        };
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(matrix));

    }


    static class Solution {
        public int minFallingPathSum(int[][] matrix) {
            if(matrix.length == 1){
                return matrix[0][0];
            }

            for(int i = matrix.length-2; i >= 0; i--){
                for(int j = 0; j < matrix[i].length; j++){
                    int min = Integer.MAX_VALUE;
                    for(int k = 0; k < fallingPosition.length; k++){
                        min = Math.min(min, getFallingValue(matrix, i+1, j + fallingPosition[k]));
                    }
                    matrix[i][j] = min + matrix[i][j];
                    System.out.println(matrix[i][j]);
                }
            }
            int result = Integer.MAX_VALUE;
            for(int j = 0; j < matrix[0].length; j++){
                result = Math.min(result, matrix[0][j]);
            }


            return result;
        }

        int[] fallingPosition = {-1, 0, 1};
        public int getFallingValue(int[][] matrix, int sr, int sc){
            if(sc < 0 || sc >= matrix[sr].length)
                return Integer.MAX_VALUE;
            else {
                System.out.println("matrix:"+matrix[sr][sc]);
                return matrix[sr][sc];
            }
        }
    }
}
