import java.util.Arrays;
import java.util.HashMap;

public class N16_3SumClosest {

    public static void main(String[] args){
        int[] nums = {-3, 0,1,2};
        int target = 1;
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(nums, target));
    }


    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans=nums[0] + nums[1] + nums[nums.length-1]; //最大加總

            //選定i +  low 到 high 內加總距離最接近target的值  => (i, low-> .... <-high)  。 加總值>target high減少, <target low增加 。最後取最小值
            for(int i = 0; i  < nums.length - 2; i++){
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high){
                    int sum = nums[i] + nums[low] + nums[high];
                    if(sum > target) high--;
                    else low++;
                    if(Math.abs(sum - target) < Math.abs(ans - target)){
                        ans = sum;
                    }

                }
            }
            return ans;
        }

    }
}
