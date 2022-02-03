
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class N500_KeyboardRow {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Keyboard Row.
    //Memory Usage: 40.1 MB, less than 12.68% of Java online submissions for Keyboard Row.

    public static void main(String[] args){

        Solution solution = new Solution();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(solution.findWords(words)));
    }

    static class Solution {
        public String[] findWords(String[] words) {
            List<String> ansList = new ArrayList<>();
            HashMap<String, Integer> wordsMap = new HashMap<String, Integer>(){
                {
                    put("q", 0);put("w", 0);put("e", 0);put("r", 0);put("t", 0);put("y", 0);put("u", 0);put("i", 0);put("o", 0);put("p", 0);
                    put("a", 1);put("s", 1);put("d", 1);put("f", 1);put("g", 1);put("h", 1);put("j", 1);put("k", 1);put("l", 1);
                    put("z", 2);put("x", 2);put("c", 2);put("v", 2);put("b", 2);put("n", 2);put("m", 2);
                }
            };
            work:
            for(int i = 0; i < words.length; i++){
                String s = words[i].toLowerCase();
                int usingRow = wordsMap.get(String.valueOf(s.charAt(0)));
                for(int j = 0; j < s.length(); j++){
                    if(wordsMap.get(String.valueOf(s.charAt(j))) != usingRow){
                        continue work;
                    }
                }
                ansList.add(words[i]);
            }
            String[] ans = new String[ansList.size()];
            for(int i = 0; i < ansList.size(); i++){
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }
}
