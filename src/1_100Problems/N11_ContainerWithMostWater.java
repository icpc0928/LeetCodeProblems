public class N11_ContainerWithMostWater {
    public static void main(String[] args){
        int area;
        int[] height ={1,2,3,4,5,6,};
        Solution solution = new Solution();
        area = solution.maxArea(height);

        System.out.println(area);
    }


    static class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int i = 0;
            int j = height.length - 1;
            while( i < j){
                //兩點 i j 取最小值為水位高度
                //取 i j 之間的距離 將兩者相乘得出容積
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                if( height[i] > height[j] )
                    j--;
                else
                    i++;
            }

            return maxArea;
        }
    }
}



