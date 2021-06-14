public class N153_FindMinimumInRotatedSortedArray {
    //找出陣列中最小的值
    //該陣列有排序過,但做了n次的rotated(旋轉) 故只要找出最小的值的索引值即可 每個元素皆獨立
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    //Memory Usage: 38.6 MB, less than 35.32% of Java online submissions for Find Minimum in Rotated Sorted Array.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,2,2,0,1};
        System.out.println(solution.findMin(nums));
    }

    static class Solution {
        public int findMin(int[] nums) {
            //沒旋轉或者位數只有1個
            if(nums[0] <= nums[nums.length - 1]) return nums[0];
            if(nums[nums.length - 1] < nums[nums.length - 2]) return nums[nums.length - 1];

            //三個位數以上
            int low = 0;
            int high = nums.length - 1;
            int now = nums.length / 2;
            do{
                System.out.println("Low " + low + " Now " + now + " High " + high);
                //中了
                if(nums[now] < nums[now - 1]){
                    return nums[now];
                }
                //還需向右找
                else if(nums[now] > nums[low]){
                    low = now;
                    now = (high + low) / 2;
                }
                //向左找
                else if(nums[now] < nums[high]){
                    high = now;
                    now = (high + low) / 2;
                }
            }while(true);
        }
    }
}
