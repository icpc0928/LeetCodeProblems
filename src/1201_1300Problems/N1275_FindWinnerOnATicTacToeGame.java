import java.util.HashSet;

public class N1275_FindWinnerOnATicTacToeGame {
    //這應該要改XD 我這樣寫太智障了

    class Solution {
        int[][] winArr = {
                {0,1,2},
                {0,3,6},
                {0,4,8},
                {1,4,7},
                {2,4,6},
                {2,5,8},
                {3,4,5},
                {6,7,8},
        };

        public String tictactoe(int[][] moves) {
            HashSet<Integer> aSet = new HashSet<>();
            HashSet<Integer> bSet = new HashSet<>();

            for(int i = 0; i < moves.length; i++){
                if(i % 2 == 0){
                    aSet.add(getPosValue(moves[i]));
                }else{
                    bSet.add(getPosValue(moves[i]));
                }
            }
            if(isWin(aSet)){
                return "A";
            }else if(isWin(bSet)){
                return "B";
            }else{
                if(moves.length == 9)
                    return "Draw";
            }
            return "Pending";
        }

        private boolean isWin(HashSet<Integer> set) {
            for(int i = 0; i < winArr.length; i++){
                for(int j = 0; j < winArr[i].length; j++){
                    if(!set.contains(winArr[i][j])){
                        break;
                    }
                    if(j == 2) return true;
                }
            }
            return false;
        }

        private Integer getPosValue(int[] move) {
            return move[0] * 3 + move[1];
        }
    }
}
