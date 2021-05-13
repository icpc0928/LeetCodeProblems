public class SudokuSolver {

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
                {".",".",".", ".","8",".", ".","7","9"},
        };
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
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    canChange[i][j] = board[i][j] == '.';
                }
            }

            sudokuSolver(board, 0,0, canChange, true);
        }

        public boolean flag = false;

        public void sudokuSolver(char[][] board, int i, int j, boolean[][] canChange, boolean fb){
            //算完惹
            if(i == 9){
                flag = true;
                return;
            }
            int[] next = new int[2];


            //如該格還沒被做過
            if(board[i][j] == '.'){
                for(int po = 1; po <= 9; po++){
                    //如果該值吻合
                    if(isGood(board, i, j, (po+"").charAt(0))){
                        board[i][j] = (po + "").charAt(0);
                        //下一格
                        next = forwardBank(i, j, true);
                        sudokuSolver(board, next[0], next[1], canChange, fb);
                    }
                }
                //1-9都不能裝,則開始退位 TODO



            }
            //如果這格可以做,且曾經被做過 則迴圈使用 目前數字+1 到 9 去跑
            else if(canChange[i][j]){
                //TODO
//                sudokuSolver(board, ni, nj, canChange, fb);
                for(int po = Integer.parseInt(String.valueOf(board[i][j])) + 1; po <= 9; po++){
                    //如果該值吻合
                    if(isGood(board, i, j, (po+"").charAt(0))){
                        board[i][j] = (po + "").charAt(0);
                        //下一格
                        next = forwardBank(i, j, true);
                        sudokuSolver(board, next[0], next[1], canChange, fb);
                    }
                }
                //X-9都不能裝,則開始退位 TODO
            }
            //如果這格不能做則繼續往 上 / 下 跑
            else{
                //TODO 上 / 下 一格
                next = forwardBank(i, j, fb);
                sudokuSolver(board, next[0], next[1], canChange, fb);
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

        public int[] forwardBank(int ni, int nj, boolean fw){

            int[] array = new int[2];

            //前進
            if(fw){
                //換行
                if(nj == 8){
                    array[0] = ni + 1;
                    array[1] = 0;
                }
                //換下一格
                else{
                    array[0] = ni;
                    array[1] = nj + 1;
                }
            }
            //後退
            else{
                //換行
                if(nj == 0){
                    array[0] = ni - 1;
                    array[1] = 8;
                }
                //換上一格
                else{
                    array[0] = ni;
                    array[1] = nj - 1;
                }

            }

            return array;
        }





    }
}
