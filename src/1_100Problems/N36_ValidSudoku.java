public class N36_ValidSudoku {

    //Runtime: 2 ms, faster than 80.05% of Java online submissions for Valid Sudoku.
    //Memory Usage: 38.6 MB, less than 91.43% of Java online submissions for Valid Sudoku.

    public static void main(String[] args){
        Solution solution = new Solution();
        String[][] stringBoard = {
                {"5","3",".", ".","7",".", ".",".","."},
                {"6",".",".", "1","9","5", ".",".","."},
                {".","9","8", ".",".",".", ".","6","."},

                {"8",".",".", ".","6",".", ".",".","3"},
                {"4",".",".", "8",".","3", ".",".","1"},
                {"7",".",".", ".","2",".", ".",".","6"},

                {".","6",".", ".",".",".", "2","8","."},
                {".",".",".", "4","1","9", ".",".","5"},
                {".",".",".", ".","8",".", ".","7","9"},};
        char[][] board = new char[stringBoard.length][stringBoard[0].length];

        //String to Char
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = stringBoard[i][j].charAt(0);
            }
        }


        System.out.println(solution.isValidSudoku(board));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] != '.' && !isGood(board, i, j, board[i][j])){
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isGood(char[][] board, int r , int c , char val){
            //這個九宮格中
            int si = (r / 3) * 3;
            int sj = (c / 3) * 3;
            //直檢查 要跳過自己
            for(int i = 0; i < 9; i++){
                if(board[r][i] == val && i != c) {
                    return false;
                }
            }
            //橫檢查 要跳過自己
            for(int i = 0; i < 9; i++){
                if(board[i][c] == val && i != r) {
                    return false;
                }
            }

            //九宮格檢查
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[si + i][sj + j] == val && ((si + i) != r && (sj + j) != c) ) return false;
                }
            }
            return true;
        }
    }
}
