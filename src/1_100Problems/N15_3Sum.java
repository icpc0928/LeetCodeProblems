import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N15_3Sum {

    public static void main(String[] args){

    }


    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answers = new ArrayList<>();

            if(nums.length < 3){
                return answers;
            }
            Arrays.sort(nums);

            for(int i = 0; i < nums.length - 2; i++){
                //首項重複不解
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum > 0){
                        r--;
                    }else if(sum < 0){
                        l++;
                    }else{
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[l]);
                        answer.add(nums[r]);
                        answers.add(answer);
                        l++;
                        //左標++重複的話 不解
                        while(nums[l] == nums[l-1] && l < r)
                            l++;
                    }
                }

            }
            return answers;
        }
    }
}
