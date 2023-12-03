import java.util.TreeMap;

public class N1370_IncreasingDecreasingString {

    //給你一個字串s。使用以下演算法對字串重新排序：
    //
    //1.從中選擇最小的s字元並將其附加到結果中。
    //2.選擇大於結果中最後一個附加字元的最小字元並將其附加。s
    //3.重複步驟 2，直到無法選擇更多字元。
    //4.從中選擇最大的s字元並將其附加到結果中。
    //5.選擇比最後附加字元小的最大字元並將其附加到結果中。s
    //6.重複步驟 5，直到無法選擇更多字元。
    //7.重複步驟 1 到 6，直到選擇 中的所有字元s。
    //在每個步驟中，如果最小或最大字元出現多次，您可以選擇任意出現並將其附加到結果中。
    //
    //傳回用該演算法排序後的結果字串。s
    //1 <= s.length <= 500
    //s consists of only lowercase English letters.

    public static void main(String[] args) {
        String str = "aaaabbbbcccc";
        System.out.println((int)'a');

        Solution s = new Solution();

        System.out.println(s.sortString(str));
    }

    static class Solution {
        int[] ints = new int[26];
        public String sortString(String s) {
            //a for 97

            char[] chars = s.toCharArray();

            return getStringByArrays(chars);
        }

        private String getStringByArrays(char[] chars) {

            for (char aChar : chars) {
                ints[aChar - 97]++;
            }
            StringBuilder sb = new StringBuilder();

            do {
                //1.從中選擇最小的s字元並將其附加到結果中。
                step1(sb);
                //2.選擇大於結果中最後一個附加字元的最小字元並將其附加。s
                //3.重複步驟 2，直到無法選擇更多字元。
                step23(sb);
                //4.從中選擇最大的s字元並將其附加到結果中。
                step4(sb);
                //5.選擇比最後附加字元小的最大字元並將其附加到結果中。s
                //6.重複步驟 5，直到無法選擇更多字元。
                step56(sb);
            } while (!isIntsEmpty());
            return sb.toString();
        }

        private boolean isIntsEmpty() {
            for (int anInt : ints) {
                if (anInt > 0) return false;
            }
            return true;
        }

        private void step56(StringBuilder sb) {
            //5.選擇比最後附加字元小的最大字元並將其附加到結果中。s
            //6.重複步驟 5，直到無法選擇更多字元。
            while (true){
                int index = sb.charAt(sb.length() - 1) - 97;
                if(index - 1 < 0) return;
                for(int i = index - 1; i >= 0; i--){
                    if(ints[i] > 0){
                        sb.append(intToChar(i));
                        ints[i]--;
                        break;
                    }
                    if(i == 0){
                        return;
                    }
                }
            }
        }

        private void step4(StringBuilder sb) {
            for(int i = ints.length - 1; i >= 0; i--){
                if(ints[i] > 0){
                    sb.append(intToChar(i));
                    ints[i]--;
                    return;
                }
            }
        }

        private char intToChar(int i){
            return (char) (i + 97);
        }

        private void step1(StringBuilder sb){
            for(int i = 0; i < ints.length; i++){
                if(ints[i] > 0){
                    sb.append(intToChar(i));
                    ints[i]--;
                    return;
                }
            }
        }
        private void step23(StringBuilder sb){
            //2.選擇大於結果中最後一個附加字元的最小字元並將其附加。s
            //3.重複步驟 2，直到無法選擇更多字元。
            while (true){
                int index = sb.charAt(sb.length() - 1) - 97;
                if(index + 1 >= ints.length) return;
                for(int i = index + 1; i < ints.length; i++){
                    if(ints[i] > 0){
                        sb.append(intToChar(i));
                        ints[i]--;
                        break;
                    }
                    if(i == ints.length - 1){
                        return;
                    }
                }
            }
        }


    }
}
