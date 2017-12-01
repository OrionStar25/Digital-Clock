package clock;

import java.util.TimeZone;
import javax.swing.JComboBox;


public class Timezone {
    
    private String zoneId;
    
    Timezone(JComboBox t)
    {
        zoneId = (String)t.getSelectedItem();
    }
    
    TimeZone getTimeZone()
    {
        return TimeZone.getTimeZone(zoneId);
    }
}
