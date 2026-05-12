import java.awt.*;
import java.awt.event.*;
public class Experiment3 {
    Frame f1, f2; TextField name; TextField tf[] = new TextField[5];
    String sub[] = {"Marathi","Hindi","English","Maths","Science"};
    Experiment3() {
        f1 = new Frame("Student Result");
        f1.setLayout(new GridLayout(7,2,10,10));        f1.setSize(300,300);
        f1.add(new Label("Name:")); name = new TextField(); f1.add(name);
        for(int i=0;i<5;i++){
            f1.add(new Label(sub[i] + ":"));   tf[i] = new TextField(); f1.add(tf[i]);
        }
        Button b = new Button("Submit");  f1.add(new Label(""));     f1.add(b);
         f1.setVisible(true);
        f1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                f1.dispose();
            }
        });
        b.addActionListener(e -> {
            f2 = new Frame("Result");   f2.setLayout(new GridLayout(9,1));  f2.setSize(250,300);
            f2.add(new Label("Result of: " + name.getText()));
            try {
                int sum = 0;
                for(int i=0;i<5;i++){
                    int m = Integer.parseInt(tf[i].getText());
                    if(m < 0 || m > 100){
                        throw new Exception();   // invalid marks
                    }
                    sum += m;
                    f2.add(new Label(sub[i] + ": " + m));
                }
                float per = sum / 5.0f;
                f2.add(new Label("Total: " + sum));
                f2.add(new Label("Percentage: " + per));
                f2.add(new Label("Result: " + (per >= 35 ? "PASS" : "FAIL")));
            } catch(Exception ex){
                f2.add(new Label("Invalid Input!"));
            }
            f2.setVisible(true);
            f2.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    f2.dispose();
                }
            });
        });
    }

    public static void main(String[] args) {
        new Experiment3();
    }
}
