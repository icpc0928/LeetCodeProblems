import java.util.HashMap;

public class N05_LongestPalindromicSubstring {
    //潮慢的
    //Runtime: 792 ms, faster than 6.63% of Java online submissions for Longest Palindromic Substring.
    //Memory Usage: 39 MB, less than 69.35% of Java online submissions for Longest Palindromic Substring.

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aacabdkacaa";
        System.out.println(solution.longestPalindrome(s));

    }


    static class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            int key = 0;
            int maxLength = 1;

            for(int i = 0; i < chars.length; i++){          //目前提取的
                for(int j = chars.length - 1; j > i; j-- ){ //檢查的 如果跟提取的一樣 才進行是否是回文
                    if(chars[i] == chars[j]){
                        //TODO
                        if(isPalindromic(chars, i, j)){
                            if(j - i + 1 > maxLength){
                                key = i;
                                maxLength = j - i + 1;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < maxLength; i++){
                ans.append(chars[key + i]);
            }
            return ans.toString();
        }

        public boolean isPalindromic(char[] chars, int i, int j){
            do{
                if(chars[i] != chars[j])
                    return false;
                i++;
                j--;
            }while (i < j);
            return true;
        }
    }
}
