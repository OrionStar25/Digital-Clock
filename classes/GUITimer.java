package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GUITimer extends JFrame implements ItemListener {

    private static final long serialVersionUID = 5924880907001755076L;

    JLabel jltime;
    JLabel jl;
    JComboBox<Integer> jcb;
    JButton jbt;
    JButton jbt2;
    NumberFormat format;

    public Timer timer;
    public long initial;
    public long ttime2;
    public String ttime;
    public long remaining;

    public GUITimer() {

        JPanel timePanel = new JPanel();
        timePanel.setForeground(Color.BLACK);

        jltime = new JLabel("00:00");
        jltime.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        jltime.setForeground(Color.BLUE);
        jltime.setBackground(Color.BLACK);
        jltime.setOpaque(true);
        jltime.setFont(new Font("DS-Digital", Font.BOLD, 96));

        timePanel.add(jltime);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new FlowLayout());

        jl = new JLabel("TOTAL TIME (minutes):");
        jp1.add(jl);

        jcb = new JComboBox<Integer>();
        for (int i = 59; i > 0; i--) {
            jcb.addItem(Integer.valueOf(i));
        }
        jcb.setSelectedIndex(0);
        ttime = "59";
        jp1.add(jcb);

        jbt = new JButton("START");
        jp1.add(jbt);

        jbt2 = new JButton("RESET");
        jp1.add(jbt2);

        getContentPane().add(jp1, BorderLayout.NORTH);
        getContentPane().add(timePanel, BorderLayout.CENTER);

        Event e = new Event();
        jbt.addActionListener(e);
        jbt2.addActionListener(e);

        jcb.addItemListener(this);

        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Timer");
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUITimer();
            }

        });
    }

    // this method will run when user presses the start button
    void updateDisplay() {

        Timeclass tc = new Timeclass();
        timer = new Timer(1000, tc);
        initial = System.currentTimeMillis();
        timer.start();
    }

    // code for what happens when user presses the start or reset button
    public class Event implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String bname = e.getActionCommand();
            if (bname.equals("START")) {
                updateDisplay();
            } else {
                jltime.setText("00:00");
                timer.stop();
                remaining = convertTime();
            }
        }
    }

    // code that is invoked by swing timer for every second passed
    public class Timeclass implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            remaining = convertTime();
            long current = System.currentTimeMillis();
            long elapsed = current - initial;
            remaining -= elapsed;
            // initial = current;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remaining < 0)
                remaining = (long) 0;
            int minutes = (int) (remaining / 60000);
            int seconds = (int) ((remaining % 60000) / 1000);
            jltime.setText(format.format(minutes) + ":"
                    + format.format(seconds));

            if (remaining == 0) {
                jltime.setText("Stop");
                timer.stop();
            }
        }
    }

    // get the number of minutes chosen by the user and activate convertTime
    // method
    public void itemStateChanged(ItemEvent ie) {

        ttime = (String) jcb.getSelectedItem().toString();
    }

    // first need to convert no. of minutes from string to long.
    // then need to convert that to milliseconds.
    public long convertTime() {

        ttime2 = Long.parseLong(ttime);
        long converted = (ttime2 * 60000) + 1000;
        return converted;
    }
}