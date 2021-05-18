public class N299_BullsAndCows {
    public static void main(String[] args){
        Solution solution = new Solution();
        String secret = "1123";
        String guess = "0111";
        System.out.println(solution.getHint(secret, guess));
    }


    static class Solution {
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
