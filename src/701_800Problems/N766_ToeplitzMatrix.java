public class N766_ToeplitzMatrix {

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3,4,},
                {5,1,2,3,},
                {9,5,1,2,},
        };
        Solution s = new Solution();
        System.out.println(s.isToeplitzMatrix(matrix));
    }


    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1])
                        return false;
                }
            }
            return true;
        }
    }
}
