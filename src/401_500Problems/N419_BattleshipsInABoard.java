import java.util.HashMap;

/**
 * Runtime: 1 ms, faster than 80.36% of Java online submissions for Battleships in a Board.
 * Memory Usage: 43.8 MB, less than 68.72% of Java online submissions for Battleships in a Board.
 */

public class N419_BattleshipsInABoard {

    public static void main(String[] args){
        char[][] board = {
                {'X', '.', '.', 'X',},
                {'X', '.', '.', '.',},
                {'X', '.', '.', '.',},
        };
        Solution s = new Solution();
        System.out.println(s.countBattleships(board));
    }

    static class Solution {
        public int countBattleships(char[][] board) {
            int[][] countInBoard = new int[board.length][board[0].length];
            int result = 0;

            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[r].length; c++){
                    //DFS 如果該格是船 且 還沒被算過
                    if(board[r][c] == 'X' && countInBoard[r][c] == 0){
                        result++;
                        DFS(r, c, board, countInBoard, result);
                    }
                }
            }

            return result;
        }

        public void DFS(int r, int c, char[][] board, int[][] countInBoard, int nowCount){
            if(r < 0 || c < 0 || r >= board.length || c >= board[r].length || board[r][c] == '.'){
                return;
            }
            //已經算過惹
            if(countInBoard[r][c] != 0){
                return;
            }

            countInBoard[r][c] = nowCount;

            DFS(r + 1, c, board, countInBoard, nowCount);
            DFS(r - 1, c, board, countInBoard, nowCount);
            DFS(r, c + 1, board, countInBoard, nowCount);
            DFS(r, c - 1, board, countInBoard, nowCount);

        }
    }
}
