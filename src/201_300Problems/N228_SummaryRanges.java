import java.util.ArrayList;
import java.util.List;

//Runtime: 1 ms, faster than 89.91% of Java online submissions for Summary Ranges.
//Memory Usage: 42.4 MB, less than 46.42% of Java online submissions for Summary Ranges.

public class N228_SummaryRanges {

    public static void main(String[] args){
        int[] nums = {0,2,4,5,7};
        //[0,1,2,4,5,7]
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(nums));
    }

    static class Solution {
        List<String> result = new ArrayList<>();
        public List<String> summaryRanges(int[] nums) {

            boolean isStart = true;
            int actionNum = 0;
            boolean hasPoint = false;
            for(int i = 0; i < nums.length; i++){

                if(isStart){
                    result.add(String.valueOf(nums[i]));
                    actionNum = nums[i];
                    isStart = false;
                }else{
                    if(actionNum + 1 == nums[i]){
                        actionNum = nums[i];
                        if(!hasPoint){
                            appendInLastIndex("->");
                            hasPoint = true;
                        }
                    }
                    //非連續
                    else{
                        if(hasPoint){
                            appendInLastIndex(String.valueOf(actionNum));
                            hasPoint = false;
                        }
                        result.add(String.valueOf(nums[i]));
                        actionNum = nums[i];
                    }
                }
            }
            if(hasPoint){
                appendInLastIndex(String.valueOf(actionNum));
            }
            return result;
        }

        public void appendInLastIndex(String s){
            result.set(result.size() - 1, result.get(result.size() - 1) + s);
        }


    }
}
