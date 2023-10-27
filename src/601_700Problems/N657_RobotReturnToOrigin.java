public class N657_RobotReturnToOrigin {

    public static void main(String[] args) {
        int u = 'U';    //85 -0
        int d = 'D';    //68 -3
        int l = 'L';    //76 -1
        int r = 'R';    //82 -2
        System.out.println(u + "-" + d +"-"+ l +"-"+ r);
    }

    class Solution {
        public boolean judgeCircle(String moves) {
            //[U,L,R,D]
            int[] countArr = new int[4];
            for(char c : moves.toCharArray()){
                countArr[c % 5]++;
            }
            return countArr[0] == countArr[3] && countArr[1] == countArr[2];
        }
    }
}
