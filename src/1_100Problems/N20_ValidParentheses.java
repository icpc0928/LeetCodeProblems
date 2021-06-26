import java.util.ArrayList;
//Runtime: 1 ms, faster than 98.79% of Java online submissions for Valid Parentheses.
//Memory Usage: 37.2 MB, less than 43.07% of Java online submissions for Valid Parentheses.

public class N20_ValidParentheses {

    public static void main(String[] args){
        String s ="{[]}";
        Solution solution = new Solution();
        boolean ans = solution.isValid(s);
        System.out.println(ans);
    }

    static class Solution {
        public boolean isValid(String s) {
            ArrayList<Character> arrayList = new ArrayList<>();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '{' || c == '[' || c == '('){
                    arrayList.add(c);
                }else if(arrayList.size() > 0){
                    if(c == '}' && arrayList.get(arrayList.size() - 1) == '{')
                        arrayList.remove(arrayList.size() - 1);
                    else if(c == ']' && arrayList.get(arrayList.size() - 1) == '[')
                        arrayList.remove(arrayList.size() - 1);
                    else if(c == ')' && arrayList.get(arrayList.size() - 1) == '(')
                        arrayList.remove(arrayList.size() - 1);
                    else return false;
                }else return false;
            }

            if(arrayList.size() == 0) return true;
            else return false;

        }
    }
}
