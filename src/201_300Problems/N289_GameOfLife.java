public class N289_GameOfLife {
    /**
     * 規則:
     * 附近活鄰居<2 死亡
     * 本活 附近 2 3 個鄰居 生存
     * 本活 附近>3個鄰居 死亡
     * 本死 附近==3個鄰居 活
     */

//Runtime: 1 ms, faster than 52.47% of Java online submissions for Game of Life.
//Memory Usage: 42.2 MB, less than 7.68% of Java online submissions for Game of Life.


    static class Solution {
        int[] sr = {-1, -1, 0, 1, 1,  1,  0, -1,};
        int[] sc = { 0,  1, 1, 1, 0, -1, -1, -1,};
        //  dead = 0;   //原本是死的還是死的
        //  lived =1;   //原本是活的還是活的
        int die = 2;    //原本是活的變成死了
        int live = 3;   //原本是死的變成活了

        public void gameOfLife(int[][] board) {

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    //counter
                    int counter = countLiveNeighbors(board, i, j);
                    if(board[i][j] == 0 && counter == 3){
                        board[i][j] = live; //原本是死的變成活了
                    }else if(board[i][j] == 1){
                        if(counter < 2 || counter > 3){
                            board[i][j] = die;  //原本是活的變成死了
                        }
                    }
                }
            }

            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == die) board[i][j] = 0;
                    else if(board[i][j] == live) board[i][j] = 1;
                }
            }
        }
        public int countLiveNeighbors(int[][] board, int r, int c){
            int counter = 0;
            for(int i = 0; i < sr.length; i++){
                if(r + sr[i] < 0 || r + sr[i] >= board.length || c + sc[i] < 0 || c + sc[i] >= board[r].length){
                    continue;
                }
                if(board[r + sr[i]][c + sc[i]] == 1 || board[r + sr[i]][c + sc[i]] == die){
                    counter++;
                }
            }
            return counter;
        }

    }




}
