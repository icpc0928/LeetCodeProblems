import java.util.HashMap;
import java.util.Map;

public class N409_LongestPalindrome {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(s.longestPalindrome(str));
    }


    static class Solution {
        public int longestPalindrome(String s) {
            Map<String, Integer> countMap = new HashMap<>();
            for(char c : s.toCharArray()){
                countMap.put(String.valueOf(c), countMap.getOrDefault(String.valueOf(c), 0) + 1);

            }

            System.out.println(countMap);
            int result = 0;
            boolean hasOdd = false;
            for(Integer value : countMap.values()){
                if (value % 2 == 0) {
                    result += value;
                }else{
                    result += value -1;
                    hasOdd = true;
                }
            }
            return result + (hasOdd ? 1 : 0);

        }
    }
}
