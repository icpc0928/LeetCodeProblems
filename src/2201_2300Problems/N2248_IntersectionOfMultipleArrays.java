import java.util.*;

//Runtime: 12 ms, faster than 28.32% of Java online submissions for Intersection of Multiple Arrays.
//Memory Usage: 47.2 MB, less than 17.62% of Java online submissions for Intersection of Multiple Arrays.
public class N2248_IntersectionOfMultipleArrays {

    class Solution {
        public List<Integer> intersection(int[][] nums) {

            SortedSet<Integer> innerSet = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int[] num : nums) {
                for (int i : num) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            for(Integer key : map.keySet()){
                if(map.get(key) == nums.length){
                    innerSet.add(key);
                }
            }
            return new ArrayList<>(innerSet);

        }
    }
}
