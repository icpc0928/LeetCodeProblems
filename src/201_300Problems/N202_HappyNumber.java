
import java.util.HashSet;

public class N202_HappyNumber {

    public static void main(String[] args){
        Solution s = new Solution();
        int n = 19;
        System.out.println(s.isHappy(n));
    }

    static class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            do{
                if(n == 1)
                    return true;
                else{
                    //平方和
                    n = happy(n);
                    if(!set.add(n)){
                        return false;
                    }
                }
            }while (true);

        }

        public int happy(int n){
            int result = 0;
            System.out.println("N: " + n);
            while(n > 0){
                result += Math.pow(n % 10, 2);
                n = n / 10;
            }

            System.out.println("Result: " + result);
            return result;
        }
    }
}
