import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N599_MinimumIndexSumOfTwoLists {

    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < list1.length; i++){
                map.put(list1[i], i);
            }
            int min = Integer.MAX_VALUE;
            List<String> result = new ArrayList<>();
            for(int i = 0; i < list2.length; i++){
                if(map.containsKey(list2[i])){
                    int sum = i + map.get(list2[i]);
                    if(sum < min){
                        min = sum;
                        result.clear();
                        result.add(list2[i]);
                    }else if(sum == min){
                        result.add(list2[i]);
                    }
                }
            }
            return result.toArray(new String[0]);
        }
    }
}
