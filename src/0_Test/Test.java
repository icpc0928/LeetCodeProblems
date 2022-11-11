import java.util.*;

public class Test {


    public static void main(String[] args){



        int[] nums = {1,2,3,4,5,6,1,8,9,7,};
        System.out.println(solution(nums));

    }


    //1億個數 其中兩個數重複 找出來
    public static int solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            if(set.size() == i){
                return nums[i];
            }
        }
        return -1;
    }





}
