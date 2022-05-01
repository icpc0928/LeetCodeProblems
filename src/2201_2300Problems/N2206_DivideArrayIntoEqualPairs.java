import java.util.HashSet;
import java.util.Set;

/**
 * Runtime: 9 ms, faster than 39.16% of Java online submissions for Divide Array Into Equal Pairs.
 * Memory Usage: 48.5 MB, less than 24.67% of Java online submissions for Divide Array Into Equal Pairs.
 */
public class N2206_DivideArrayIntoEqualPairs {


    public static void main(String[] args) {

    }

    static class Solution {
        public boolean divideArray(int[] nums) {

            Set<Integer> isElementsArePair = new HashSet<>();

            for(int i = 0; i < nums.length; i++){
                if(isElementsArePair.contains(nums[i])){
                    isElementsArePair.remove(nums[i]);
                }else{
                    isElementsArePair.add(nums[i]);
                }
            }
            return isElementsArePair.isEmpty();
        }
    }
}
