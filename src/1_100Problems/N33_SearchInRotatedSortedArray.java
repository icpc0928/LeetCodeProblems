import java.util.Arrays;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
//Memory Usage: 38.2 MB, less than 65.38% of Java online submissions for Search in Rotated Sorted Array.

public class N33_SearchInRotatedSortedArray {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        System.out.println(solution.search(nums, target));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            //比[0]小 比[n-1]大 =>沒有這個數
            if(target < nums[0] && target > nums[nums.length - 1])
                return -1;
            //is sorted -> binarySearch
            if(nums[0] < nums[nums.length - 1]){
                int ans = Arrays.binarySearch(nums, target);
                return ans < 0 ? -1 : ans;
            }
            //有旋轉過 [0] > [n-1]
            else{
                if(target == nums[0]) return 0;
                if(target == nums[nums.length - 1]) return nums.length - 1;
                int lowIndex, highIndex, nowIndex;
                lowIndex = 0;
                highIndex = nums.length - 1;
                nowIndex = nums.length / 2;
                //目標在左側 [low]~[max]
                if(target > nums[0]){
                    do{
                        //中了
                        if(nums[nowIndex] == target){
                            return nowIndex;
                        }
                        //low target now
                        else if(nums[nowIndex] > target || nums[nowIndex] < nums[nums.length - 1]){
                            highIndex = nowIndex;
                            nowIndex = (highIndex + lowIndex) / 2;
                        }else if(nums[nowIndex] < target){
                            lowIndex = nowIndex;
                            nowIndex = (highIndex + lowIndex) / 2;
                        }
                    }while (highIndex - lowIndex > 1);
                }
                //目標在右側 [max]~[high]
                else{
                    do{
                        //中了
                        if(nums[nowIndex] == target){
                            return nowIndex;
                        }
                        //now target high
                        else if(nums[nowIndex] < target || nums[nowIndex] > nums[0]){
                            lowIndex = nowIndex;
                            nowIndex = (highIndex + lowIndex) / 2;
                        }else if(nums[nowIndex] > target){      //low target high
                            highIndex = nowIndex;
                            nowIndex = (highIndex + lowIndex) / 2;
                        }
                    }while (highIndex - lowIndex > 1);
                }
            }

            return -1;
        }
    }
}
