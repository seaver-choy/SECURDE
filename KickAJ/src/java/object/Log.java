package object;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private String log_id;
    private int account_id;
    private String type;
    private String details;
    private String time_stamp;
    
    //Log with account ID
    public Log(String log_id, int account_id, String type, String details, String time_stamp) {
        this.log_id = log_id;
        this.account_id = account_id;
        this.type = type;
        this.details = details;
        this.time_stamp = time_stamp;
    }
    
    //Log without account ID
    public Log(String log_id, String type, String details, String time_stamp) {
        this.log_id = log_id;
        this.type = type;
        this.details = details;
        this.time_stamp = time_stamp;
    }
    
    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
    
    public void writeLog(){
        try {
            String content = "This is the content to write into file";
            File file = new File("src/logs/" + this.log_id + ".txt");

            // if file doesnt exists, then create it
            if (!file.exists())
		file.createNewFile();
			
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Time Stamp: " + this.time_stamp + "\n" +
                     "Log ID: " + this.log_id + "\n" + 
                     "Log From: Account ID #" + this.account_id + "\n" +
                     "Log Type: " + this.type + "\n" + 
                     "Details: " + this.details + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
}
