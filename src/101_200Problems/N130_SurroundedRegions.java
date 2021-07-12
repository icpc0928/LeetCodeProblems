import java.util.Arrays;

public class N130_SurroundedRegions {

    //Runtime: 3 ms, faster than 31.88% of Java online submissions for Surrounded Regions.
    //Memory Usage: 49 MB, less than 6.73% of Java online submissions for Surrounded Regions.

    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] board = {
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'},
                {'O','O'},
                {'O','O'},
        };

        sol.solve(board);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");

            }
            System.out.println();
        }


    }


    static class Solution {
        public void solve(char[][] board) {
            char[][] newBoard = new char[board.length][board[0].length];

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(i == 0 || i == board.length - 1){
                        if(board[i][j] =='O'){
                            //do DFS
                            DFS(board, newBoard, i, j);
                        }
                    }else if(j == 0 || j == board[i].length - 1){
                        if(board[i][j] =='O'){
                            //do DFS
                            DFS(board, newBoard, i, j);
                        }
                    }
                }
            }

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(newBoard[i][j] != 'O'){
                        board[i][j] = 'X';
                    }
                }
            }

        }

        public void DFS(char[][] board, char[][] newBoard, int i, int j){
            if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O' || newBoard[i][j] == 'O') return;
            System.out.println("i: " + i + " , j: " + j);
            newBoard[i][j] = 'O';

            DFS(board, newBoard, i + 1, j);
            DFS(board, newBoard, i - 1, j);
            DFS(board, newBoard, i, j + 1);
            DFS(board, newBoard, i, j - 1);


        }


    }
}
