import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class N205_IsomorphicStrings {


    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<String, String> isoMap = new HashMap<>();
            Set<String> tSet = new HashSet<>();

            for(int i = 0; i < s.length(); i++){
                String sKey = String.valueOf(s.charAt(i));
                if(isoMap.containsKey(sKey)){
                    if(!isoMap.get(sKey).equals(String.valueOf(t.charAt(i)))){
                        return false;
                    }
                }else{
                    if(tSet.contains(String.valueOf(t.charAt(i)))) return false;
                    isoMap.put(String.valueOf(s.charAt(i)), String.valueOf(t.charAt(i)));
                    tSet.add(String.valueOf(t.charAt(i)));
                }
            }
            return true;
        }
    }
}
