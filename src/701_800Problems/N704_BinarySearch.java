public class N704_BinarySearch {

    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, target, 0, nums.length-1);
        }

        private int binarySearch(int[] nums, int target, int startIndex, int endIndex){

            int low = startIndex;
            int high = endIndex;
            while(high >= low){
                int mid = (low + high) >>> 1;   //避免low + high 溢位 所以使用>>> 1 (意思跟 /2一樣)
                int midVal = nums[mid];
                if(midVal < target){    //查到的比目標小, 往上找
                    low = mid +1;
                }else if(midVal > target){
                    high = mid -1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }
}
