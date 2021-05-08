import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args){
        Solution solution = new Solution();
        String digits = "23";
        ArrayList arrayList = (ArrayList) solution.letterCombinations(digits);


    }

    static class Solution {
//        public List<String> letterCombinations(String digits) {
//            List<String> list = new ArrayList<>();
////            String[][] strings = {
////                    {null},
////                    {null},
////                    {"a", "b", "c"},
////                    {"d", "e", "f"},
////                    {"g", "h", "i"},
////                    {"j", "k", "l"},
////                    {"m", "n", "o"},
////                    {"p", "q", "r", "s"},
////                    {"t", "u", "v"},
////                    {"w", "x", "y", "z"},
////            };
//            HashMap<String, String> letters = new HashMap<String, String>(){
//                {
//                    put("2", "abc");
//                    put("3", "def");
//                    put("4", "ghi");
//                    put("5", "jkl");
//                    put("6", "mno");
//                    put("7", "pqrs");
//                    put("8", "tuv");
//                    put("9", "wxyz");
//                }
//            };
//
//            if(digits.length() == 0){
//                return list;
//            }
//
//
//
//            return list;
//        }
private List<String> combinations = new ArrayList<>();
        private Map<String, String> letters = new HashMap<String, String>(){
            {
                    put("2", "abc");
                    put("3", "def");
                    put("4", "ghi");
                    put("5", "jkl");
                    put("6", "mno");
                    put("7", "pqrs");
                    put("8", "tuv");
                    put("9", "wxyz");
            }
        };
        private String phoneDigits;

        public List<String> letterCombinations(String digits) {
            // If the input is empty, immediately return an empty answer array
            if (digits.length() == 0) {
                return combinations;
            }

            // Initiate backtracking with an empty path and starting index of 0
            phoneDigits = digits;
            backtrack(0, new StringBuilder());
            return combinations;
        }

        private void backtrack(int index, StringBuilder path) {
            // If the path is the same length as digits, we have a complete combination
            if (path.length() == phoneDigits.length()) {
                combinations.add(path.toString());
                return; // Backtrack
            }

            // Get the letters that the current digit maps to, and loop through them
            String possibleLetters = letters.get(phoneDigits.charAt(index));
            for (char letter: possibleLetters.toCharArray()) {
                // Add the letter to our current path
                path.append(letter);
                // Move on to the next digit
                backtrack(index + 1, path);
                // Backtrack by removing the letter before moving onto the next
                path.deleteCharAt(path.length() - 1);
            }
        }
    }



}
