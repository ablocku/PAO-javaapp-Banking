package bin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

    private static Log ins;
    private BufferedWriter bfdr; // imi pare rau pentru acest nume dar imi merge greu 'w'

    public static Log getLog(){
        try{
            if(ins == null){
                ins = new Log();
                ins.bfdr = new BufferedWriter(new FileWriter("logs.txt"));
            }
        }
        catch (IOException err){
            System.out.println("Something went wrong while writing the log file. Error code: " + err.getMessage());
        }
        return ins;
    }

    public void switchFile(String file){
        try{
            bfdr.close();
            bfdr =  new BufferedWriter(new FileWriter(file));
        }
        catch (IOException err){
            System.out.println("Could not change the log file. Error code: " + err.getMessage());
        }
    }

    public void time(String log){
        try{
            String s = (new Date(System.currentTimeMillis())).toString() + "->" + log + '\n';
            bfdr.write(s);
        }
        catch (IOException err){
            System.out.println("Could not log properly. Error code: " + err.getMessage());
        }
    }

    public void end(){
        try{
            bfdr.close();
        }
        catch (IOException err){
            System.out.println("Error code: " + err.getMessage());
        }
    }
}
