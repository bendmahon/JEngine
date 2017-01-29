package ui;

import java.awt.*;

import static core.Main.backgroundColor;
import static core.Main.mouse;

public class MouseOverBox extends Element {
    public MouseOverBox(Point screenPosition, Point dimensions, String label){
        super(screenPosition, dimensions, label);
    }
    public void tick(){

    }
    public void render(Graphics2D g){
        g.setColor(backgroundColor);
        g.fillRect(mouse.pos.x, mouse.pos.y - dimensions.y, dimensions.x, dimensions.y);
//        g.fillRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
        g.setColor(Color.white);
        g.drawRect(mouse.pos.x, mouse.pos.y - dimensions.y, dimensions.x, dimensions.y);
        if(label != null) g.drawString(label, mouse.pos.x + 5, mouse.pos.y - dimensions.y + 15);
//        g.drawRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
    }

    @Override
    public boolean mouseCollide(Point mousePos) {
        return false;
    }
}
