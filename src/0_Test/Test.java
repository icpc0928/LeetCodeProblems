import java.util.Arrays;

public class Test {
    public static void main(String[] args){

//        int[] a = {1,1,2,2,3,3,3,4,4,5,5,5,};
//        int b = Arrays.binarySearch(a, 0);
//        System.out.println(b);

        String[] lineTotalBet = {"1000", "1500", "10000", "15050", "10500","10"};

        String[] lineTotalBetKilo = fun1(lineTotalBet);
        for(int i = 0; i < lineTotalBetKilo.length; i++){
            System.out.println(lineTotalBetKilo[i] + ",");
        }

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


    public static String[] fun1(String[] lineTotalBet){
        String[] lineTotalBetKilo = new String[lineTotalBet.length];
        for(int i = 0; i < lineTotalBet.length; i++){
            StringBuilder sb = new StringBuilder(lineTotalBet[i]);
            if(lineTotalBet[i].length() < 4){
                lineTotalBetKilo[i] = lineTotalBet[i];
                continue;
            }

            sb.insert(sb.length() - 3, ".");
            //去除小數點後不必要的'0' ,如果都是'0'連同小數點也去除
            for(int j = sb.length() - 1; j >= sb.length() - 4; j-- ){
               if(sb.charAt(j) == '0' || sb.charAt(j) == '.'){
                   sb.deleteCharAt(j);
               }else break;
            }

            //最後加上"K"
            sb.append("K");
            lineTotalBetKilo[i] = sb.toString();
        }
        return lineTotalBetKilo;
    }
}
