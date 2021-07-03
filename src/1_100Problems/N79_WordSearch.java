public class N79_WordSearch {
    //Runtime: 75 ms, faster than 65.42% of Java online submissions for Word Search.
    //Memory Usage: 36.8 MB, less than 74.72% of Java online submissions for Word Search.

    public static void main(String[] args){
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(solution.exist(board, word));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {

            for(int i = 0 ; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(word.charAt(0) == board[i][j]){
                        //do DFS
                        if(DFS(board, i, j, word, 0)) return true;
                    }
                }
            }
            return false;
        }

        public boolean DFS(char[][] board, int i, int j, String word, int charAt){
            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || charAt >= word.length() || board[i][j] != word.charAt(charAt) ) return false;
            System.out.println("check: " + i + " , " + j);

            if(charAt == word.length() - 1){
                return true;
            }
            char t = board[i][j];
            board[i][j] = ' ';
            boolean found =
                    DFS(board,  i, j + 1, word, charAt + 1) ||
                    DFS(board,  i, j - 1, word, charAt + 1) ||
                    DFS(board,  i + 1, j, word, charAt + 1) ||
                    DFS(board,  i - 1, j, word, charAt + 1);
            board[i][j] = t;    //走失敗的話不留痕跡 很重要!!
            return found;
        }


    }


}
