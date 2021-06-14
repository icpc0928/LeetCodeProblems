import java.util.Arrays;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
//Memory Usage: 42.1 MB, less than 72.81% of Java online submissions for Find First and Last Position of Element in Sorted Array.

public class N34_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Solution solution = new Solution();
        int[] ans = new int[2];
        ans = solution.searchRange(nums, target);
        System.out.println(ans[0] + " , " + ans[1]);
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1};
            if(nums.length == 0) return ans;
            if(target < nums[0] || target > nums[nums.length - 1]) return ans;
            int temp = Arrays.binarySearch(nums, target);
            if(temp < 0) return ans;
            int fIndex = temp;
            int lIndex = temp;
            boolean fStop = false, lStop = false;
            System.out.println(temp);
            do{
                if(!fStop){
                    if(fIndex - 1 >= 0 && nums[fIndex - 1] == target){
                        fIndex --;
                    }else fStop = true;
                }

                if(!lStop){
                    if(lIndex + 1 <= nums.length - 1 && nums[lIndex + 1] == target){
                        lIndex ++;
                    }else lStop = true;
                }
                System.out.println(fStop + " " + lStop);
                System.out.println(fIndex + " : " + lIndex);
            }while (!fStop || !lStop);

            System.out.println(fIndex + " ::: " + lIndex);
            ans[0] = fIndex;
            ans[1] = lIndex;
            return ans;
        }
    }
}
