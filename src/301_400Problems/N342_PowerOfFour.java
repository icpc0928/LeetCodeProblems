public class N342_PowerOfFour {

    class Solution {
        public boolean isPowerOfFour(int n) {
            if(n <= 0) return false;

            return check(n);
        }



        /**
         * 遞迴
         * @param n
         * @return
         */
        private boolean check(int n) {
            if(n == 1) return true;
            if(n % 4 != 0){
                return false;
            }
            return check(n / 4);
        }


    }
}
