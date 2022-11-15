import java.util.HashMap;

public class N1189_MaximumNumberOfBalloons {
    //Runtime: 23 ms, faster than 19.59% of Java online submissions for Maximum Number of Balloons.
    //Memory Usage: 42.7 MB, less than 40.05% of Java online submissions for Maximum Number of Balloons.


    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "loonbalxballpoon";
        System.out.println(solution.maxNumberOfBalloons(text));
    }



    static class Solution {
        public int maxNumberOfBalloons(String text) {
            int result = Integer.MAX_VALUE;
            HashMap<Character, Integer> staticMap = new HashMap<>();
            staticMap.put('b', 1);
            staticMap.put('a', 1);
            staticMap.put('l', 2);
            staticMap.put('o', 2);
            staticMap.put('n', 1);

            HashMap<Character, Integer> balloonsCount = new HashMap<>();
            balloonsCount.put('b', 0);
            balloonsCount.put('a', 0);
            balloonsCount.put('l', 0);
            balloonsCount.put('o', 0);
            balloonsCount.put('n', 0);
            for(int i = 0; i < text.length(); i++){
                char ch = text.charAt(i);
                if(balloonsCount.containsKey(ch)){
                    balloonsCount.put(ch, balloonsCount.get(ch) + 1);
                }
            }

            for(Character cha : staticMap.keySet()){
                result = Math.min(result, balloonsCount.get(cha) / staticMap.get(cha));
            }
            return result;
        }
    }
}
