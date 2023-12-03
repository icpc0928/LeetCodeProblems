import java.util.HashMap;
import java.util.Map;

public class N1128_NumberOfEquivalentDominoPairs {


    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {

            Map<Integer, Integer> countMap = new HashMap<>();
            int result = 0;

            for(int i = 0; i < dominoes.length; i++){
                int sum = 0;
                if(dominoes[i][0] >= dominoes[i][1]){
                    sum = dominoes[i][0] * 10 + dominoes[i][1];
                }else{
                    sum = dominoes[i][1] * 10 + dominoes[i][0];
                }
                if(countMap.containsKey(sum)){
                    result += countMap.get(sum) +1;
                    countMap.put(sum, countMap.get(sum) + 1);

                }else{
                    countMap.put(sum, 0);
                }
            }

            return result;
        }

        public int numEquivDominoPairs2(int[][] dominoes) {

            int[] counts = new int[100];
            int pairsCount = 0;
            for (int[] domino : dominoes) {
                int sum;
                if(domino[0] >= domino[1]){
                    sum = domino[0] * 10 + domino[1];
                }else{
                    sum = domino[1] * 10 + domino[0];
                }

                pairsCount += counts[sum]++;
            }

            return pairsCount;
        }
    }
}
