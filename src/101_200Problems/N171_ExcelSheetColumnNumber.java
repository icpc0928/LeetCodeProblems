public class N171_ExcelSheetColumnNumber {

    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
    //Memory Usage: 39.3 MB, less than 13.55% of Java online submissions for Excel Sheet Column Number.

    public static void main(String[] args){
        Solution sol = new Solution();
        String columnTitle = "BA";
        char c = 'Z';
        //ascii A:65 ~ Z:90
//        System.out.println((int)c);
        int ans = sol.titleToNumber(columnTitle);
        System.out.println(ans);
    }

    static class Solution {
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            for(int i = 0; i < columnTitle.length(); i++){

                ans += Math.pow(26, i) * ((int)columnTitle.charAt(columnTitle.length() - 1 - i) - 64);
            }
            return ans;
        }
    }
}
