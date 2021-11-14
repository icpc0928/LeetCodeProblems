import java.util.ArrayList;
import java.util.Arrays;

public class N56_MergeIntervals {
    //Runtime: 5 ms, faster than 95.73% of Java online submissions for Merge Intervals.
    //Memory Usage: 41.7 MB, less than 64.18% of Java online submissions for Merge Intervals.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] intervals = {
                {1,4},
                {0,0},
//                {8,10},
//                {15,18},
        };
        int[][] ans = solution.merge(intervals);
        printArrays(ans);
    }



    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 1) return intervals;
            //sort
            Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

            ArrayList<int[]> arrayList = new ArrayList<>();
            int min = intervals[0][0];
            int max = intervals[0][1];

            for(int i = 1; i < intervals.length; i++){
                if(max >= intervals[i][0]){
                    max = Math.max(max, intervals[i][1]);

                }else{
                    int[] ans = {min, max};
                    arrayList.add(ans);
                    min = intervals[i][0];
                    max = intervals[i][1];
                }

            }
            int[] ans = {min, max};
            arrayList.add(ans);

            return arrayList.toArray(new int[arrayList.size()][]);
        }
    }

    static public void printArrays(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
