import java.util.HashSet;

public class N888_FairCandySwap {


    static class Solution {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

            int balance = 0;
            int aTotal = 0;
            int bTotal = 0;
            HashSet<Integer> aSet = new HashSet<>();

            for (int aliceSize : aliceSizes) {
                aSet.add(aliceSize);
                balance += aliceSize;
                aTotal += aliceSize;
            }
            for(int bobSize : bobSizes){
                balance += bobSize;
                bTotal += bobSize;
            }
            balance = balance/2;
            for(int i = 0; i < bobSizes.length; i++){
                int bobNeed =balance -( bTotal - bobSizes[i]);
                if(bobNeed > 0){
                    if(aSet.contains(bobNeed)){
                        return new int[] {bobNeed, bobSizes[i]};
                    }
                }
            }

            return new int[2];
        }
    }
}
