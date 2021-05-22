import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        test1(new String[] {"a", "b", "c","d"});
        test2("a", "b", "c", "d");

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
