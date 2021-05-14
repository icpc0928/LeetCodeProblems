import java.util.HashMap;

public class N75_SortColors {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {0,1,1,1,2,2,1,0,0,0,0,2,1,2};

        solution.sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");

        }
        System.out.println();
    }

    static class Solution {
        public void sortColors(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0,0);
            hashMap.put(1,0);
            hashMap.put(2,0);
            for (int num : nums) {
                hashMap.put(num, hashMap.get(num) + 1);
            }
            int temp = 0;
            for(int i = 0; i < 3; i++){
                for(int s = 0; s < hashMap.get(i); s++){
                    nums[s + temp] = i;
                }
                temp += hashMap.get(i);
            }

        }
    }
}
