import java.util.Arrays;

/**
 * Runtime: 40 ms, faster than 46.41% of Java online submissions for Maximum Number of Coins You Can Get.
 * Memory Usage: 72.3 MB, less than 51.31% of Java online submissions for Maximum Number of Coins You Can Get.
 */

public class N1561_MaximumNumberOfCoinsYouCanGet {


    public static void main(String[] args) {

        int[] piles = {9,8,7,6,5,1,2,3,4,};

        Solution solution = new Solution();
        System.out.println(solution.maxCoins(piles));

    }

    static class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int chooseTimes = piles.length / 3;
            int coins = 0;
            for(int i = 0; i < chooseTimes; i++){
                coins += piles[piles.length - 2 - (i * 2)];
            }
            return coins;
        }
    }
}
