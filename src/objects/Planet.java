package objects;


import java.awt.*;

public class Planet extends Entity{
    public double atmosphere;
    public double temperature;
    public Planet(Point position, Point velocity, double atmosphere, double temperature){
        super(position, velocity);
        this.temperature = temperature;
        this.atmosphere = atmosphere;
    }
    @Override
    public void render(Graphics2D g) {
        g.setPaint(new Color(200, 70, 0));
        g.fillOval(position.x, position.y, 100, 100);
    }

    @Override
    public void tick() {
        this.temperature += 0.001;
        this.atmosphere -= 0.001;
        //Check values to make sure they are valid
        if(this.temperature < 0) this.temperature = 0;
        if(this.atmosphere < 0) this.atmosphere = 0;
        if(this.temperature > 1) this.temperature = 1;
        if(this.atmosphere > 1) this.atmosphere= 1;
    }


}
