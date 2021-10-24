import java.util.HashMap;

/**
 * Runtime: 1 ms, faster than 86.82% of Java online submissions for Sorting the Sentence.
 * Memory Usage: 36.8 MB, less than 93.21% of Java online submissions for Sorting the Sentence.
 */

public class N1859_SortingTheSentence {

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "is2 sentence4 This1 a3";
        System.out.println(solution.sortSentence(s));
    }


    static class Solution {
        public String sortSentence(String s) {
            HashMap<Integer, String> sentenceMap = new HashMap<>();
            String[] strings = s.split(" ");
            for(int i = 0; i < strings.length; i++){
                int temp = Integer.parseInt(String.valueOf(strings[i].charAt(strings[i].length() - 1)));

                sentenceMap.put(temp, strings[i].substring(0, strings[i].length() - 1));
            }
//            System.out.println(sentenceMap);
            StringBuilder ans = new StringBuilder();
            for(int i = 1; i <= strings.length; i++){
                ans.append(sentenceMap.get(i)).append(" ");

            }
            return ans.substring(0, ans.length() - 1);
        }
    }
}
