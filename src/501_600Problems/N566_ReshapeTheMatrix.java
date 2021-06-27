public class N566_ReshapeTheMatrix {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] mat = {
                {1,2,},
                {3,4,},
        };
        int r = 1;
        int c = 4;

        int[][] ans = solution.matrixReshape(mat, r, c);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if(r * c != mat[0].length * mat.length){
                return mat;
            }
            int[][] ans = new int[r][c];
            int counter = 0;
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[i].length; j++){
                    ans[counter / c][counter % c] = mat[i][j];
                    counter++;
                }
            }

            return ans;
        }
    }
}
