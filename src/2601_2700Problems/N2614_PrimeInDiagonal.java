import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class N2614_PrimeInDiagonal {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{
                {788,645,309,559},{624,160,435,724},{770,483,95,695},{510,779,984,238}
        };
        solution.diagonalPrime(nums);
    }



    static class Solution {
        public int diagonalPrime(int[][] nums) {
            SortedSet<Integer> resultSet = new TreeSet<>(Collections.reverseOrder());
            resultSet.add(0);
            for(int i = 0; i < nums.length; i++){
                if(isPrime(nums[i][i])){
                    resultSet.add(nums[i][i]);
                }
                if(isPrime(nums[nums.length - 1 -i][i])){{
                    resultSet.add(nums[nums.length - 1 -i][i]);
                }}
            }

            return resultSet.first();
        }

        private boolean isPrime(int n) {
            if(n == 1) return false;
            int nn = (int)(Math.sqrt(n));
            for(int i = 2; i <= nn; i++){
                if(n % i == 0) return false;
            }
            return true;
        }
    }
}
