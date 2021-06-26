public class N168_ExcelSheetColumnTitle {

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
    //Memory Usage: 36 MB, less than 73.89% of Java online submissions for Excel Sheet Column Title.

    public static void main(String[] args){
        Solution solution = new Solution();
        int colNum = 701;
        System.out.println(solution.convertToTitle(colNum));
    }


    static class Solution {
        public String convertToTitle(int columnNumber) {
            //1~26 => A~Z
            //27 => AA , 28 => AB
            //將 colNum 轉 26進位 //A~Z 65~90

            int mod = columnNumber % 26 ;        //餘數
            int quotient = columnNumber / 26 ;   //商數
            StringBuilder sb = new StringBuilder();
            do{
                if (mod == 0) {
                    mod = 26;
                    quotient--;
                }
                int asciiValue = mod + 64;
                sb.insert(0, (char)asciiValue);
                if(quotient > 0){
                    mod = quotient % 26;
                    quotient = quotient / 26;
                }else break;
            }while (true);

            return sb.toString();

        }
    }
}
