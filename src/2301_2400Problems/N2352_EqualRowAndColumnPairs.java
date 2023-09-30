import java.util.HashMap;
import java.util.HashSet;

public class N2352_EqualRowAndColumnPairs {

    static class Solution {
        public int equalPairs(int[][] grid) {

            int maxR = 0;
//            int maxC = 0;
            HashMap<String, Integer> rMap = new HashMap<>();
//            HashSet<Integer> rSet = new HashSet<>();

            for(int i = 0; i < grid.length; i++){
                StringBuilder hashCode = new StringBuilder();
                for(int j = 0; j < grid[i].length; j++){
                    hashCode.append(grid[i][j]).append(",");
                }
                rMap.put(hashCode.toString(), rMap.getOrDefault(hashCode.toString(), 0) + 1);
            }
            for(int j = 0; j < grid[0].length; j++){
                StringBuilder hashCode = new StringBuilder();
                for(int i = 0; i < grid.length; i++){
                    hashCode.append(grid[i][j]).append(",");
                }
                if(rMap.containsKey(hashCode.toString()) ){
                    maxR += rMap.get(hashCode.toString());
//                    if(!rSet.contains(hashCode)){
//                        rSet.add(hashCode);
//                        maxR+=rMap.get(hashCode);
//                    }
//                    maxC++;
                }
            }
            return maxR;

        }
    }
}
