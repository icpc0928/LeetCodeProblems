public class ValidParentheses {

    public static void main(String[] args){
        String s ="{[]}";
        Solution solution = new Solution();
        boolean ans = solution.isValid(s);
        System.out.println(ans);
    }

    static class Solution {
        public boolean isValid(String s) {
            if(s.length() % 2 != 0)
                return false;


            return true;
        }
    }
}
