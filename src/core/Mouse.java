package core;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Mouse extends MouseInputAdapter {
    public Point pos = new Point(-1, -1);
    public ArrayList<Clickable> mouseObservers = new ArrayList<>();
    public void resetClick(){
        notifyMouseObservers(false, false, false);
    }
    public void mouseMoved(MouseEvent e){
//        System.out.println("She's movin'!");
        updatePos(e);
        notifyMouseObservers(true, false, false);
    }
    public void mousePressed(MouseEvent e) {
        updatePos(e);
        System.out.println(String.format("Mouse pressed at x: %s, y: %s", pos.y, pos.x));
        notifyMouseObservers(false, true, false);
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println(String.format("Mouse released at x: %s, y: %s", e.getX(), e.getY()));
        updatePos(e);
        notifyMouseObservers(false, false, true);
    }
    private void updatePos(MouseEvent e){
        pos.x = e.getX();
        pos.y = e.getY();
    }
    private void notifyMouseObservers(boolean move, boolean press, boolean release){
        for(Clickable observer : mouseObservers){
            observer.clickNotify(new Point(pos.x, pos.y), move, press, release);
        }
    }
}
