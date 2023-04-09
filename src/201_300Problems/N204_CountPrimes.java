public class N204_CountPrimes {

    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.countPrimes(10);
        System.out.println(r);
    }

    static class Solution {
        public int countPrimes(int n) {
            boolean[] b = new boolean[n];
            int count = 0;
            for(int i = 2; i < n; i++){

                if(b[i]) continue;
//                System.out.println("i: " + i);
                count++;
                for(long j = (long) i * i; j < n; j+=i){
                    b[(int) j] = true;
                }
            }
            return count;
        }
    }
}
