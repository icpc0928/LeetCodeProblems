public class N605_CanPlaceFlowers {
//Runtime
//1 ms
//Beats
//99.32%
//Memory
//44.6 MB
//Beats
//19.41%
    public static void main(String[] args) {
        int[] f = {1,0,0,0,1,0,0};
        int n = 2;
        Solution s = new Solution();
        System.out.println(s.canPlaceFlowers(f,n));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(flowerbed.length / 2 + 1 < n ) return false;

            int maxLenNow = 0;  //目前最常可用長度  //00001 max=3, 000001 max=4

            for(int i = 0; i < flowerbed.length; i++){
                System.out.println("I: " + i + ", max: " + maxLenNow);

                if(flowerbed[i] == 0){
                    if(canPlace(flowerbed, i)){
                        maxLenNow++;
                    }else{
                        n -= (maxLenNow+1)/2;
                        if(n <= 0) return true;

                        maxLenNow = 0;
                    }
                }else{
                    maxLenNow = 0;
                }
            }
            if(maxLenNow > 0) {
                n -= (maxLenNow+1)/2;
            }
            return n <= 0;
        }

        private boolean canPlace(int[] flowerbed, int i) {
            if(i - 1 >= 0 && flowerbed[i - 1] == 1){
                return false;
            }
            if(i + 1 < flowerbed.length && flowerbed[i + 1] == 1)
                return false;
            return true;
        }
    }
}
