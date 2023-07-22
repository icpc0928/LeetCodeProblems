import java.util.*;

public class N47_PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        Solution s = new Solution();

        System.out.println(s.permuteUnique(nums));
    }

    /**
     * 所有排列組合去除重複
     * int[] nums = [1,2,3]
     * 回傳[[123],[132],[213],[231],[312],[321]
     */
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            calCombine(nums, result, new ArrayList<>());
            return new ArrayList<>(result);
        }

        /**
         *
         * @param source 源頭
         * @param result 最終結果
         * @param indexList 暫時索引
         */
        private void calCombine(int[] source, Set<List<Integer>> result, List<Integer> indexList){
            if(indexList.size() == source.length){
                List<Integer> rList = new ArrayList<>(indexList.size());
                for(int i = 0; i < source.length; i++){
                    rList.add(source[indexList.get(i)]);
                }
                result.add(rList);
                return;
            }
            List<Integer> tempIndexList = new LinkedList<Integer>(indexList);
            for(int i = 0; i < source.length; i++){
                if(!indexList.contains(i)){
                    tempIndexList.add(i);
                    calCombine(source, result, tempIndexList);
                    tempIndexList.remove(Integer.valueOf(i));
                }
            }
        }
    }
}
