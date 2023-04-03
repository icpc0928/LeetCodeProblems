import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N290_WordPattern {
    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strArr = s.split(" ");
            Map<String, String> patternMap = new HashMap<>();   //
            Set<String> strSet = new HashSet<>();
            int setSize = 0;
            if(pattern.length() != strArr.length) return false;
            for(int i = 0; i < strArr.length; i++){
                String p = String.valueOf(pattern.charAt(i));
                if(patternMap.containsKey(p)){
                    if(!patternMap.get(p).equals(strArr[i])) return false;
                } else{
                    patternMap.put(p, strArr[i]);
                    strSet.add(strArr[i]);
                    if(strSet.size() != setSize + 1){
                        return false;
                    }else setSize = strSet.size();

                }
            }
            return true;
        }
    }

}
