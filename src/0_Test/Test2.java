import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Test2 {


    public static void main(String[] args){



        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar cal = Calendar.getInstance();
        if(calendar.get(Calendar.HOUR_OF_DAY ) < 8){
            calendar.add(Calendar.DAY_OF_YEAR, -1);
        }
        cal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 8, 0, 0);

        int pageNum = 5;
        System.out.println(getPageNumByOpenTime(pageNum, cal));

    }

    private static int factors2(int checkNum){
        while(checkNum % 2 == 0){
            checkNum /= 2;
        }
        return checkNum;
    }


    public static int getPageNumByOpenTime(int clientPageNum, Calendar date){
        if(true){
            int dayOfWeek = date.get(Calendar.DAY_OF_WEEK) - 1; //今天星期幾 (日=1 三=4 六=7)
            System.out.println("TODAY: " + dayOfWeek);
            int resultDay = (dayOfWeek + Calendar.DAY_OF_WEEK - clientPageNum) % 7 + 1; //前端要查的開獎日
            System.out.println("ResultDay: " + resultDay);
            if(resultDay % 3 == 1){ //前端要查的日子是否是 日|三|六 , 實際開獎日 = 1|4|7 %3 剛好都是1
                if(resultDay == 1) clientPageNum += 1;
                else clientPageNum += 3;
            }
        }


        return clientPageNum;
    }
}
