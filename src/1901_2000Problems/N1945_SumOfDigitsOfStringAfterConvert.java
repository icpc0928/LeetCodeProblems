import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1945_SumOfDigitsOfStringAfterConvert {


    public static void main(String[] args) {
       Solution s = new Solution();
       System.out.println(s.getLucky("leetcode", 2));
    }

    public static class Solution {

        public int getLucky(String s, int k) {
            int num = 0;
            for(int i = 0; i < s.length(); i++){
                int digits = getNumSum(s.charAt(i) - 96);
                num += digits;
            }
            for(int i = 1; i < k; i++){
                int result = 0;
                while(num > 0){
                    int lastNum = num % 10;
                    result += lastNum;
                    num /= 10;
                }
                num = result;
            }
            return num;
        }

        private int getNumSum(int num){
            int result = 0;
            while(num > 0){
                int lastNum = num % 10;
                result += lastNum;
                num /= 10;
            }
            return result;
        }
    }

//    private static Map<String, Integer> getConvertMap(){
//        Map<String, Integer> result = new HashMap<>();
//        for(int i = 1; i <= 26; i++){
//            char c = (char)(96 + i);
//            result.put(String.valueOf(c), i);
//        }
//        System.out.println(result);
//        return result;
//    }
}
