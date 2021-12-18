public class N231_PowerOfTwo {

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(16));
    }

    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n < 1){
                return false;
            }else if(n == 1){
                return true;
            }else{
                do{
                    if(n % 2 == 0){
                        n = n / 2;
                    }else{
                        return false;
                    }
                }while (n > 1);

            }
            return true;
        }
    }
}
