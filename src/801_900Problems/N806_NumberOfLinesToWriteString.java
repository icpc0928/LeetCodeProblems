public class N806_NumberOfLinesToWriteString {


    class Solution {
        public int[] numberOfLines(int[] widths, String s) {
            //[行數,最後一行像素]
            int lines = 1;
            int lastWidth = 0;
            for(char c : s.toCharArray()){
                int width = widths[c - 'a'];
                if(lastWidth + width > 100){
                    lines++;
                    lastWidth = width;
                }else{
                    lastWidth += width;
                }
            }
            return new int[]{lines, lastWidth};
        }
    }
}
