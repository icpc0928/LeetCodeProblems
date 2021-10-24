import java.util.HashMap;

/**
 * Runtime: 7 ms, faster than 17.08% of Java online submissions for String to Integer (atoi).
 * Memory Usage: 40.9 MB, less than 5.33% of Java online submissions for String to Integer (atoi).
 */

public class N08_StringToInteger {

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "0 123";
        System.out.println(solution.myAtoi(str));

    }

    static class Solution {
        public int myAtoi(String s) {
            long ans = 0;
            boolean isWhitespaceFirst = true;
            boolean isPorN = true;
            boolean PorN = true;
            HashMap<Character, Integer> charMap = new HashMap<Character, Integer>(){
                {
                    put('0', 0);
                    put('1', 1);
                    put('2', 2);
                    put('3', 3);
                    put('4', 4);
                    put('5', 5);
                    put('6', 6);
                    put('7', 7);
                    put('8', 8);
                    put('9', 9);
                }
            };

            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == ' ' && isWhitespaceFirst){
                    continue;
                }
                if((s.charAt(i) == '+' || s.charAt(i) == '-') && isPorN){
                    PorN = s.charAt(i) == '+';
                    isWhitespaceFirst = false;
                    isPorN = false;
                    continue;
                }
                if(charMap.containsKey(s.charAt(i))){
                    int temp = charMap.get(s.charAt(i));
                    if(PorN){
                        if(((Integer.MAX_VALUE - temp) / 10) >= ans){
                            ans = ans * 10 + temp;
                            System.out.println(ans);
                        }else{
                            return  Integer.MAX_VALUE;
                        }
                    }else{
                        if((Integer.MIN_VALUE + temp) / 10 <= ans){
                            ans = ans * 10 - temp;
                        }else{
                            return Integer.MIN_VALUE;
                        }

                    }

                    isPorN = false;
                    isWhitespaceFirst = false;
                    continue;
                }
                break;
            }

            return (int)ans;
        }
    }
}
