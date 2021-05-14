public class N59_SpiralMatrixII {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    //Memory Usage: 36.9 MB, less than 70.25% of Java online submissions for Spiral Matrix II.

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 31;
        int[][] ans;

        ans = solution.generateMatrix(n);

        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                if(ans[i][j] >= 100){
                    System.out.print("" + ans[i][j] + " | ");
                }else if (ans[i][j] >= 10){
                    System.out.print(" " + ans[i][j] + " | ");
                }else{
                    System.out.print("  " + ans[i][j] + " | ");
                }

            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int counter = 1;

            while (counter <= n * n) {
                ans[i][j] = counter;
                nextForward(ans);
                counter++;
            }

            return ans;
        }

        //前進方向   右, 下, 左, 上,
        public int[] fi = {0, 1,  0, -1,};
        public int[] fj = {1, 0, -1,  0,};
        public int i = 0, j = 0;
        public int count = 0;

        //選擇下一個進行的點位
        public void nextForward(int[][] ans){
            int tempI = i + fi[count % 4];
            int tempJ = j + fj[count % 4];
            if(tempI >= ans.length || tempJ >= ans.length || tempI < 0 || tempJ < 0 || ans[tempI][tempJ] != 0){
                count++;
            }
            i += fi[count % 4];
            j += fj[count % 4];


        }
    }
}
