/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

/**
 *
 * @author nvravicharan
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    boolean isSelected = false;
    boolean alarmIsSet = false;
    int alarm_hrs;
    int alarm_min;
    int alarm_sec;
    String amPm;
    
    public NewJFrame() {
        initComponents(); 
        choice1.add("America/Los_Angeles");
        //choice1.add("America/Los_Angeles");
        choice1.add("Asia/Colombo");
        choice1.add("Canada/Central");
        choice1.add("Egypt");
        choice1.add("Europe/Berlin");
        choice1.add("Greenwich");
        choice1.add("IST");
        choice1.add("Japan");
        
        
        System.out.println("Check - 1");
        new Thread(){
            
            public void run() {
                //clock.setText("23:22:22 A.M");
                while(true) {                   
                   Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(choice1.getItem(choice1.getSelectedIndex())));
                   int hour = cal.get(Calendar.HOUR);
                   int min = cal.get(Calendar.MINUTE);
                   int sec = cal.get(Calendar.SECOND);
                   int AM_PM = cal.get(Calendar.AM_PM);
                   String time="";
                  //System.out.println(time);
                   if(jRadioButton1.isSelected()) {
                       isSelected = true;
                       if(AM_PM == 1)
                           hour = hour+12;                               
                       if(hour<=9) 
                           time = "0"+hour+":";  
                       else 
                           time = hour+":";
                       if(min<=9)
                           time = time+"0"+min+":";
                       else 
                           time = time+min+":";
                       if(sec<=9)
                           time = time+"0"+sec+" ";
                       else
                           time = time+sec+" ";
                       clock.setText(time);
                   }                      
                   else {
                       isSelected = false;
                       if(hour<=9) 
                           time = "0"+hour+":";
                       else 
                           time = hour+":";
                       if(min<=9)
                           time = time+"0"+min+":";
                       else 
                           time = time+min+":";
                       if(sec<=9)
                           time = time+"0"+sec+" ";
                       else
                           time = time+sec+" ";
                       if(AM_PM == 1) 
                           time = time+"P.M";
                       else 
                           time = time + "A.M";
                       clock.setText(time);
                   }         
                }    
            }
        }.start();
    }
    
    public NewJFrame(boolean tempIsSelected,int tempHrs,int tempMin,int tempSec,String tempAmPm) {
        alarmIsSet = true;
        isSelected = tempIsSelected;
        alarm_hrs = tempHrs;
        alarm_min = tempMin;
        alarm_sec = tempSec;
        amPm = tempAmPm;
        
        int alarm_hrs24,alarm_min24,alarm_sec24;
        int alarm_hrs12,alarm_min12,alarm_sec12;
        
        if(amPm.compareTo("") == 0) {
            // 24 hr format
           alarm_hrs24 = alarm_hrs;
           alarm_min24 = alarm_min;
           alarm_sec24 = alarm_sec;
           alarm_min12 = alarm_min;
           alarm_sec12 = alarm_sec;
           if(alarm_hrs24 >= 12) {
               amPm = "P.M";
               if(alarm_hrs24 == 12) 
                   alarm_hrs12 = 12;
               else
                   alarm_hrs12 = alarm_hrs24 - 12;                   
           }
           else {
               amPm = "AM";
               if(alarm_hrs24 == 0) 
                   alarm_hrs12 = 12;
               else 
                   alarm_hrs12 = alarm_hrs24;
           }       
        }
        else {
            alarm_hrs12 = alarm_hrs;
            alarm_min12 = alarm_min;
            alarm_sec12 = alarm_sec;
            alarm_min24 = alarm_min;
            alarm_sec24 = alarm_sec;
            if(amPm.compareTo("A.M") == 0) {
                alarm_hrs24 = alarm_hrs12;
                if(alarm_hrs12 == 12) 
                    alarm_hrs24 = 0;
            }
            else {
                alarm_hrs24 = alarm_hrs12 + 12;
                if(alarm_hrs12 == 12) 
                    alarm_hrs24 = 12;
            }
                
        }
        
        System.out.println("alarm set for 24hrs at " +alarm_hrs24+" "+alarm_min24+" "+alarm_sec24);
        System.out.println("alarm set for 12hrs at " +alarm_hrs12+" "+alarm_min12+" "+alarm_sec12 +""+amPm);
        
        initComponents(); 
        choice1.add("America/Los_Angeles");
        //choice1.add("America/Los_Angeles");
        choice1.add("Asia/Colombo");
        choice1.add("Canada/Central");
        choice1.add("Egypt");
        choice1.add("Europe/Berlin");
        choice1.add("Greenwich");
        choice1.add("IST");
        choice1.add("Japan");
        
        System.out.println(isSelected);
        if(isSelected)
            jRadioButton1.setSelected(true);
            
        // Thread 1 
        new Thread(){
            public void run() {
                //clock.setText("23:22:22 A.M");
                while(true) {                   
                   Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(choice1.getItem(choice1.getSelectedIndex())));
                   int hour = cal.get(Calendar.HOUR);
                   int min = cal.get(Calendar.MINUTE);
                   int sec = cal.get(Calendar.SECOND);
                   int AM_PM = cal.get(Calendar.AM_PM);
                   String time="";
                  //System.out.println(time);
                   if(jRadioButton1.isSelected()) {
                       isSelected = true;
                       if(AM_PM == 1 && hour > 12)
                           hour = hour+12;                               
                       if(hour<=9) 
                           time = "0"+hour+":";  
                       else 
                           time = hour+":";
                       if(min<=9)
                           time = time+"0"+min+":";
                       else 
                           time = time+min+":";
                       if(sec<=9)
                           time = time+"0"+sec+" ";
                       else
                           time = time+sec+" ";
                       clock.setText(time);
                   }                      
                   else {
                       isSelected = false;
                       if(hour<=9) 
                           time = "0"+hour+":";
                       else 
                           time = hour+":";
                       if(min<=9)
                           time = time+"0"+min+":";
                       else 
                           time = time+min+":";
                       if(sec<=9)
                           time = time+"0"+sec+" ";
                       else
                           time = time+sec+" ";
                       if(AM_PM == 1) 
                           time = time+"P.M";
                       else 
                           time = time + "A.M";
                       clock.setText(time);
                   }         
                }    
            }
        }.start();
        
        // Thread2 Alarm Thread 
        new Thread() {
            public void run() {
                while(true) {
                    
                    Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(choice1.getItem(choice1.getSelectedIndex())));
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    
                    if(alarmIsSet) {
                        if(isSelected) {
                            
                        }
                        else {
                            
                        }
                        
                    }
                }          
            }
        }.start();
        
        
    }

    /**
     * 
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        choice1 = new java.awt.Choice();
        clock = new javax.swing.JLabel();
        setAlarm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 63)); // NOI18N

        jRadioButton1.setText("Set 24 hr format");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        clock.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock.setText("wd");
        clock.setToolTipText("");
        clock.setAutoscrolls(true);

        setAlarm.setText("Set Alarm");
        setAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAlarmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(setAlarm)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jRadioButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(setAlarm)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void setAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAlarmActionPerformed
        // TODO add your handling code here:
        AlarmFrame alarm = new AlarmFrame(isSelected);
        alarm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_setAlarmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JButton setAlarm;
    // End of variables declaration//GEN-END:variables
}
