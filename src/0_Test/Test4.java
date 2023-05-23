import java.util.*;

public class Test4 {

    static int totalBalls = 36; //總共36顆;

    public static void main(String[] args){


        int choose = 10; //選10顆

        //列出所有選擇
//        long totalCom = factorial(choose, 1);
//        Map<String, int[]> resultMap = new HashMap<>();
//        List<String> resultList = new ArrayList<>(); //這是為了按照順序列印

        for(int i = 1; i <= choose; i++){
            for(int j = 1; j <= i; j++){
//                int[] getMAndN = new int[2];    //0:m 1:n
//                getMAndN[0] = i;
//                getMAndN[1] = j;
                String str = "選" + i + "中" + j;
//                resultMap.put(str, getMAndN);
//                resultList.add(str);
                double mathComb = getMathComb(choose, j, (i - j));
                System.out.println(str + ": " + mathComb);
            }
        }
//        System.out.println("resultList size: " + resultList.size());

    }


    /**
     * 實際數學公式  C36取(中+不中) / (C10取中的 * C36取不中的)  => 組合數
     * @param choose 10苛求
     * @param hit   中的
     * @param noHit 不中的
     * @return
     */
    private static double getMathComb(int choose, int hit, int noHit){
        long zeroComb;
//        if(noHit == 0)
//            zeroComb = 1;
//        else
            zeroComb = getComb(totalBalls, noHit);
        return  (double) getComb(totalBalls, (hit + noHit)) / (getComb(choose, hit) * zeroComb) ;
    }

    /**
     * c m 取 n
     * @param m m就是m
     * @param n n就是n
     * @return (m! / (m-n)!)/ n!
     */
    private static long getComb(int m, int n){
        if(n == 0) return 1;
//        System.out.println(factorial(m,n));
//        System.out.println(factorial(n,1));
        return factorial(m, (m - n + 1)) / factorial(n, 1);
    }

    /**
     * 階乘 0! = 1
     * @param m 回傳m!
     *
     * @return m! , m == 0 : return 1
     */
    private static long factorial(long m, long n){
        if(m == n){
            return m;
        }
        if(m <= 1){
            return 1;
        }else{
            return m * factorial(--m, n);
        }
    }





}
