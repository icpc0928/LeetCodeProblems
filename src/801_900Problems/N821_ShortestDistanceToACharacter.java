public class N821_ShortestDistanceToACharacter {


    class Solution {
        public int[] shortestToChar(String s, char c) {
            int[] result = new int[s.length()];
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++){

                if(chars[i] == c){
                    DFS(result, chars, c, i + 1, i);
                    DFS(result, chars, c, i - 1, i);
                }
            }

            return result;
        }

        /**
         *
         * @param result 距離的結果
         * @param chars 原始數據
         * @param c 要檢查的char
         * @param i 要檢查的index
         * @param pos 原始index
         */
        private void DFS(int[] result, char[] chars, char c, int i, int pos) {
            if(i < 0 || i >= result.length) return;
            if(chars[i] == c) return;
            int abs = Math.abs(pos - i);
            if(result[i] != 0 && result[i] <= abs) return;

            result[i] = abs;
            DFS(result, chars, c, i + 1, pos);
            DFS(result, chars, c, i - 1, pos);
        }
    }
}
