import java.util.ArrayList;

//Runtime: 1 ms, faster than 97.80% of Java online submissions for Permutation Sequence.
//Memory Usage: 36.2 MB, less than 95.02% of Java online submissions for Permutation Sequence.

public class N60_PermutationSequence {

    public static void main(String[] args){

        /**排列組合 總共有 n! 個組合 (即 n * (n-1) * ... * 1)
         * 最前位數排序依次為n
         * 故從最前面開始算
        **/
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(5, 120));

    }

    static class Solution {
        public String getPermutation(int n, int k) {
            k--;

            ArrayList<Integer> list = new ArrayList<>();
            int totalPer = 1;
            for(int i = 1; i <= n; i++){
                list.add(i);
                totalPer *= i;
            }
            StringBuilder sb = new StringBuilder();
            System.out.println("totalPer: " + totalPer);
            System.out.println();

            while (list.size() > 0){
                int group = totalPer / n;       //24
                System.out.println("Group: " + group);
                int get = k / group;
                System.out.println("get: " + get);
                sb.append(list.remove(get));
                totalPer /= n;
                k = k % group;
                n--;
            }
            return sb.toString();

        }
    }
}
