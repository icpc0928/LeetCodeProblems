import java.util.HashSet;
import java.util.Set;

public class N804_UniqueMorseCodeWords {

    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] wordsArr = new String[] {
                    ".-","-...","-.-.","-..",".",
                    "..-.","--.","....","..",".---",
                    "-.-",".-..","--","-.","---",
                    ".--.","--.-",".-.","...","-",
                    "..-","...-",".--","-..-","-.--","--.."};
            Set<String> morseSet = new HashSet<>();

            for(String word : words){
                morseSet.add(getMorse(word, wordsArr));
            }
            return morseSet.size();
        }

        private String getMorse(String word, String[] wordsArr) {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append(wordsArr[c - 'a']);
            }
            return sb.toString();
        }
    }
}
