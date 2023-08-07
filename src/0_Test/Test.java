import java.io.*;
import java.util.*;

public class Test {


    public static void main(String[] args) throws IOException {



        //TODO


        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        dir =dir + "/testDir/12345/";

        String classPath =  new Test().getCD();
        System.out.println("classPath: " + classPath);
        File folder = new File(dir);
        if(!folder.exists() && !folder.isDirectory()){
            folder.mkdirs();
        }
        String fileName = "12345.properties";
        File file = new File(dir + fileName);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception e){

            }
        }
        FileInputStream fis = new FileInputStream(dir + fileName);

        Properties pros = new Properties();

        pros.load(fis);
        fis.close();

        pros.setProperty("id", "123456");
        saveProp(pros, dir + fileName);
    }

    public static void saveProp(Properties prop, String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            prop.store(fos, null);
            fos.close();
        }catch (Exception e){

        }


    }

//    public class ST{
        String getCD(){
            return this.getClass().getClassLoader().getResource("").getPath();
        }
//    }



    //1億個數 其中兩個數重複 找出來
    public static int solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            if(set.size() == i){
                return nums[i];
            }
        }
        return -1;
    }





}
