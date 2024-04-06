import java.util.HashMap;
import java.util.Map;

public class Test7 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int a = 0;

        for(int i = 0; i < nums.length; i++){
            a ^= nums[i];
        }
        System.out.println(a);
        a = a ^ 3;
        System.out.println(a);
    }
}
