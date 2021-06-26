import java.util.HashMap;

//Runtime: 1 ms, faster than 48.83% of Java online submissions for Two Sum II - Input array is sorted.
//Memory Usage: 39.3 MB, less than 45.15% of Java online submissions for Two Sum II - Input array is sorted.

public class N167_TwoSumII_InputArrayIsSorted {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] numbers = {-1,0};
        int target = -1;
        int[] ans = solution.twoSum(numbers, target);
        System.out.println(ans[0] + " , " + ans[1]);
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] ans = new int[2];
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int i = 0; i < numbers.length; i++){
                if(hashMap.containsKey(target - numbers[i])){
                    ans[0] = hashMap.get(target - numbers[i]) + 1;
                    ans[1] = i + 1;
                    return ans;
                }else{
                    hashMap.put(numbers[i], i);
                }
            }
            return ans;
        }
    }
}
