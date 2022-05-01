import java.util.*;

/**
 * Runtime: 18 ms, faster than 10.63% of Java online submissions for Sort Array by Increasing Frequency.
 * Memory Usage: 42.8 MB, less than 75.93% of Java online submissions for Sort Array by Increasing Frequency.
 */

public class N1636_SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,4,4,};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.frequencySort(nums)));
    }

    static class Solution {
        public int[] frequencySort(int[] nums) {
            HashMap<Integer, Integer> elementCount = new HashMap<>();
            ArrayList<Integer> counterKeys = new ArrayList<>();

            for(int i = 0; i < nums.length; i++){
                elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
            }
            HashMap<Integer, int[]> countList = new HashMap<>();

            for(int value : elementCount.values()){
                ArrayList<Integer> lists = new ArrayList<>();
                if(!counterKeys.contains(value)){
                    counterKeys.add(value);
                }


                for(int key : elementCount.keySet()){
                    if(elementCount.get(key) == value){
                        lists.add(key);
                    }
                }

                int[] arrays = lists.stream().mapToInt(i -> i).toArray();
//
                Arrays.sort(arrays);
                countList.put(value, arrays);
            }

            int[] counterKeysArray = counterKeys.stream().mapToInt(i -> i).toArray();
            Arrays.sort(counterKeysArray);

            List<Integer> result = new ArrayList<>();
            //幾個
            for(int i = 0; i < counterKeysArray.length; i++){
                int[] arrays = countList.get(counterKeysArray[i]);
                //值
                for(int j = arrays.length - 1; j >= 0; j--){
                    for(int k = 0; k < counterKeysArray[i]; k++){
                        result.add(arrays[j]);
                    }
                }
            }
            int[] resultArray = result.stream().mapToInt(i -> i).toArray();


            return resultArray;
        }
    }
}
