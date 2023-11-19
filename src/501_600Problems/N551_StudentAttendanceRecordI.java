public class N551_StudentAttendanceRecordI {

    class Solution {
        public boolean checkRecord(String s) {
            //A 65 L 76 P 80
            int countA = 0;
            int countL = 0;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == 'P') {
                    countL = 0;
                    continue;
                }

                if(c == 'A'){
                    countA ++;
                    countL = 0;
                }else if(c == 'L'){
                    if(++countL == 3){
                        return false;
                    }
                }
            }
            return countA < 2;
        }
    }
}
