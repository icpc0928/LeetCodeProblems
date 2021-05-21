import java.util.ArrayList;
import java.util.HashMap;

public class N06_ZigZagConversion {

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "ab";
        int numRows = 1;
        String output = solution.convert(s, numRows);
        System.out.println(output);

    }

    static class Solution {
        public String convert(String s, int numRows) {
            int addOrMin = 1;
            int counter = 1;
            StringBuilder ans = new StringBuilder();
            HashMap<Integer, String> hashMap = new HashMap<>();


            for(int i = 1; i <= numRows; i++){
                hashMap.put(i, "");
            }

            for(int i = 0; i < s.length(); i++){
                hashMap.put(counter, hashMap.get(counter) + s.charAt(i));

                //遞增階段
                if(counter < numRows && addOrMin == 1){
                    counter++;
                    if(counter == numRows)
                        addOrMin = -1;
                }
                //遞減階段
                else if(counter > 1 && addOrMin == -1){
                    counter --;
                    if(counter == 1)
                        addOrMin = 1;
                }
            }

            for(int i = 1; i <= numRows; i++)
                ans.append(hashMap.get(i));

            return ans.toString();
        }
    }


}
