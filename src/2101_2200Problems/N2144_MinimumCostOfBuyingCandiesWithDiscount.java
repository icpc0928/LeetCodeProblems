import java.util.Arrays;

/**
 * Runtime: 2 ms, faster than 98.65% of Java online submissions for Minimum Cost of Buying Candies With Discount.
 * Memory Usage: 42 MB, less than 88.66% of Java online submissions for Minimum Cost of Buying Candies With Discount.
 */
public class N2144_MinimumCostOfBuyingCandiesWithDiscount {

    static class Solution {
        public int minimumCost(int[] cost) {
            int withoutGroup = cost.length % 3;
            Arrays.sort(cost);
            int totalCost = 0;

            for(int i = 0; i < withoutGroup; i++){
                totalCost += cost[i];
            }

            for(int i = withoutGroup; i < cost.length; i++){
                if(i % 3 != withoutGroup){
                    totalCost += cost[i];
                }
            }
            return totalCost;
        }
    }

}
