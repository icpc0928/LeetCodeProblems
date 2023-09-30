import java.util.HashMap;

public class N860_LemonadeChange {


    class Solution {
        public boolean lemonadeChange(int[] bills) {
            HashMap<Integer, Integer> changeMap = new HashMap<>();
            changeMap.put(5, 0);
            changeMap.put(10, 0);

            for (int bill : bills) {
                if (bill == 5) {
                    changeMap.put(5, changeMap.get(5) + 1);
                } else if (bill == 10) {
                    changeMap.put(10, changeMap.get(10) + 1);
                    int c5 = changeMap.get(5);
                    if (c5 == 0) {
                        return false;
                    } else {
                        changeMap.put(5, c5 - 1);
                    }
                } else {
                    int c5 = changeMap.get(5);
                    int c10 = changeMap.get(10);
                    if (c10 > 0 && c5 > 0) {
                        changeMap.put(5, c5 - 1);
                        changeMap.put(10, c10 - 1);
                    } else if (c5 >= 3) {
                        changeMap.put(5, c5 - 3);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
