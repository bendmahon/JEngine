package objects;



import util.Collisions;

import java.awt.*;

import static core.Main.mouse;

public class Planet extends Entity{
    public double atmosphere;
    public double temperature;
    private int radius;
    public Planet(Point position, int radius, Point velocity, Point acceleration, double atmosphere, double temperature){
        super(position, velocity, acceleration);
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
        //UI Handling
//        System.out.println(mouse.pos);
//        if(mouse.clicked && Collisions.pointCircleCollision(mouse.pos, this.position, this.radius)){
//            temperature = 0;
//            atmosphere = 1;
////            mouse.pos = new Point(-1, -1);
//        }
        System.out.println(clicked);
        if(clicked){
            temperature = 0;
            atmosphere = 1;
        }
        if(!clicked && mouseOver) System.out.println("hover planet");
//        if(!mouse.clicked && Collisions.pointCircleCollision(mouse.pos, this.position, this.radius)){
//            System.out.println("Hover boys");
//        }
        this.temperature += 0.002;
        this.atmosphere -= 0.002;
        //Constrain Planet data values
        if(this.temperature < 0) this.temperature = 0;
        if(this.atmosphere < 0) this.atmosphere = 0;
        if(this.temperature > 1) this.temperature = 1;
        if(this.atmosphere > 1) this.atmosphere = 1;

        //motion physics
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        position.x += velocity.x;
        position.y += velocity.y;
    }

    @Override
    public boolean mouseCollide(Point mousePos){
        return Collisions.pointCircleCollision(mouse.pos, position, radius);
    }
}
