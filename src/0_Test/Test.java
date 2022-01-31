import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args){

        int[] ints = {1,1,1,6,3,3,3};
        int x = 0;
        for(int i = 0;i < 3; i++){
            x = x ^ ints[i];
            System.out.println(x);
        }

    }



}
