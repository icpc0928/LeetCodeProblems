public class N258_AddDigits {


    public static void main(String[] args) {
        int num = 0;
        Solution s = new Solution();
        System.out.println(s.addDigits(num));
    }

    public static class Solution {
        public int addDigits(int num) {
            int result = 0;

            while(num > 0){
                int lastNum = num % 10;
                if(result + lastNum >= 10){
                    result = result + lastNum - 10 + 1;
                }else{
                    result = result + lastNum;
                }
                num = num / 10;
            }
            return result;
        }
    }
}
