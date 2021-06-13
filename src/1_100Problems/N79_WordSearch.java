public class N79_WordSearch {

    public static void main(String[] args){
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {

            boolean[][] isGone = new boolean[board.length][board[0].length];

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(doTheMath(board, isGone, i, j, word, 0)){
                        return true;
                    }
                }
            }
            return false;
        }
        //          上  下  右  左
        int[] x = { 0,  0, 1, -1,};
        int[] y = { 1, -1, 0,  0,};


        public boolean doTheMath(char[][] board, boolean[][] isGone, int i, int j, String word, int charAt){
            char check = word.charAt(charAt);
            if(board[i][j] == check){
                //TODO

            }
            return false;
        }

    }


}
