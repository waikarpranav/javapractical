

import java.awt.*;
import java.awt.event.*;

public class AJP02 extends Frame implements MouseListener {
    String msg = "";

    public AJP02() {
        setTitle("Mouse Event Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());
        addMouseListener(this);
        
        // Initially keep frame hidden
        setVisible(false);
        
        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        // Make frame visible when mouse enters screen area
        // Trick: show frame at start (small delay simulation)
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        msg = "Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")";
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        msg = "Mouse Entered Frame";
        setVisible(true); // Frame becomes visible when mouse enters
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        msg = "Mouse Exited Frame";
        repaint();
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void paint(Graphics g) {
        g.drawString(msg, 100, 150);
    }

    public static void main(String[] args) {
        new AJP02();
    }
}
