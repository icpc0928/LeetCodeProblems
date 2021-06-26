public class N123_BestTimeToBuyAndSellStockIII {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(solution.maxProfit(prices));
    }


    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length <= 1) return 0;

            int maxPF = 0, maxPF1 = 0, maxPF2 = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){              //如果後者 > 前者 maxPF 累加上去
                    maxPF += (prices[i] - prices[i - 1]);
                }else{                                      //如果過了最高峰,則 取最大的兩個maxPF 並將maxPF歸零
                    if(maxPF >= maxPF1){
                        maxPF2 = maxPF1;
                        maxPF1 = maxPF;
                    }else{
                        maxPF2 = Math.max(maxPF, maxPF2);
                    }
                    maxPF = 0;
                }
            }

            System.out.println(maxPF);
            System.out.println(maxPF1);
            System.out.println(maxPF2);

            return maxPF1 + Math.max(maxPF, maxPF2);
        }
    }
}
