import java.util.Arrays;

public class N74_SearchA2DMatrix {

    public static void main(String[] args){
        Solution solution = new Solution();
        int target = 3;
        int[][] matrix = {
                { 1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,60},
        };
        boolean ans = solution.searchMatrix(matrix, target);
        System.out.println(ans);
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //找在哪一個一維陣列內
            //再用Arrays.binarySearch(array, value)搜尋
            if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
                return false;

            int i = 0;
            while (i < matrix.length-1) {
                if(target < matrix[i+1][0]){
                    break;
                }
                i++;
            }


            return Arrays.binarySearch(matrix[i], target) >= 0;
        }
    }
}
