public class N999_AvailableCapturesForRook {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Available Captures for Rook.
     * Memory Usage: 41.3 MB, less than 63.38% of Java online submissions for Available Captures for Rook.
     * @param args
     */

    //自己人=> B   敵人=> p   空格=> .  我=>R

    public static void main(String[] args) {



        char[][] board = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','B'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
        };

        Solution solution = new Solution();

        System.out.println( board[0][0] == '.');
        System.out.println( board[1][3] == 'p');

        System.out.println(solution.numRookCaptures(board));
    }


    static class Solution {
        public int numRookCaptures(char[][] board) {

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == 'R'){
                        return doTheMeth(i, j, board);
                    }
                }
            }
            return 0;
        }


        public int doTheMeth(int i, int j, char[][] board){
            int counter = 0;
            for(int d = 0; d < direction.length; d++){
                boolean isCanAtt = canAtt(i, j, board, d);
//                System.out.println("IsCanAtt: " + isCanAtt);
                if(isCanAtt) counter++;
            }

            return counter;
        }

        int[][] direction = {
                {-1, 0,},
                {1,  0,},
                { 0,  1,},
                { 0, -1,},
        };

        public boolean canAtt(int i, int j, char[][] board, int dirIndex){
            System.out.println("dirIndex: " + dirIndex + " , i: " + i + " , j: " + j);
            if(i < 0 || i >= board.length || j < 0 || j >= board[i].length){
                return false;
            }
            if(board[i][j] == 'B'){
                return false;
            }

            if(board[i][j] == '.' || board[i][j] == 'R'){
                return canAtt(i + direction[dirIndex][0], j + direction[dirIndex][1], board, dirIndex);
            }

            return board[i][j] == 'p';
        }
    }
}
