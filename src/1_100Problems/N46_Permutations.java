import java.util.ArrayList;
import java.util.List;
//Runtime: 24 ms, faster than 5.92% of Java online submissions for Permutations.
//Memory Usage: 45.8 MB, less than 5.11% of Java online submissions for Permutations.

public class N46_Permutations {

    //Constraints:
    //1 <= nums.length <= 6
    //-10 <= nums[i] <= 10
    //All the integers of nums are unique.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,};
        System.out.println(solution.permute(nums));
    }
//DFS + 回朔
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            DFS(nums, 0, new ArrayList<>(), result, visited);
            return result;
        }

        public void DFS(int[] nums, int index, List<Integer> list, List<List<Integer>> result, boolean[] visited){
            if(index == nums.length){
                System.out.println(list);
                result.add(new ArrayList<>(list));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(visited[i]){
                    continue;
                }
                list.add(nums[i]);
                visited[i] = true;
                DFS(nums, index + 1, list, result, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
