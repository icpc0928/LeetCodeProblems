import java.util.HashSet;
import java.util.Set;

public class Test2 {


    public static void main(String[] args){

        String word = "abc";

        String s = "abcabcabc";

        String subStr = s.substring(s.length() - word.length());
        System.out.println(subStr);

    }

}
