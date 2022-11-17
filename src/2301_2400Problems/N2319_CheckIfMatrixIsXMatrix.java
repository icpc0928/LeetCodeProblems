public class N2319_CheckIfMatrixIsXMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 0, 1},
                {0, 3, 1, 0},
                {0, 5, 2, 0},
                {4, 0, 0, 2},
        };
        Solution s = new Solution();
        System.out.println(s.checkXMatrix(grid));
    }


    static class Solution {
        public boolean checkXMatrix(int[][] grid) {
            int len = grid.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (isXPos(i, j, len)) {
                        //isXPos -> can't be 0
                        if (grid[i][j] == 0) return false;
                    } else {
                        if (grid[i][j] != 0) return false;
                    }
                }
            }
            return true;
        }

        private boolean isXPos(int i, int j, int len) {
            if (i == j) return true;
            else return len - 1 - i == j;
        }


    }
}

