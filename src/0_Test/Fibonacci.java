public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(get(92));
//        System.out.println(get2(93));
    }

    private static final int MAX_N = 92;

    public static long get(int n){
        if(n < 0 || n > MAX_N) throw new RuntimeException();
        if(n <= 1) return n;

        long[] tempArr = new long[n + 1];
        tempArr[1] = 1;
        for(int i = 2; i <= n; i++){
            tempArr[i] = tempArr[i-1] + tempArr[i-2];
//            if(tempArr[i] > Integer.MAX_VALUE) {
//                System.out.println(i);
//                System.out.println(tempArr[i -1]);
//                break;
//            }
        }
        return tempArr[n];
    }
    public static long get2(int n){
        if(n < 0) throw new RuntimeException();
        if(n <= 1) return n;
        return get2(n -1) + get2(n -2);
    }
}
