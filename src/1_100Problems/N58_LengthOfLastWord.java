public class N58_LengthOfLastWord {

    public static void main(String[] args){
        String s ="    ";
        Solution solution = new Solution();
        int ans = solution.lengthOfLastWord(s);
        System.out.println(ans);
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            String[] stringArr = s.split(" ");
            if(stringArr.length == 0)
                return 0;
            return stringArr[stringArr.length - 1].length();

//            int i = s.length() - 1, length = 0;
//
//            while (i >= 0 && s.charAt(i) == ' ') i--;
//
//            while (i >= 0 && s.charAt(i) != ' ') {
//                length++;
//                i--;
//            }
//            return length;


        }
    }
}
