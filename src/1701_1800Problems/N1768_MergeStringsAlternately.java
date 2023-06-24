public class N1768_MergeStringsAlternately {
//Runtime
//1 ms
//Beats
//77.39%
//Memory
//40.6 MB
//Beats
//96.44%

    public static void main(String[] args) {
        Solution s = new Solution();
        String w1 = "abc";
        String w2 = "pqr";
        System.out.println(s.mergeAlternately(w1,w2));
    }


    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            int minLen = Math.min(word1.length(), word2.length());
            boolean isWord1Longer = word1.length() >= word2.length();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < minLen; i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            if(isWord1Longer){
                for(int i = minLen; i < word1.length(); i++){
                    sb.append(word1.charAt(i));
                }
            }else{
                for(int i = minLen; i < word2.length(); i++){
                    sb.append(word2.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
