public class N12_IntegerToRoman {
    //Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to Roman.
    //Memory Usage: 38.1 MB, less than 89.69% of Java online submissions for Integer to Roman.


    public static void main(String[] args){
        Solution solution = new Solution();
        int num = 3499;
        System.out.println(solution.intToRoman(num));
    }



    static class Solution {
        public String intToRoman(int num) {
            int[] numbers =   {1000, 900, 500, 400,  100,  90,  50,   40, 10,    9,  5,  4,   1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL","X", "IX","V","IV","I"};
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < numbers.length && num > 0; i++){
                while(num >= numbers[i]){
                    num -= numbers[i];
                    sb.append(romans[i]);
                }
            }
            return sb.toString();
        }
    }
}
