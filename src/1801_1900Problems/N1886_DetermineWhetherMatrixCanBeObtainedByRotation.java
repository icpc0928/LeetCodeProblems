public class N1886_DetermineWhetherMatrixCanBeObtainedByRotation {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
    //Memory Usage: 37.8 MB, less than 98.42% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] mat = {
                {0,1},
                {1,0}
        };
        int[][] target = {
                {1,0},
                {0,1}
        };
        System.out.println(solution.findRotation(mat, target));
    }


    static class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            //先檢查一次, 再跑回圈三次
            int rotated = 0;
            do{
                if(checkSameMatrix(mat, target)){
                    return true;
                }else if(rotated < 3){
                    rotate(mat);
                    rotated++;
                }else return false;
            }while(true);
        }

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
        public boolean checkSameMatrix(int[][] mat, int[][] target){
            for(int i = 0; i < mat.length; i++)
                for(int j = 0; j < mat[i].length; j++)
                    if(mat[i][j] != target[i][j])
                        return false;
            return true;
        }
    }
}
