import java.util.Arrays;

public class N43_MultiplyStrings {

    public static void main(String[] args){

    }


    static class Solution {

        //can't use Integer lib

        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0"))
                return "0";

            int len1 = num1.length(), len2 = num2.length();
            char[] ans = new char[len1 + len2];
            Arrays.fill(ans, '0');
            for(int i = len1 - 1; i >= 0; i--){
                int carry = 0;
                for(int j = len2 - 1; j >= 0; j--){
                    int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry + (ans[i + j + 1] - '0');
                    int last = prod % 10;
                    ans[i + j + 1] = (char)(last + '0');
                    carry = prod / 10;
                }
                if (carry != 0)
                    ans[i] = (char) (carry + '0');
            }
            String res = new String(ans);
            if(res.charAt(0) != '0')
                return res;
            return res.substring(1);
        }
    }
}
