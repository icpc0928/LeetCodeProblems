import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Runtime
//113 ms
//Beats
//71.99%
//Memory
//43.3 MB
//Beats
//41.69%
public class N30_SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        String s = "abaababbaba";
        String[] words = {"ba","ab","ab"};
        Solution solution = new Solution();
        System.out.println(solution.findSubstring(s, words));
    }

    // words 內容可重複, 但所有單詞長度一致, s 為words中元素的組合 所以不會有words元素外的單詞出現.....我錯了,s是會有其他word單辭以外的字詞出現乾
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();

            Map<String, Integer> wordsMap = new HashMap<>();    //存放各單辭要出線的次數

            for (String word : words) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }
            int wordLen = words[0].length(); //一個單辭長度
            int count = words.length;           //幾個單辭
            boolean isFrontConcat = false;    //前面有達成需求
            String cacheStr = "";
            for(int i = 0; i <= s.length() - (wordLen * count); i++){    //屁股後面的不足的不用了

                //我以為加這個判斷會提高速度, 結果我錯了, 一樣快(or一樣慢)
                if(result.size() > 0 && result.get(result.size() - 1) + wordLen == i){
                    isFrontConcat = true;
                    int lastIndex = result.get(result.size() - 1);
                    cacheStr = s.substring(lastIndex, lastIndex + wordLen);
                }else{
                    isFrontConcat = false;
                }

                if(isConcatenated(isFrontConcat, cacheStr, wordsMap, s.substring(i, i + (wordLen * count)), wordLen)){
                    result.add(i);
                }
            }

            return result;
        }


        private boolean isConcatenated(boolean isFrontConcat, String cacheStr, Map<String, Integer> wordsMap, String subStr, int wordLen){
            if(isFrontConcat){
                //如果上一組有成功, 這組只要判斷屁股是不是上一組的頭
                return cacheStr.equals(subStr.substring(subStr.length() - wordLen));
            }else{
                Map<String, Integer> countWordsMap = new HashMap<>();

                for(int i = 0; i < subStr.length(); i += wordLen){
                    String word = subStr.substring(i, i + wordLen);
                    countWordsMap.put(word, countWordsMap.getOrDefault(word, 0) + 1);
                    //如果超過既有的數量就是確定錯了
                    if(countWordsMap.get(word) > wordsMap.getOrDefault(word, 0)) return false;
                }
                return countWordsMap.equals(wordsMap);
            }
        }
    }
}
