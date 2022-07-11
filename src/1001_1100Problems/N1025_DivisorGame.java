public class N1025_DivisorGame {
    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     *
     * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
     *
     * Choosing any x with 0 < x < n and n % x == 0.
     * Replacing the number n on the chalkboard with n - x.
     * Also, if a player cannot make a move, they lose the game.
     *
     * Return true if and only if Alice wins the game, assuming both players play optimally.
     */

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Divisor Game.
     * Memory Usage: 38.6 MB, less than 99.74% of Java online submissions for Divisor Game.
     */

    /**
     * 實際情況是: 假設 n-1 == false 則 n 必定為true (因我只要取1 對方n-1必輸)
     * 且奇數"不會有" 偶數的因數 (即他的因數必定也都是奇數), 故我選擇奇數時,只能選一個奇數做扣除(奇數減去某奇數的因數=>必定是偶數) 所以輪到對方時必定是偶數 那對方必贏
     */
    class Solution {
        public boolean divisorGame(int n) {
            return n % 2 == 0;
        }
    }

}
