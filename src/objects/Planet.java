package objects;


import core.Main;
import util.Collisions;

import java.awt.*;

public class Planet extends Entity{
    public double atmosphere;
    public double temperature;
    public int radius;
    public Planet(Point position, int radius, Point velocity, double atmosphere, double temperature){
        super(position, velocity);
        this.temperature = temperature;
        this.atmosphere = atmosphere;
        this.radius = radius;
    }
    @Override
    public void render(Graphics2D g) {
        g.setPaint(new Color(200, 70, 0));
        g.fillOval(position.x, position.y, radius*2, radius*2);
    }

    @Override
    public void tick() {
        if(Collisions.pointCircleCollision(Main.mousePos, new Point(position.x+radius, position.y+radius), radius)){

        }
        this.temperature += 0.002;
        this.atmosphere -= 0.002;
        //Check values to make sure they are valid
        if(this.temperature < 0) this.temperature = 0;
        if(this.atmosphere < 0) this.atmosphere = 0;
        if(this.temperature > 1) this.temperature = 1;
        if(this.atmosphere > 1) this.atmosphere= 1;
    }


}
