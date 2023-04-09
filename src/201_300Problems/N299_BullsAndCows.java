import java.util.HashMap;

public class N299_BullsAndCows {
    public static void main(String[] args){
        Solution solution = new Solution();
        String secret = "1807";
        String guess =  "7810";
        System.out.println(solution.getHint(secret, guess));
    }

    //2023-04-09 讓專業的來
    static class Solution {
        public String getHint(String secret, String guess) {
            HashMap<String, Integer> containsMap = new HashMap<>();
            int a = 0;
            for(int i = 0; i < secret.length(); i++){
                String s = String.valueOf(secret.charAt(i));
                String g = String.valueOf(guess.charAt(i));
                if(s.equals(g)) a ++;
                containsMap.put(s, containsMap.getOrDefault(s, 0) + 1);
                containsMap.put(g, containsMap.getOrDefault(g, 0) - 1);
            }
            int b = secret.length() - a;
            for(String key : containsMap.keySet())
                if(containsMap.get(key) > 0) b = b - containsMap.get(key);

            return a + "A"+ b + "B";
        }
    }

    //2021-05-18寫的 我草是錯的 在寫三小看不懂
    static class SolutionB {
        public String getHint(String secret, String guess) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < secret.length(); i++){
                System.out.println(secret);
                System.out.println(guess);
                if(secret.charAt(i) == guess.charAt(i)){
                    a++;
                    secret = secret.substring(i, i+1);
                    guess = guess.substring(i,i+1);
//                    guess.
                    i--;

                }
            }
            System.out.println(secret);
            System.out.println(guess);
            for(int i = 0; i < secret.length(); i++){
                if(secret.contains(String.valueOf(guess.charAt(i)))){
                    b++;
                }
            }
//            b -= a;
            return a + "A" + b + "B";
        }
    }
}
