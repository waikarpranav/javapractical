import java.awt.*;
import java.awt.event.*;

public class KeyEventDemo extends Frame implements KeyListener {
    String msg = "";

    public KeyEventDemo() {
        setTitle("Key Event Demo");
        setSize(400, 200);
        setLayout(new FlowLayout());
        
        Label label = new Label("Press any key...");
        add(label);
        
        addKeyListener(this);
        setVisible(true);
        
        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void keyPressed(KeyEvent e) {
        msg = "Key Pressed: " + e.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        msg = "Key Released: " + e.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        msg = "Key Typed: " + e.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        new KeyEventDemo();
    }
}
