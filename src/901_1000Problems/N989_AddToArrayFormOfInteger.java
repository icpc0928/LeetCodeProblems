import java.util.ArrayList;
import java.util.List;

public class N989_AddToArrayFormOfInteger {

    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> result = new ArrayList<>();
            int i = num.length -1;
            int tempJ = 0;
            while (k > 0 || i >= 0){
                int numI = 0;
                if(i >= 0){
                    numI = num[i];
                }
                int lastK = k % 10;
                int tempS = lastK + numI + tempJ;
                result.add(0, tempS % 10);

                tempJ = tempS / 10;

                k = k / 10;
                i--;
            }
            if(tempJ > 0){
                result.add(0, tempJ);
            }
            return result;
        }
    }
}
