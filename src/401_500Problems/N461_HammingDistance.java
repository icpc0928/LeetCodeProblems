public class N461_HammingDistance {
    //取兩個數的漢明距離   aka -> 兩數字的補碼 轉二進制, 取該二進數中1的數量
    class Solution {
        public int hammingDistance(int x, int y) {
            return getBinaryDistance(x ^ y);


        }

        private int getBinaryDistance(int h){
            int result = 0;
            while (h != 0){
                int d = h /2;
                result += h - (d * 2);
                h /= 2;
            }
            return result;
        }

        /**
         * 另一種做法 但是是用字串
         * @param x
         * @param y
         * @return
         */
        private int getHammingDistanceByBinaryString(int x, int y){
            int h = x ^ y;
            String hStr = Integer.toBinaryString(h);    //轉二進字串
            return hStr.replaceAll("0", "").length(); //將0取消, 只取1
        }

        /**
         * 簡單粗暴, 沒看過的方法ㄏㄏ
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance2(int x, int y){
            return Integer.bitCount(x ^ y);
        }
    }
}
