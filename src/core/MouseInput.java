package core;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInput extends MouseInputAdapter implements MouseMotionListener{
    public int x;
    public int y;
    boolean pressed;
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        System.out.println(String.format("Mouse pressed at x: %s, y: %s", x, y));
        pressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(String.format("Mouse released at x: %s, y: %s", e.getX(), e.getY()));
        Main.updateMouse(new Point(e.getX(), e.getY()));
    }
}
