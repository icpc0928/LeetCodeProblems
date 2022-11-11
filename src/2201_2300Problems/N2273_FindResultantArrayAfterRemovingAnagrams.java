import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//Runtime: 21 ms, faster than 8.53% of Java online submissions for Find Resultant Array After Removing Anagrams.
//Memory Usage: 47.4 MB, less than 11.94% of Java online submissions for Find Resultant Array After Removing Anagrams.

public class N2273_FindResultantArrayAfterRemovingAnagrams {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words = {"abba","baba","bbaa","cd","cd"};

        System.out.println(solution.removeAnagrams(words));

    }


    static class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> result = new ArrayList<>(Arrays.asList(words));
            for(int i = result.size() - 2; i >= 0; i--){
                if(isAnagram(result.get(i), result.get(i + 1))){
                    result.remove(i + 1);
                }
            }
            return result;
        }

        public boolean isAnagram(String s, String t) {

            if(s.length() != t.length()) return false;

            HashMap<Character, Integer> checkMap = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                char a = s.charAt(i);
                checkMap.put(a, checkMap.getOrDefault(a, 0) + 1);
                if(checkMap.get(a) == 0) checkMap.remove(a);
                char b = t.charAt(i);
                checkMap.put(b, checkMap.getOrDefault(b, 0) - 1);
                if(checkMap.get(b) == 0) checkMap.remove(b);

            }

            return checkMap.size() == 0;
        }
    }
}
