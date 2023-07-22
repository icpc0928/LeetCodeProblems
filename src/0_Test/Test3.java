import java.text.SimpleDateFormat;
import java.util.*;

public class Test3 {


    public static void main(String[] args){

        Date d = new Date();
        var sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        var str = sdf.format(d);
        System.out.println(str);


//        int[] nums = new int[]{7,2,3,8,8,9,9,9,9,10,10,10,1,2,3,1,0,0,-1,-1,-1,-1,-1};
//        System.out.println(getResult(nums));
    }

    private static List<Integer> getResult(int[] nums){
        //      num      frequency
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        //      fq       nums
        TreeMap<Integer, TreeSet<Integer>> oppTreeMap = new TreeMap<>(Comparator.reverseOrder());
        for (int j : nums) {
            treeMap.put(j, treeMap.getOrDefault(j, 0) + 1);
        }

        for(Integer num : treeMap.keySet()){
            int fq = treeMap.get(num);
            TreeSet<Integer> treeSet = oppTreeMap.getOrDefault(fq, new TreeSet<>());
            treeSet.add(num);
            oppTreeMap.put(fq, treeSet);
        }
        List<Integer> result = new ArrayList<>();

        for(Integer fq : oppTreeMap.keySet()){
            result.addAll(oppTreeMap.get(fq).descendingSet());
        }

        return result;
    }
}
