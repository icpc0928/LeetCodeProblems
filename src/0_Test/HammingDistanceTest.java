public class HammingDistanceTest {

    public static void main(String[] args) {

        int a = 1;
        int b = 4;

        int h = a ^ b;      //補馬
        System.out.println(h);

        String h1 = Integer.toBinaryString(h);//補馬的二禁制
        System.out.println(h1);
        System.out.println(getHammingD(h));

    }



    public static int getHammingD(int h){
        int result = 0;
        while (h != 0){
            int d = h /2;
            result += h - (d * 2);
            h /= 2;
        }
        return result;
    }
}
