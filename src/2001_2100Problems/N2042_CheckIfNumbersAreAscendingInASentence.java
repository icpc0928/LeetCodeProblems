public class N2042_CheckIfNumbersAreAscendingInASentence {

    /**
     * Runtime: 7 ms, faster than 23.54% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
     * Memory Usage: 39.3 MB, less than 29.39% of Java online submissions for Check if Numbers Are Ascending in a Sentence.
     */

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(solution.areNumbersAscending(s));

    }

    static class Solution {
        public boolean areNumbersAscending(String s) {
            String[] strings = s.split(" ");
            int temp = 0;
            for(int i = 0; i < strings.length; i++){
                if(strings[i].chars().allMatch(Character :: isDigit)){
                    if(Integer.parseInt(strings[i]) > temp){
                        temp = Integer.parseInt(strings[i]);
                    }else
                        return false;
                }
            }
            return true;
        }
    }
}
