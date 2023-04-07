public class N263_UglyNumber {

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        System.out.println(s.isUgly(n));
    }

    static class Solution {
        public boolean isUgly(int n) {
            if(n == 0) return false;
            n = div(n, 2);
            System.out.println(n);
            n = div(n, 3);
            System.out.println(n);
            n = div(n, 5);
            System.out.println(n);
            return n == 1;
        }

        private int div(int n, int num){
            while(true){
                if(n % num == 0){
                    n = n / num;
                }else{
                    System.out.println("num: " + num + " n: " + n);
                    return n;
                }
            }
        }
    }
}
