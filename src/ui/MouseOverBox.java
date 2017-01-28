package ui;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

/**
 * Created by mahonbd on 1/28/2017.
 */
public class MouseOverBox extends Element {
    public MouseOverBox(Point screenPosition, Point dimensions, String label){
        super(screenPosition, dimensions, label);
    }
    public void render(Graphics2D g){
        g.drawRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y );
    }
}
