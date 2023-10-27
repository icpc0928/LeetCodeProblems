import java.util.HashMap;
import java.util.Map;

public class N383_RansomNote {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if(ransomNote.length() > magazine.length()) return false;
            Map<String, Integer> magMap = new HashMap<>();

            for(int i = 0; i < magazine.length(); i++){
                String s = String.valueOf(magazine.charAt(i));
                magMap.put(s, magMap.getOrDefault(s, 0) + 1);
            }
            for(int i = 0; i < ransomNote.length(); i++){
                String s = String.valueOf(ransomNote.charAt(i));
                Integer count = magMap.getOrDefault(s, 0);
                if(count == 0) return false;
                magMap.put(s, --count);
            }
            return true;
        }

        public boolean canConstruct2(String ransomNote, String magazine) {
            for(int i = 0; i < ransomNote.length(); i++){
                String c = String.valueOf(ransomNote.charAt(i));

                if(magazine.contains(c)){
                    magazine = magazine.replaceFirst(c, "");
                }else{
                    return false;
                }
            }
            return true;
        }
        public boolean canConstruct3(String ransomNote, String magazine){
            if (ransomNote.length() > magazine.length()) return false;
            int[] alphabets_counter = new int[26];

            for (char c : magazine.toCharArray())
                alphabets_counter[c - 'a']++; //use ascii code 就會變成 index

            for (char c : ransomNote.toCharArray()){
                if (alphabets_counter[c-'a'] == 0) return false;
                alphabets_counter[c-'a']--;
            }
            return true;
        }
    }
}
