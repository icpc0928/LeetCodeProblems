public class N292_NimGame {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Nim Game.
    //Memory Usage: 41.3 MB, less than 21.07% of Java online submissions for Nim Game.

//    public static void main(String[] args){
//
//    }

    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }
}
