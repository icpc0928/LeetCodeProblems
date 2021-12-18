public class N867_TransposeMatrix {

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] matrix = {
                {1,2,3,},
                {4,5,6,},
        };
        int[][] newMatrix = s.transpose(matrix);
        for(int i = 0; i < newMatrix.length; i++){
            for(int j = 0; j < newMatrix[i].length; j++){
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] result = new int[matrix[0].length][matrix.length];

//            for(int i = 0; i < matrix.length; i++){
//                for(int j = 0; j < matrix[i].length; j++){
//                    result[j][i] = matrix[i][j];
//                }
//            }
            for(int i = 0; i < matrix[0].length; i++){
                for(int j = 0; j < matrix.length; j++){
                    result[i][j] = matrix[j][i];
                }
            }
            return result;
        }
    }
}
