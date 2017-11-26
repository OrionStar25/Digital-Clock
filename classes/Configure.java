package clock;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;


public class Configure {
    
    Color get_background(JMenuItem j)
    {
        return JColorChooser.showDialog(j,"Select a color",Color.CYAN);
    }

    Color get_text(JMenuItem j) {
        return JColorChooser.showDialog(j,"Select a color",Color.CYAN);
    }

    Color get_frame(JMenuItem j) {
        return JColorChooser.showDialog(j,"Select a color",Color.CYAN);
    }
    
    
}
