public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args){
        String s = "pwwkew";
        Solution solution = new Solution();
        int ans = solution.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    static class Solution{
        public int lengthOfLongestSubstring(String s){
            int ans = 0;
            for(int i = 0; i < s.length(); i++){
                String maxChar = "";
                for(int j = i; j < s.length(); j++){
                    if(!maxChar.contains("" + s.charAt(j))){
                        maxChar = maxChar + s.charAt(j);
                    }else{
                        break;
                    }
                }
                ans = Math.max(ans, maxChar.length());
            }
            return ans;
        }
    }
}
