import java.util.HashMap;

/**
 * Runtime: 51 ms, faster than 22.96% of Java online submissions for First Unique Character in a String.
 * Memory Usage: 54.2 MB, less than 29.48% of Java online submissions for First Unique Character in a String.
 */

public class N387_FirstUniqueCharacterInAString {


    public static void main(String[] args) {
        String s = "leetcode";
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(s));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> charCounter = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                charCounter.put(s.charAt(i), charCounter.getOrDefault(s.charAt(i), 0) + 1 );
            }

            for(int i = 0; i < s.length(); i++){
                if(charCounter.get(s.charAt(i)) == 1){
                    return i;
                }
            }
            return -1;
        }
    }

}
