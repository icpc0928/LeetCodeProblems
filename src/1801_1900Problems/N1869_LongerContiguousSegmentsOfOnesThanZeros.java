public class N1869_LongerContiguousSegmentsOfOnesThanZeros {

//Runtime: 2 ms, faster than 19.95% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
//Memory Usage: 38.7 MB, less than 27.73% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.

    static class Solution {
        public boolean checkZeroOnes(String s) {
            int maxOne = 0, tempOne = 0;
            int maxZero = 0, tempZero = 0;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '0'){
                    maxZero = Math.max(maxZero, ++tempZero);
                    tempOne = 0;

                }else{
                    maxOne = Math.max(maxOne, ++tempOne);
                    tempZero = 0;
                }
            }
            return maxOne > maxZero;
        }
    }
}
