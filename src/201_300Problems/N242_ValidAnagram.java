import java.util.HashMap;
//Runtime: 22 ms, faster than 33.44% of Java online submissions for Valid Anagram.
//Memory Usage: 42.5 MB, less than 90.84% of Java online submissions for Valid Anagram.
public class N242_ValidAnagram {


    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s,t));


    }


    static class Solution {
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
