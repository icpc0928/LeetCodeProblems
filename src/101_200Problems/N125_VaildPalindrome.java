public class N125_VaildPalindrome {

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "A man, _a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();       // ^ -> 非 (非a到z 非A-Z 非0-9 ,也就是說除了這些其餘更換為"")
//            s = s.replaceAll("[\\W]", "").toLowerCase();       // \W 是可以含有底線的!!

            System.out.println(s);
            for(int i = 0; i < s.length() / 2; i++){
                if(s.charAt(i) != s.charAt(s.length()-1-i)){
                    return false;
                }
            }
            return true;

        }
    }
}
