public class N338_CountingBits {

    class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n+1];

            for(int i = 0; i <= n; i++){
                result[i] = getBits(i);
            }
            return result;
        }

        private int getBits(int num){
            int result = 0;
            while(num > 0){
                num &= (num - 1);   //num = num & (num -1) 與前一位數做 按位與 (兩數字轉二進,每一位數比較, 1&1=1 其餘=0)
                result++;
            }
            return result;
        }
    }
}
