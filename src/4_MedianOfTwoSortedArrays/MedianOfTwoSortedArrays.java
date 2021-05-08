import sun.security.util.ArrayUtil;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] num1 = {};
        int[] num2 = {0,1};
        double i = solution.findMedianSortedArrays(num1, num2);
        System.out.println(i);
    }

    static class Solution{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            if(nums1.length + nums2.length == 0){
                return 0;
            }

            int[] arr = new int[(nums1.length + nums2.length ) / 2 + 1];
            boolean isEven = (nums1.length + nums2.length) % 2 == 0;
            int count1 = 0;
            int count2 = 0;


            for(int i = 0; i < arr.length; i++){
                if(count1 == nums1.length){
                    arr[i] = nums2[count2];
                    count2++;
                    continue;
                }
                if(count2 == nums2.length){
                    arr[i] = nums1[count1];
                    count1++;
                    continue;
                }
                if(nums1[count1] <= nums2[count2]){
                    arr[i] = nums1[count1];
                    count1++;
                    System.out.println("Count1: " + count1);
                }else {
                    arr[i] = nums2[count2];
                    count2++;
                    System.out.println("Count2: " + count2);
                }
            }

            //取得陣列,若陣列長度是奇數 則取中間數 也就是新陣列最後一位
            //若陣列長度是偶數 則取中間兩個數  也就是新陣列最後兩位
            if(isEven){
                return ((double)arr[arr.length - 1] + arr[arr.length - 2]) / 2;
            }else{
                return arr[arr.length - 1];
            }
        }
    }
}
