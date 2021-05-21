import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args){
        String digits = "23";
        Solution solution = new Solution();
        List<String> ans = solution.letterCombinations(digits);
        System.out.println(ans.toString());
    }



    static class Solution {

        char[][] map = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if(digits.length() == 0) return ans;
            working(new StringBuilder(), map, ans, digits, 0);
            return ans;

        }

        public void working(StringBuilder sb, char[][] map, List<String> ans, String digits, int len){
            if(len == digits.length()){
                ans.add(sb.toString());
                return;
            }
            int ch = digits.charAt(len) - '2';
            for(int i = 0; i < map[ch].length; i++){
                sb.append(map[ch][i]);
                working(sb, map, ans, digits, len + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
