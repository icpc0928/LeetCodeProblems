import java.util.HashMap;

public class N128_LongestConsecutiveSequence {
//最長連續序列
//您必須編寫一個及時運行的算法 O(n) 。

    static class Solution {
        public int longestConsecutive(int[] nums) {
            int result = 0;
            HashMap<Integer, Integer> maxContinueMap = new HashMap<>();
            for(var num : nums){
                if(!maxContinueMap.containsKey(num)){
                    //取得左邊及右邊的數據 如果他們有數據的話
                    int left = maxContinueMap.containsKey(num -1) ? maxContinueMap.get(num -1):0;
                    int right = maxContinueMap.containsKey(num +1) ? maxContinueMap.get(num +1):0;
                    int sum = left + right + 1;
                    maxContinueMap.put(num, sum);//此數字的最大連續值

                    result = Math.max(result, sum);
                    //左邊或右邊有數據的話會記錄最大連續值, 可以獲得最左邊,最右邊的值 組成群組 , 這群都是最大連續值 sum
                    //不用怕跳很多號, 跳很多的話代表這間隔都已經被填滿過了
                    maxContinueMap.put(num - left, sum);
                    maxContinueMap.put(num + right, sum);

                }

            }
            return result;

        }
    }
}
