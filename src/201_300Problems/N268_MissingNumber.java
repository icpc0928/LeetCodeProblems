public class N268_MissingNumber {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
    //Memory Usage: 39.1 MB, less than 89.59% of Java online submissions for Missing Number.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,1,2,3,4,5,6,7,8};
        System.out.println(solution.missingNumber(nums));

        //xor先做 0~n的xor  (也就是將所有值補上)
        //然後跟所有元素值做 xor (剩下的就是缺少的值)

    }

    //題目規則說 n = nums.length  0 <= nums[i] <= n  且每個數字都是獨一無二的,則表示這個陣列內由 0~n 扣除一個值 所組成
    //使用XOR 解 每個數值全部XOR

    static class Solution {
        public int missingNumber(int[] nums) {
            int ans = nums.length;
            for(int i = 0; i < nums.length; i++){
                ans ^= nums[i];
                ans ^= i;
//                ans ^= i ^ nums[i];   //上兩行等同於這行
            }

            return ans;
        }
    }
}
