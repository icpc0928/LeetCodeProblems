public class N392_IsSubsequence {


    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() > t.length()) return false;
            if(s.length() == 0) return true;
            int i = 0;
            for(char c : t.toCharArray()){
                if(s.charAt(i) == c){
                    if(++i == s.length()) return true;
                }
            }
            return false;
        }
    }
}
