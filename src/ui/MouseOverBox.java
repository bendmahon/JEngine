package ui;

import java.awt.*;

import static core.Main.backgroundColor;
import static core.Main.mouse;

public class MouseOverBox extends Element {
    private int mouseOffsetX = 15;
    private int mouseOffsetY = 0;
    private int textOffsetX = mouseOffsetX + 10;
    private int textOffsetY = 15;
    public MouseOverBox(Point screenPosition, Point dimensions, String label){
        super(screenPosition, dimensions, label);
    }
    public void tick(){

    }
    public void render(Graphics2D g){
        g.setColor(backgroundColor);
        g.fillRect(mouse.pos.x + mouseOffsetX, mouse.pos.y + mouseOffsetY, dimensions.x, dimensions.y);
//        g.fillRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
        g.setColor(Color.white);
        g.drawRect(mouse.pos.x + mouseOffsetX, mouse.pos.y, dimensions.x, dimensions.y);
        if(label != null) g.drawString(label, mouse.pos.x + textOffsetX, mouse.pos.y + textOffsetY);
//        g.drawRect(mouse.pos.x - dimensions.x/2, mouse.pos.y, dimensions.x, dimensions.y);
    }

    @Override
    public boolean mouseCollide(Point mousePos) {
        return false;
    }
}
