import java.util.*;

public class N819_MostCommonWord {

    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        var v = s.replaceAll("\\p{Punct}", " ");
        String[] sa = v.split(" ");
        System.out.println(Arrays.toString(sa));
    }

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase();
            String[] pars = paragraph.split(" ");
            Map<String, Integer> result = new HashMap<>();
            Set<String> banSet = new HashSet<>(Arrays.asList(banned));
            for(String para : pars){
                if(!banSet.contains(para) && !para.isEmpty()){
                    result.put(para, result.getOrDefault(para, 0) + 1);
                }
            }
            int max = 0;
            String resultStr = "";
            for(String key : result.keySet()){
                if(result.get(key)> max){
                    resultStr = key;
                    max = result.get(key);
                }

            }
            return resultStr;
        }
    }
}
