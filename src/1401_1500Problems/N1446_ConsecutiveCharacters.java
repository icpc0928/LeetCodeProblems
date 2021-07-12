public class N1446_ConsecutiveCharacters {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
    //Memory Usage: 37.9 MB, less than 49.06% of Java online submissions for Consecutive Characters.

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "cc";
        System.out.println( sol.maxPower(s));
    }


    static class Solution {
        public int maxPower(String s) {
            int maxAns = 1;
            int tempAns = 1;
            if(s.length() == 1) return 1;

            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(i - 1)){
                    tempAns++;

                }else{
                    maxAns = Math.max(maxAns, tempAns);
                    tempAns = 1;
                }
            }

            return Math.max(maxAns, tempAns);
        }
    }
}
