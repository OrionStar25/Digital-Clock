package clock;

import javax.swing.JLabel;

public class stopwatch_backend {
    Runnable timer;
    private int hour,minute,second;
    private String time;
    
    stopwatch_backend(JLabel watch)
    {
        hour = 0;
        minute = 0;
        second = 0;
        time = "";
        
        timer = new Runnable() {
        public void run() {
            watch.setText(getTime());
            time = "";
        }
    };
    }
    
    String getTime()
    {
        second++;
        if(second == 60)
        {
            second = 0;
            minute++;
            if(minute == 60)
            {
                minute = 0;
                hour++;
            }
        }
        
        if(hour < 10)
        {
            time += "0" + hour + ":";
        }
        else
        {
            time += hour + ":";
        }
        if(minute < 10)
        {
            time += "0" + minute + ":";
        }
        else
        {
            time += minute +":";
        }
        if(second < 10)
        {
            time += "0" + second;
        }
        else
        {
            time += second;
        }
        
        return time;
    }
    
    void reset()
    {
        hour = 0;
        minute = 0;
        second = 0;
    }
    
}