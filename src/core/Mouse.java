package core;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Mouse extends MouseInputAdapter {
    public Point pos = new Point(-1, -1);
    public boolean clicked;

    public void mouseMoved(MouseEvent e){
//        System.out.println("She's movin'!");
        updatePos(e);
    }
    public void mousePressed(MouseEvent e) {
        updatePos(e);
        System.out.println(String.format("Mouse pressed at x: %s, y: %s", pos.y, pos.x));
        clicked = true;
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(String.format("Mouse released at x: %s, y: %s", e.getX(), e.getY()));
        updatePos(e);
        clicked = false;
    }
    private void updatePos(MouseEvent e){
        pos.x = e.getX();
        pos.y = e.getY();
    }
}
