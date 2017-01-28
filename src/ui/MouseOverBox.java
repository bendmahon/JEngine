package ui;

import java.awt.*;

import static core.Main.backgroundColor;
import static core.Main.mouse;

/**
 * Created by mahonbd on 1/28/2017.
 */
public class MouseOverBox extends Element {
    public MouseOverBox(Point screenPosition, Point dimensions, String label){
        super(screenPosition, dimensions, label);
    }
    public void tick(){

    }
    public void render(Graphics2D g){
        g.setColor(backgroundColor);
//        g.fillRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y);
        g.fillRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
        g.setColor(Color.white);
//        g.drawRect(screenPosition.x, screenPosition.y, dimensions.x, dimensions.y);
        g.drawRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
    }
}
