

import java.awt.*;
import java.awt.event.*;

public class AJP3 extends Frame implements ActionListener {
    Label l1, l2, l3, l4, l5;
    TextField t1, t2, t3, t4, t5;
    Button btn;

    public AJP3() {
        setTitle("Student Marks Entry");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        
        l1 = new Label("Subject 1:");
        l2 = new Label("Subject 2:");
        l3 = new Label("Subject 3:");
        l4 = new Label("Subject 4:");
        l5 = new Label("Subject 5:");
        
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        
        btn = new Button("Show Result");
        
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(l5); add(t5);
        add(new Label(""));
        add(btn);
        
        btn.addActionListener(this);
        
        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int m1 = Integer.parseInt(t1.getText());
        int m2 = Integer.parseInt(t2.getText());
        int m3 = Integer.parseInt(t3.getText());
        int m4 = Integer.parseInt(t4.getText());
        int m5 = Integer.parseInt(t5.getText());
        
        int total = m1 + m2 + m3 + m4 + m5;
        double percentage = total / 5.0;
        String result;
        
        if (m1 < 35 || m2 < 35 || m3 < 35 || m4 < 35 || m5 < 35) {
            result = "FAIL";
        } else {
            result = "PASS";
        }
        
        // Create new window for result
        Frame resultFrame = new Frame("Result");
        resultFrame.setSize(300, 200);
        resultFrame.setLayout(new GridLayout(3, 1));
        
        Label totalLabel = new Label("Total Marks: " + total);
        Label percentLabel = new Label("Percentage: " + percentage);
        Label resultLabel = new Label("Result: " + result);
        
        resultFrame.add(totalLabel);
        resultFrame.add(percentLabel);
        resultFrame.add(resultLabel);
        resultFrame.setVisible(true);
        
        // Close result window
        resultFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                resultFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new AJP3();
    }
}
