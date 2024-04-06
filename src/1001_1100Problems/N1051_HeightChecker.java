import java.util.Arrays;

public class N1051_HeightChecker {
    static class Solution {
        public int heightChecker(int[] heights) {
            int[] tempHeights = Arrays.copyOf(heights, heights.length);
            Arrays.sort(tempHeights);
            int result = 0;
            for(int i = 0; i < tempHeights.length; i++){
                if(tempHeights[i] != heights[i]){
                    result++;
                }
            }
            return result;
        }
    }

}
