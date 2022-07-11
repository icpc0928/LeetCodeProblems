import java.util.HashMap;

/**
 * Runtime: 18 ms, faster than 17.21% of Java online submissions for Jump Game III.
 * Memory Usage: 72.5 MB, less than 5.05% of Java online submissions for Jump Game III.
 */

public class N1306_JumpGameIII {

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2,};
        int start = 5;

        Solution s = new Solution();
        System.out.println(s.canReach(arr, start));
    }

    static class Solution {
        public boolean canReach(int[] arr, int start) {
            HashMap<Integer,Integer> canReachIndexMap = new HashMap<>();
            canReachIndexMap.put(start, arr[start]);
            DFS(start + arr[start], arr, canReachIndexMap);
            DFS(start - arr[start], arr, canReachIndexMap);

            return canReachIndexMap.containsValue(0);
        }

        public void DFS(int i, int[] arr, HashMap<Integer, Integer> canReachIndexMap){
            if(i < 0 || i >= arr.length) return;

            if(canReachIndexMap.containsKey(i)) return;

            canReachIndexMap.put(i, arr[i]);
            if(arr[i] == 0) return;
            DFS(i + arr[i], arr,  canReachIndexMap);
            DFS(i - arr[i], arr,  canReachIndexMap);
        }
    }
}
