public class N238_ProductOfArrayExceptSelf {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
    //Memory Usage: 49.8 MB, less than 60.34% of Java online submissions for Product of Array Except Self.

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
    //Memory Usage: 49.3 MB, less than 89.69% of Java online submissions for Product of Array Except Self.

    public static void main(String[] args){
        int[] nums = {-1,1,0,-3,3};
        Solution sol = new Solution();

        int[] ans = sol.productExceptSelf(nums);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " , ");
        }
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            //全部元素相乘
            //暫存一個值是 不乘上0的
            //元素若只有1個0 OK
            //元素若有2個0以上 則返回全部都是0的陣列
            int zeroCounter = 0;
            int totalPro = 1;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0) {
                    zeroCounter++;

                }else{
                    totalPro *= nums[i];

                }
                //if(zeroCounter > 1) return new int[nums.length]; //寫這裡的話 leetCode跑分比較慢@@
            }

            if(zeroCounter > 1) return new int[nums.length];

            int[] ans = new int[nums.length];
            //到這裡zeroCounter => 0 or 1
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    ans[i] = totalPro;
                }else if(zeroCounter == 0){
                    ans[i] = totalPro / nums[i];
                }else{
                    nums[i] = 0;
                }
            }
            return ans;
        }
    }
}
