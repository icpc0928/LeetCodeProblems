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
//                {".",".","9","7","4","8",".",".","."},
//                {"7",".",".",".",".",".",".",".","."},
//                {".","2",".","1",".","9",".",".","."},
//                {".",".","7",".",".",".","2","4","."},
//                {".","6","4",".","1",".","5","9","."},
//                {".","9","8",".",".",".","3",".","."},
//                {".",".",".","8",".","3",".","2","."},
//                {".",".",".",".",".",".",".",".","6"},
//                {".",".",".","2","7","5","9",".","."},
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
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    canChange[i][j] = board[i][j] == '.';
                }
            }
            //開始:
            int[] pos = new int[2];
//            forwardBank(pos, true, canChange);
            do{
                sudokuSolver(board, pos, canChange, true);
            }while (!flag);

        }

        public boolean flag = false;

        public void sudokuSolver(char[][] board, int[] pos, boolean[][] canChange, boolean fb){
            //算完惹
            if(pos[0] == 9){
                flag = true;
                return;
            }

            System.out.println("i: " + pos[0] + ", j: " + pos[1] + "  ");

            //如該格還沒被做過
            if(board[pos[0]][pos[1]] == '.'){
//                System.out.println("DO 1");
                for(int po = 1; po <= 9; po++){
                    //如果該值吻合
                    if(isGood(board, pos[0], pos[1], (po+"").charAt(0))){
                        board[pos[0]][pos[1]] = (po + "").charAt(0);
                        //下一格
                        forwardBack(pos , true, canChange);
                        return;
                    }
                }
                //1-9都不能裝,則開始退位
                forwardBack(pos, false, canChange);
                System.out.println("Hello");

            }
            //如果這格可以做,且曾經被做過 則迴圈使用 目前數字+1 到 9 去跑
            else if(canChange[pos[0]][pos[1]]){
//                System.out.println("DO 2");
                for(int po = Integer.parseInt(String.valueOf(board[pos[0]][pos[1]])) + 1; po <= 9; po++){
                    //如果該值吻合
                    if(isGood(board, pos[0], pos[1], (po+"").charAt(0))){
                        board[pos[0]][pos[1]] = (po + "").charAt(0);
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
            System.out.println("POS: " + pos[0] + ", " + pos[1] + " fw: " + fw);
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
