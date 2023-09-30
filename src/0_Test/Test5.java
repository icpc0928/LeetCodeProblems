import java.util.Arrays;
import java.util.Objects;

public class Test5 {

    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4};
//        int[] arr2 = {4,2,3,1};
//        int[] arr3 = {4,2,3,1};
//
////        int i = Arrays.hashCode(arr1);
////        int j = Arrays.hashCode(arr2);
////        int k = Arrays.hashCode(arr2);
////        System.out.println("I:" + i + ",  j: "+ j + ", k: " + k);
//
//        int[] testArr = new int[200];
//        for(int i = 0; i < testArr.length; i++){
//            testArr[i] = 100000;
//        }
//        int a = Arrays.hashCode(testArr);
//        System.out.println(a);
//        System.out.println(Arrays.equals(arr2, arr3));

        int[] h1 = {2,1};
        int[] h2 = {1,32};
        System.out.println(Arrays.equals(h1, h2));
        System.out.println(Objects.equals(h1, h2));
        //這兩個hashcode是一樣的
    }
}
