
import java.util.*;

public class N2643_RowWithMaximumOnes {

    class Solution {
        public int[] rowAndMaximumOnes(int[][] mat) {

            TreeMap<Integer, SortedSet<Integer>> resultMap = new TreeMap<>();
            for(int i = 0; i < mat.length; i++){
                int sum = 0;
                for(int j = 0; j < mat[i].length; j++){
                    sum += mat[i][j];
                }
                SortedSet<Integer> resultSet = resultMap.getOrDefault(sum, new TreeSet<>());
                resultSet.add(i);
                resultMap.put(sum, resultSet);
            }
            return new int[]{resultMap.get(resultMap.lastKey()).first(), resultMap.lastKey()};
        }
    }
}
