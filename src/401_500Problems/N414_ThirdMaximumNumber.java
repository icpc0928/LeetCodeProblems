import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class N414_ThirdMaximumNumber {

    public static void main(String[] args) {

    }

    static class Solution {
        public int thirdMax(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num);
                //如果有第四個數-> 保持set為3個最大的數
                if(set.size() > 3){
                    set.remove(Collections.min(set));
                }
            }
            //最終回圈結束後 set內容物 要嘛3個要嘛小於3個 小於三個取最大,等於三個取最小
            if(set.size() < 3){
                return Collections.max(set);
            }else
                return Collections.min(set);
        }
    }
}
