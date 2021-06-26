public class N122_BestTimeToBuyAndSellStockII {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
    //Memory Usage: 39 MB, less than 27.74% of Java online submissions for Best Time to Buy and Sell Stock II.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length <= 1) return 0;

            int maxPF = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    maxPF += (prices[i] - prices[i - 1]);
                }
            }
            return maxPF;
        }
    }
}
