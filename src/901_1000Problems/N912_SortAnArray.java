import java.util.Arrays;

public class N912_SortAnArray {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums={10,9,8,9,7,5,3,0,4,1,2};
        nums = s.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int[] sortArray(int[] nums) {
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        /**
         * 一般順序排序 會超時的 最久的方法
         * @param nums
         * @return
         */
        private int[] normalSort(int[] nums){
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i +1; j < nums.length; j++){
                    if(nums[i] > nums[j]){
                        nums[i] = nums[i] + nums[j];
                        nums[j] = nums[i] - nums[j];
                        nums[i] = nums[i] - nums[j];
                    }
                }
            }
            return nums;
        }


        /**
         * 合併排序
         * @param nums
         * @param startI
         * @param endI
         * 參考
         * https://medium.com/appworks-school/%E5%88%9D%E5%AD%B8%E8%80%85%E5%AD%B8%E6%BC%94%E7%AE%97%E6%B3%95-%E6%8E%92%E5%BA%8F%E6%B3%95%E9%80%B2%E9%9A%8E-%E5%90%88%E4%BD%B5%E6%8E%92%E5%BA%8F%E6%B3%95-6252651c6f7e
         */
        private void mergeSort(int[] nums, int startI, int endI){
            if(startI >= endI){
                return;
            }

            int midIndex = startI + ((endI - startI) / 2);
            mergeSort(nums, startI, midIndex);          //分成前半段
            mergeSort(nums, midIndex + 1, endI);    //跟後半段, 一直切, 切到剩下一個元素, 然後再合併
            merge(nums, startI, midIndex, endI);        //合併時做排序 這個才是重點 , 因為被分組了, 所以合併時 兩段的陣列只要一直判斷第一個元素就可以排序了
        }

        /**
         * 合併兩個陣列
         * @param nums
         * @param startI 第一段的起點
         * @param midI   第一段的終點 (midI +1 為第二段的起點)
         * @param endI   第二段的終點
         */
        private void merge(int nums[], int startI, int midI, int endI){
            int i = startI;     //第一段起點 檢查用的index
            int j = midI + 1;   //第二段起點 檢查用的index
            int[] temp = new int[endI - startI + 1];    //這次合併的長度
            int k = 0;      //temp的索引

            //倆段一起判斷 直到某段結束 , 剩下比較長的那段,後續就可以一次做完 //例如 i: [0,1,2,3], j[7,8,9,] 這樣i這段必定會跑完
            while(i <= midI && j <= endI){
                if(nums[i] < nums[j]){
                    temp[k++] = nums[i++];
                }else{
                    temp[k++] = nums[j++];
                }
            }

            //以下兩個while 只會成立一次

            //如果剩下i這段
            while(i <= midI){
                temp[k++] = nums[i++];
            }
            //或者剩下j這段
            while(j <= endI){
                temp[k++] = nums[j++];
            }

            //將 temp 弄回去 nums
            for(int t = 0; t < temp.length; t++){
                nums[startI + t] = temp[t];
            }
        }
    }
}
