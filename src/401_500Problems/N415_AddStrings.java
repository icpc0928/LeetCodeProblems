public class N415_AddStrings {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings("555", "789"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {

            int maxLen = Math.max(num1.length(), num2.length());
            char jinChar = '0';
            String result = "";
            for(int i = 0; i < maxLen; i++){
                int num1Index = num1.length() - 1 -i;
                int num2Index = num2.length() - 1 -i;
                char num1Char = '0';
                char num2Char = '0';
                if(num1Index >= 0){
                    num1Char = num1.charAt(num1Index);
                }
                if(num2Index >= 0){
                    num2Char = num2.charAt(num2Index);
                }
                String sum = getSum(jinChar, num1Char, num2Char);

                if(sum.length() >1){
                    jinChar = sum.charAt(0);
                    result = sum.charAt(1) + result;
                }else{
                    jinChar = '0';
                    result = sum.charAt(0) + result;
                }
            }
            if(jinChar != '0'){
                result = jinChar + result;
            }
            return result;
        }

        private String getSum(char jinChar, char num1Char, char num2Char) {
            //'0'的ASCII码:48
            int result = jinChar - 48 + num1Char - 48 + num2Char - 48;
            return String.valueOf(result);
        }
    }
}
