import java.util.Arrays;

public class Test {
    public static void main(String[] args){

        int[] a = {1,1,2,2,3,3,3,4,4,5,5,5,};
        int b = Arrays.binarySearch(a, 0);
        System.out.println(b);

    }

    public static void test1(String[] args){
        System.out.println(args.getClass() == String[].class);
        for(String s : args){
            System.out.println(s);
        }
    }
    public static void test2(String... args){
        System.out.println(args.getClass() == String[].class);
        
        for(String s : args){
            System.out.println(s);
        }
    }

    public static void test3(Integer... hello){
        String args[] = new String[3];
    }
}
