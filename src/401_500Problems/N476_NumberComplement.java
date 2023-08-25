public class N476_NumberComplement {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findComplement(5));
    }


    static class Solution {
        public int findComplement(int num) {
            String binStr = Integer.toBinaryString(num);

            boolean hasFirstZero = false;
            StringBuilder comSb = new StringBuilder();
            for(int i = 0; i < binStr.length(); i++){
                int c = 1 - Integer.parseInt(String.valueOf(binStr.charAt(i)));
                if(hasFirstZero){
                    comSb.append(c);
                }else{
                    if(c == 0) continue;
                    hasFirstZero = true;
                    comSb.append(c);
                }
            }
            int result = 0;
            int temp = 1;
            String str = comSb.toString();
            for(int i = str.length() - 1; i >= 0; i--){
                result += Integer.parseInt(String.valueOf(str.charAt(i))) * temp;
                temp *= 2;
            }


            return result;
        }

        public int findComplement2(int num) {
            String binStr = Integer.toBinaryString(num);

            int result = 0;
            int times = 1;
            for(int i = binStr.length() - 1; i >= 0; i--){
                result += (1-Integer.parseInt(String.valueOf(binStr.charAt(i)))) * times;
                times *= 2;
            }
            return result;

        }
    }

}
