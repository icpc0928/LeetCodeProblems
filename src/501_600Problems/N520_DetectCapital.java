public class N520_DetectCapital {


    static class Solution {
        public boolean detectCapitalUse(String word) {
            boolean isFirstUp = false;
            char c = word.charAt(0);

            isFirstUp = c <= 90;
            return de(word, isFirstUp);
        }

        private boolean de(String word, boolean isFirstUpCase){
            boolean isBig = false;
            if(isFirstUpCase){
                for(int i = 1; i < word.length(); i++){
                    if(i == 1){
                        isBig = word.charAt(i) <= 90;
                    }else{
                        if(isBig){
                            if(word.charAt(i) > 90) return false;
                        }else{
                            if(word.charAt(i) <= 90) return false;
                        }
                    }
                }
            }else{
                for(int i = 1; i < word.length(); i++){
                    if(word.charAt(i) <= 90) return false;
                }
            }
            return true;
        }
    }
}
