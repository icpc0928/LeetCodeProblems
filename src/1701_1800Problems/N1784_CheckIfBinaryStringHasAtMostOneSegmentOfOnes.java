public class N1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    //Runtime: 4 ms, faster than 25.41% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.
    //Memory Usage: 39.1 MB, less than 6.89% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.

    //檢查此字串是否只有 一個連續的1組成 (無前導0)
    //故只要 中間有0 將1分開 就不行惹



    static class Solution {
        public boolean checkOnesSegment(String s) {
            return s.split("0").length == 1;
        }
    }
}
