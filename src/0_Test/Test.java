import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] arrays = {0,1,23,52,56,99,123};

        int ans = Arrays.binarySearch(arrays, 124);
        System.out.println(ans);
    }
}
