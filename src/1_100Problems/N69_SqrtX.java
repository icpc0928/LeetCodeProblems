public class N69_SqrtX {

    public static void main(String[] args){
        Solution solution = new Solution();
        int x = 9;
        int ans = solution.mySqrt3(x);
        System.out.println(ans);
    }


    static class Solution {
        public int mySqrt(int x) {
            return (int)Math.sqrt(x);



        }

        public int mySqrt2(int x){
            if(x <= 0)
                return 0;
            int low = 1;
            int high = x;
            while(low <= high){
                int mid = (high - low) / 2 + low;
                if(x / mid == mid)
                    return mid;
                if(x / mid > mid)
                    low = mid + 1;
                if(x / mid < mid)
                    high = mid - 1;
            }
            return high;
        }

        public int mySqrt3(int x) {
            double flag = 0.000000001d; //精度
            if (x <= 0) {
                return 0;
            }
            double val = x;
            double last;
            do {

                last = val;
                val = (val + x / val) / 2;
                System.out.println(val);
            } while (val - last > flag || val - last < -flag); //絕對值大於這個精度,還得繼續做 直到相差小於這個精度
            return (int) val;
        }

    }
}
