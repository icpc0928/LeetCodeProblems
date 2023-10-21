import java.util.HashMap;
import java.util.Map;

public class N2347_BastPokerHand {

    class Solution {
        /**
         *
         * @param ranks 1~13 點數
         * @param suits a ~ d 花色
         * @return
         * "Flush": Five cards of the same suit.  同花
         * "Three of a Kind": Three cards of the same rank. 三條
         * "Pair": Two cards of the same rank. 對子
         * "High Card": Any single card. 高張
         */
        public String bestHand(int[] ranks, char[] suits) {
            if(checkFlush(suits)){
                return "Flush";
            }
            int checkCount = checkThree(ranks);
            if(checkCount >= 3){
                return "Three of a Kind";
            }
            if(checkCount == 2){
                return "Pair";
            }
            return "High Card";

        }
        private boolean checkFlush(char[] suits) {
            char check = suits[0];
            for(int i = 1; i < suits.length; i++){
                if(check != suits[i]) return false;
            }
            return true;
        }

        private int checkThree(int[] ranks) {
            int maxCount = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int rank : ranks) {
                countMap.put(rank, countMap.getOrDefault(rank, 0) + 1);
            }
            for(Integer key : countMap.keySet()){
                maxCount = Math.max(maxCount, countMap.get(key));
            }
            return maxCount;
        }



    }
}
