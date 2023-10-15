public class N38_CountAndSay {

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int i = 1;i <= 30; i++)
            System.out.println("n: " + i + " : " + s.countAndSay(i));
    }

    static class Solution {
        public String countAndSay(int n) {

            return countAndSay(1, n, "1");
        }

        private String countAndSay(int times, int target, String value){
            if(times == target) return value;
            StringBuilder newStr = new StringBuilder();
            char checkC = value.charAt(0);
            int count = 0;
            for(int i = 0; i < value.length(); i++){
                char thisChar = value.charAt(i);

                if(thisChar == checkC){
                    count++;
                }else{
                    newStr.append(count).append(checkC);

                    checkC = thisChar;
                    count= 1;
                }
            }
            if(count > 0){
                newStr.append(count).append(checkC);
            }

            return countAndSay(++times, target, newStr.toString());
        }
    }

}
