public class N278_FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    //Runtime: 12 ms, faster than 98.38% of Java online submissions for First Bad Version.
    //Memory Usage: 35.6 MB, less than 72.01% of Java online submissions for First Bad Version.

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 5;

        System.out.println(solution.firstBadVersion(n));
    }


    static public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            //1~n
            int low = 1;
            int high = n;
            while(low < high){
                int now = low + (high - low) / 2;
                if(isBadVersion(now)){
                    high = now;
                }else{
                    low = now + 1;
                }
            }
            return low;
        }
    }
}

class VersionControl{
    int bad = 4;
    boolean isBadVersion(int version){
        return version >= bad;
    }
}
