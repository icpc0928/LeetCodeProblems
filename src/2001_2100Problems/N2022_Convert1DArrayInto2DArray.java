public class N2022_Convert1DArrayInto2DArray {
    /**
     * Runtime: 7 ms, faster than 60.73% of Java online submissions for Convert 1D Array Into 2D Array.
     * Memory Usage: 120.1 MB, less than 30.13% of Java online submissions for Convert 1D Array Into 2D Array.
     * @param args
     */

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] original = {1,2,3,4};
        int m = 2;
        int n = 2;

        System.out.println(solution.construct2DArray(original, m, n));
    }

    static class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            if(m * n != original.length) return new int[0][0];

            int[][] grid = new int[m][n];
            for(int i = 0; i < original.length; i++){
                grid[i / n][i % n] = original[i];
            }
            return grid;
        }
    }
}
