
import java.util.Calendar;
import javax.swing.JRadioButtonMenuItem;

public class Time {
    
    private int hour,minute,second,AM_PM,year,month,day;
    private String time;
    
    Time(Calendar cal)
    {
        hour = cal.get(Calendar.HOUR);
        minute = cal.get(Calendar.MINUTE);
        second = cal.get(Calendar.SECOND);
        AM_PM = cal.get(Calendar.AM_PM);
    }
    
    String setTime(JRadioButtonMenuItem _24,JRadioButtonMenuItem _12)
    {
        if(_24.isSelected() && AM_PM == 1) //24 hour clock display is selected
        {
            hour += 12;
        }
        if(hour < 10)
        {
            time = "0" + hour + ":";
        }
        else
        {
            time = hour + ":";
        }
                   
        if(minute < 10)
        {
            time = time + "0" + minute + ":";
        }
        else
        {
            time = time + minute + ":";
        }
                   
        if(second < 10)
        {
            time = time + "0" + second + " ";
        }
        else
        {
            time = time + second + " ";
        }
                    
        if(_12.isSelected()) //12 hour clock display is selected
        {
            switch(AM_PM)
            {
                case 0: time = time + "AM";
                        break;
                case 1: time = time + "PM";
                        break;
            }
        }
        
        return time;
    }
}
