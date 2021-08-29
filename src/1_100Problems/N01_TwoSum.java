import java.util.HashMap;
import java.util.Map;

public class N01_TwoSum {

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] ans = solution.twoSum(nums, target);
        System.out.println(ans[0]+ " : " + ans[1]);
    }

    static class Solution{
        public int[] twoSum(int[] nums, int target) {
            int[] solution = new int[2];
            HashMap<Integer, Integer> hashMap = new HashMap<>();

/**
 * containsKey 一層迴圈,原本怕key會重複 其實不會
 */
            for(int i = 0; i < nums.length; i++){
                if(hashMap.containsKey(target - nums[i])){
                    solution[0] = hashMap.get(target - nums[i]);
                    solution[1] = i;
                    break;
                }
                hashMap.put(nums[i], i);
            }
            return solution;


            /**
             * containsValue: 一樣兩層迴圈,要繞出key
             */
//            for(int i = 0; i < nums.length; i++){
//                if(hashMap.containsValue(target - nums[i])){
//                    for(Integer key : hashMap.keySet()){
//                        if(hashMap.get(key) == (target - nums[i])){
//                            solution[0] = key;
//                            solution[1] = i;
//                            break;
//
//                        }
//                    }
//                }
//                hashMap.put(i, nums[i]);
//            }
            /**
             * containsValue: 兩層迴圈分開做速度慢
             */
//            for(int i = 0; i < nums.length; i++){
//                hashMap.put(i, nums[i]);
//            }
//            for(int i = 0; i < nums.length; i++){
//                solution = new int[2];
//
//                if(hashMap.containsValue(target - hashMap.get(i))){
//                    solution[0] = i;
//                    System.out.println("HI");
//                    for(Integer key : hashMap.keySet()){
//                        if(hashMap.get(key) == (target - hashMap.get(i)) && key != i){
//                            solution[1] = key;
//                            return solution;
//                        }
//                    }
//                }
//            }
        }
    }
}
