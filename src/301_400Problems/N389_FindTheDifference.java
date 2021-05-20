public class N389_FindTheDifference {

    //Runtime: 1 ms, faster than 99.57% of Java online submissions for Find the Difference.
    //Memory Usage: 37.3 MB, less than 67.13% of Java online submissions for Find the Difference.

    //使用xor 計算單一字串的所有xor
    //如兩個字串的文字(排序不重要) 一樣,則xor值應當相同,因t為s的所有字母組成外加一個字母,故tXor與sXor就會相差該字母的位元值,再由其位元值轉為char

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aasdfasdfasdfasasffdsafasdfasfasdflkytuytuoxnvblkewrwqwwrwqerewfdcv";
        String t = "flkytuytuonvblkewrwqwffdsafasdaaswrwqerewfdcvdfasasdfasdfasxsdfasfa";
        System.out.println(solution.findTheDifference(s, t));
    }


    static class Solution {
        public char findTheDifference(String s, String t) {

            if(s.length() == 0){
                return t.charAt(0);
            }
            char[] sChar = s.toCharArray();
            char[] tChar = t.toCharArray();
            int sXor = 0, tXor = 0;
            for (char c : sChar) {
                sXor = sXor ^ c;
                System.out.println("sXor: " + sXor);
            }
            for (char c : tChar) {
                tXor = tXor ^ c;
                System.out.println("tXor: " + tXor);
            }
            int result = tXor ^ sXor;
            System.out.println("sXor: " + sXor);
            System.out.println("tXor: " + tXor);
            System.out.println("Result: " + result);
            for(int i = 0; i < 999; i++){
                System.out.println("ToChar " + i + " is" + (char) i);
            }

            return (char)result;

        }
    }
}
