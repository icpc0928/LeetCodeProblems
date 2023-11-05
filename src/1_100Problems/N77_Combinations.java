import java.util.*;

public class N77_Combinations {

    public static void main(String[] args) {
        Solution s = new Solution();
        var result = s.combine(13, 13);
        System.out.println(result);
    }


    //C n 取 k
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            calCombine(result, new ArrayList<>(), 1, n, k);
            return result;
        }

        /**
         *
         * @param result 實際結果
         * @param source
         * @param len
         * @param currList 目前做的
         */
        private void calCombine(List<List<Integer>> result, List<Integer> currList, int startNum, int source, int len){
            if(currList.size() == len){
                result.add(new ArrayList<>(currList));
                return;
            }
            int need = len - currList.size();
            int remain = source - startNum +1;
            int available = remain - need;

            for(int i = startNum; i <= startNum + available; i++){
                currList.add(i);
                calCombine(result, currList, i +1, source, len);
                currList.remove(currList.size() -1);
            }
        }
    }

}
