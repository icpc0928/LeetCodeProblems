public class N42_TrappingRainWater {
    //Runtime: 203 ms, faster than 5.01% of Java online submissions for Trapping Rain Water.
    //Memory Usage: 38.4 MB, less than 68.14% of Java online submissions for Trapping Rain Water.

    public static void main(String[] args){
        int[] height = {4,2,0,3,2,5};
        Solution solution = new Solution();
        int ans = solution.trap(height);
        System.out.println(ans);
    }

    static class Solution {
        public int trap(int[] height) {
            int counter = 0;

            //i值必須大於i+1值 而其差值為迴圈次數
            for(int i = 0; i < height.length - 2; i++){
                if(height[i] <= height[i + 1]){
                    continue;
                }
                //t為計算的水位  j值從i+2起算 必須要>= t的水位
                for(int t = 0; t < height[i] - height[i + 1]; t++){
                    for(int j = i + 2; j < height.length; j++){
                        //從水位高的開始加總 及height[i] - t
                        if(height[j] >= (height[i] - t)){
                            System.out.println("i: " + i + ", t: " + t + " => "+(j - i - 1));
                            counter += (j - i - 1);
                            break;
                        }
                    }
                }
            }
            return counter;
        }
    }
}
