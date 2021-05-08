public class N28_ImplementStrStr {

    public static void main(String[] args){
        String haystack ="a";
        String needle = "a";
        Solution solution = new Solution();
        int ans = solution.strStr(haystack, needle);
        System.out.println(ans);
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length() == 0){
                return 0;
            }
            if(haystack.length() == 0){
                return -1;
            }
            for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
                if(needle.equals(haystack.substring(i, i + needle.length()))){
                    return i;
                }
            }
            return -1;
        }
    }
}
