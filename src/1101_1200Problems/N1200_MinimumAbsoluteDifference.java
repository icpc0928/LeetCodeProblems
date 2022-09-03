import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1200_MinimumAbsoluteDifference {


    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            List<List<Integer>> result = new ArrayList<>();
            for(int i = 0; i < arr.length - 1; i++){
                int abs = arr[i + 1] - arr[i];
                if(abs < min){
                    min = abs;
                    result = new ArrayList<>();
                    List<Integer> element = new ArrayList<>();
                    element.add(arr[i]);
                    element.add(arr[i + 1]);
                    result.add(element);
                }else if(abs == min){
                    List<Integer> element = new ArrayList<>();
                    element.add(arr[i]);
                    element.add(arr[i + 1]);
                    result.add(element);
                }

            }
            return result;
        }
    }
}
