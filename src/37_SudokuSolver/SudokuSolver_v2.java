public class SudokuSolver_v2 {
    //在暴力解法之前,先將可能性全部剔除(但並沒有仔細剔除,之前留的可能還有部分(可待優化))
    //速度6ms 使用36.7mb記憶體 比79.7%的人快,比34.54%的人使用更少的記憶體
    //如果做兩次剔除可優化到36.4mb 比65%的人用更少的記憶體


    public static void main(String[] args){
    Solution solution = new Solution();
    String[][] stringBoard = {
//            {"5","3",".", ".","7",".", ".",".","."},
//            {"6",".",".", "1","9","5", ".",".","."},
//            {".","9","8", ".",".",".", ".","6","."},
//
//            {"8",".",".", ".","6",".", ".",".","3"},
//            {"4",".",".", "8",".","3", ".",".","1"},
//            {"7",".",".", ".","2",".", ".",".","6"},
//
//            {".","6",".", ".",".",".", "2","8","."},
//            {".",".",".", "4","1","9", ".",".","5"},
//            {".",".",".", ".","8",".", ".","7","9"},

                {".",".","9","7","4","8",".",".","."},
                {"7",".",".",".",".",".",".",".","."},
                {".","2",".","1",".","9",".",".","."},
                {".",".","7",".",".",".","2","4","."},
                {".","6","4",".","1",".","5","9","."},
                {".","9","8",".",".",".","3",".","."},
                {".",".",".","8",".","3",".","2","."},
                {".",".",".",".",".",".",".",".","6"},
                {".",".",".","2","7","5","9",".","."},
    };

//        {".",".","9","7","4","8",".",".","."},
//        {"7",".",".",".",".",".",".",".","."},
//        {".","2",".","1",".","9",".",".","."},
//        {".",".","7",".",".",".","2","4","."},
//        {".","6","4",".","1",".","5","9","."},
//        {".","9","8",".",".",".","3",".","."},
//        {".",".",".","8",".","3",".","2","."},
//        {".",".",".",".",".",".",".",".","6"},
//        {".",".",".","2","7","5","9",".","."},


    char[][] board = new char[stringBoard.length][stringBoard[0].length];

    //String to Char
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++){
            board[i][j] = stringBoard[i][j].charAt(0);
        }
    }

    solution.solveSudoku(board);

    //print
    for(int i = 0; i < board.length; i++){
        if(i % 3 == 0 ){
            System.out.println("  ----------------------");
        }
        for(int j = 0; j < board[i].length; j++){
            if(j % 3 == 0){
                System.out.print(" |");
            }

            System.out.print(" " + board[i][j]);
            if(j == board[i].length - 1)
                System.out.print("|");
        }
        System.out.println();
    }
}

    static class Solution {
        public void solveSudoku(char[][] board) {

            //複製布林陣列
            boolean[][] canChange = new boolean[board.length][board[0].length];
            //複製字串陣列
            String[][] poss = new String[board.length][board[0].length];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    canChange[i][j] = board[i][j] == '.';
                    poss[i][j] = canChange[i][j] ? "123456789" : "";
                }
            }
            for(int t = 0; t < 2; t++){
                for(int i = 0; i < board.length; i++)
                    for(int j = 0; j < board[i].length; j++)
                        if(!canChange[i][j])    //尋訪每個固定的 並刪除其可能性
                            removePoss(board[i][j], i, j, poss, canChange, board);
            }


            //開始:
            int[] pos = new int[2];
            do{
                sudokuSolver(board, pos, poss, canChange, true);
            }while (!flag);
        }

        public boolean flag = false;

        public void removePoss(char check, int i, int j, String[][] poss, boolean[][] canChange, char[][] board){
            //直線去除
            //橫線去除
            for(int s = 0; s < 9; s++){
                if(canChange[s][j]){
                    poss[s][j] = poss[s][j].replace(String.valueOf(check), "");
                    poss[i][s] = poss[i][s].replace(String.valueOf(check), "");
                    //若可能性只剩下一個,則填入數字
                    if(poss[s][j].length() == 1){
                        board[s][j] = poss[s][j].charAt(0);
                        canChange[s][j] = false;
                    }
                    if(poss[i][s].length() == 1){
                        board[i][s] = poss[i][s].charAt(0);
                        canChange[i][s] = false;
                    }
                }
            }
            //九宮格去除
            int si = (i / 3) * 3;
            int sj = (j / 3) * 3;
            for(int gi = 0; gi < 3; gi++){
                for(int gj = 0; gj < 3; gj++){
                    if(canChange[si + gi][sj + gj]){
                        poss[si + gi][sj + gj] = poss[si + gi][sj + gj].replace(String.valueOf(check), "");
                        //若可能性只剩下一個,則填入數字
                        if(poss[si + gi][sj + gj].length() == 1){
                            board[si + gi][sj + gj] = poss[si + gi][sj + gj].charAt(0);
                            canChange[si + gi][sj + gj] = false;
                        }
                    }
                }
            }

        }

        public void sudokuSolver(char[][] board, int[] pos, String[][] poss, boolean[][] canChange, boolean fb){
            //算完惹
            if(pos[0] == 9){
                flag = true;
                return;
            }



            //如該格還沒被做過
            if(board[pos[0]][pos[1]] == '.'){
                for(int po = 0; po < poss[pos[0]][pos[1]].length(); po++){
                    //如果該值吻合
                    if(isGood(board, pos[0], pos[1], poss[pos[0]][pos[1]].charAt(po))){
                        board[pos[0]][pos[1]] = poss[pos[0]][pos[1]].charAt(po);
                        //下一格
                        forwardBack(pos , true, canChange);
                        return;
                    }
                }
                //1-9都不能裝,則開始退位
                forwardBack(pos, false, canChange);
            }
            //如果這格可以做,且曾經被做過 則迴圈使用 目前數字+1 到 9 去跑
            else if(canChange[pos[0]][pos[1]]){
                for(int po = poss[pos[0]][pos[1]].indexOf(board[pos[0]][pos[1]]) + 1; po < poss[pos[0]][pos[1]].length(); po++){
                    //如果該值吻合
                    if(isGood(board, pos[0], pos[1], poss[pos[0]][pos[1]].charAt(po))){
                        board[pos[0]][pos[1]] = poss[pos[0]][pos[1]].charAt(po);
                        //下一格
                        forwardBack(pos, true, canChange);
                        return ;
                    }
                }
                //X-9都不能裝,則開始退位 且該格清空為'.'
                board[pos[0]][pos[1]] = '.';
                forwardBack(pos, false, canChange);
            }
            //僅供第一格如果是已知的數字
            else{
                forwardBack(pos, true, canChange);
            }
        }

        public boolean isGood(char[][] board, int r , int c , char val){
            //這個九宮格中
            int si = (r / 3) * 3;
            int sj = (c / 3) * 3;
            //直橫檢查
            for(int i = 0; i < 9; i++){
                if(board[r][i] == val || board[i][c] == val) return false;
            }
            //九宮格檢查
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[si + i][sj + j] == val) return false;
                }
            }
            return true;
        }

        public void forwardBack(int[] pos, boolean fw, boolean[][] canChange){

            do {
                //前進
                if(fw){
                    //換行
                    if(pos[1] == 8){
                        pos[0]++;
                        pos[1] = 0;

                    }
                    //換下一格
                    else{
                        pos[1]++;

                    }
                }
                //後退
                else{
                    //換行
                    if(pos[1] == 0){
                        pos[1] = 8;
                        pos[0]--;
                    }
                    //換上一格
                    else{
                        pos[1]--;
                    }
                }

                if(pos[0] == 9){
                    break;
                }
            }while (!canChange[pos[0]][pos[1]]);
        }

    }
}