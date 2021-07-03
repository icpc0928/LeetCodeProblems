public class N48_RotateImage {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
    //Memory Usage: 38.9 MB, less than 70.69% of Java online submissions for Rotate Image.
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        solution.rotate(matrix);
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            for(int i = 0; i < (n + 1) / 2; i++){   //0~3
                for(int j = 0; j < n / 2; j++){     //0~2
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }
    }
}
