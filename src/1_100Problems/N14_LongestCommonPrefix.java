public class N14_LongestCommonPrefix {

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder ans = new StringBuilder();
            //以第一個元素的字做迴圈
            for(int i = 0; i < strs[0].length(); i++){
               for(int j = 0; j < strs.length; j++){
                   if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                       return ans.toString();
                   }
               }
               ans.append(strs[0].charAt(i));
            }

            return ans.toString();
        }
    }
}
