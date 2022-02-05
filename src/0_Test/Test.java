import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args){

        Integer[] my = {2,4,6,8,10};
        System.out.println(find_total(my));


    }

    public static Integer find_total( Integer[] my_numbers ) {
        //Insert your code here
        int answer = 0;
        if(my_numbers == null){
            return answer;
        }
        for(int i = 0; i < my_numbers.length; i++){

            if(my_numbers[i] == 5){
                System.out.println("Hello2");
                answer += 5;
            }
            else if(my_numbers[i] % 2 == 0){
                System.out.println(my_numbers[i] % 2);
                answer += 1;
            }else{
                System.out.println("Hello");
                answer += 3;
            }
        }

        return answer;
    }



}
