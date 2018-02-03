package objects;



import ui.MouseOverBox;
import util.Collisions;

import java.awt.*;
import java.util.ArrayList;

import static core.Main.mouse;

public class Planet extends Entity{
    public double atmosphere;
    public double temperature;
    private int radius;
    public String name;
    private double maxTemp = 1000;
    private double minTemp = -250;
    public Planet(String name, double x, double y, double vx, double vy, double ax, double ay, double atmosphere, double temperature){
        super(x, y, vx, vy, ax, ay);
        this.name = name;
        this.temperature = temperature;
        this.atmosphere = atmosphere;
        this.radius = 50;
        mouseOverElement = new MouseOverBox(new Point((int) x+15, (int) y),
                new Point(100, 50), new ArrayList<String>());
    }
    @Override
    public void render(Graphics2D g) {
        g.setPaint(new Color(200, 70, 0));
        g.fillOval((int) x, (int) y, radius*2, radius*2);
        if(mouseOver) mouseOverElement.render(g);
    }

    @Override
    public void tick() {
        if(clicked){
            temperature = 0;
            atmosphere = 1;
        }
        this.temperature += 0.0002;
        this.atmosphere -= 0.002;
        //Constrain Planet data values
        if(this.temperature < 0) this.temperature = 0;
        if(this.atmosphere < 0) this.atmosphere = 0;
        if(this.temperature > 1) this.temperature = 1;
        if(this.atmosphere > 1) this.atmosphere = 1;

        if(mouseOverElement != null){
            mouseOverElement.text = new ArrayList<String>();
            mouseOverElement.text.add(name);
            mouseOverElement.text.add(String.format("%.4s", atmosphere));
            mouseOverElement.text.add(String.format("%.4s", tempScale(temperature)));
        }

        //motion physics
        vx += ax;
        vy += ay;
        x += vx;
        y += vy;
    }

    @Override
    public boolean mouseCollide(Point mousePos){
        return Collisions.pointCircleCollision(mouse.pos, new Point((int) x, (int) y), radius);
    }

    public double tempScale(double t){

        return t * (maxTemp-minTemp) + minTemp;
    }
}
