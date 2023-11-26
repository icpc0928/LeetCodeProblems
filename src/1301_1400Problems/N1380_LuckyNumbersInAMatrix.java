import java.util.*;

public class N1380_LuckyNumbersInAMatrix {


    static class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int[] maxCol = new int[matrix[0].length];
            getMaxCol(matrix, maxCol);

            for(int i = 0; i < matrix.length; i++){
                int min = Integer.MAX_VALUE;
                List<Integer> minIndexList = new ArrayList<>();
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] < min){
                        min = matrix[i][j];
                        minIndexList = new ArrayList<>();
                        minIndexList.add(j);
                    }else if(matrix[i][j] == min){
                        minIndexList.add(j);
                    }
                }
                for(int index : minIndexList){
                    if(min == maxCol[index]){
                        result.add(min);
                    }
                }
            }
            return result;
        }

        private void getMaxCol(int[][] matrix, int[] maxCol) {

            for(int j = 0; j < matrix[0].length; j++){
                int max = 0;
                for (int[] ints : matrix) {
                    max = Math.max(max, ints[j]);
                }
                maxCol[j] = max;
            }
        }


    }
}
