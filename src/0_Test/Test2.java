import java.util.HashSet;
import java.util.Set;

public class Test2 {


    public static void main(String[] args){

        int check = 16;
        System.out.println(factors2(check));

    }

    private static int factors2(int checkNum){
        while(checkNum % 2 == 0){
            checkNum /= 2;
        }
        return checkNum;
    }
}
