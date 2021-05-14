import java.util.ArrayList;
import java.util.List;

public class N54_SpiralMatrix {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    //Memory Usage: 37.4 MB, less than 19.11% of Java online submissions for Spiral Matrix.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = {
                {1,2,3,},
                {4,5,6,},
                {7,8,9,},
        };
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(list);
    }


    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            for(int t = 0; t < matrix.length * matrix[0].length ; t++){
                list.add(matrix[i][j]);
                matrix[i][j] = -101;
                nextForward(matrix);

            }
            return list;
        }

        //前進方向   右, 下, 左, 上,
        public int[] fi = {0, 1,  0, -1,};
        public int[] fj = {1, 0, -1,  0,};
        public int i = 0, j = 0;
        public int count = 0;

        //選擇下一步
        public void nextForward(int[][] matrix){
            int tempI = i + fi[count % 4];
            int tempJ = j + fj[count % 4];

            if(tempI >= matrix.length || tempJ >= matrix[i].length || tempI < 0 || tempJ < 0 || matrix[tempI][tempJ] == -101){
                count++;
            }
            i += fi[count % 4];
            j += fj[count % 4];
        }


    }
}
