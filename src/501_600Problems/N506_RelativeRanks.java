import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class N506_RelativeRanks {
    //Runtime: 14 ms, faster than 56.13% of Java online submissions for Relative Ranks.
    //Memory Usage: 54.6 MB, less than 5.25% of Java online submissions for Relative Ranks.


    public static void main(String[] args){
        int[] score = {10,3,8,9,4};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRelativeRanks(score)));
    }


    static class Solution {
        public String[] findRelativeRanks(int[] score) {
            String[] answer = new String[score.length];
            HashMap<Integer, String> medal = new HashMap<Integer, String>(){
                {
                    put(1, "Gold Medal");
                    put(2, "Silver Medal");
                    put(3, "Bronze Medal");
                }
            };
            //score, index
            HashMap<Integer, Integer> ranks = new HashMap<>();

            for(int i = 0; i < score.length; i++){
                ranks.put(score[i], i);
            }
            Arrays.sort(score); //小到大排序
            for(int r = score.length - 1; r >= 0; r--){
                int rank = score.length - r;
                if(medal.isEmpty()){
                    answer[ranks.get(score[r])] = String.valueOf(rank);
                }else{
                    if(medal.containsKey(rank)){
                        answer[ranks.get(score[r])] = medal.get(rank);
                        medal.remove(rank);
                    }else{
                        answer[ranks.get(score[r])] = String.valueOf(rank);
                    }
                }
            }

            return answer;
        }
    }
}
