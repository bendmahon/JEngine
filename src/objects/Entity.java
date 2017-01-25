package objects;

import core.Main;

import java.awt.*;

public abstract class Entity {

    public boolean isSolid = true; //entity solid by default
    public Point position = new Point();
    public Point velocity = new Point();
    public Rectangle bounds;
    public Main game;//collision bounds

    public Entity(Point position, Point velocity){
        this.position = position;
        this.velocity = velocity;
    }

    public abstract void tick();

    public abstract void render(Graphics2D g);

//    public Point getPosition() {
//        return position;
//    }
//
//    public void setPosition(Point position) {
//        this.position = position;
//    }
//
//    public Point getVelocity() {
//        return velocity;
//    }
//
//    public void setVelocity(Point velocity) {
//        this.velocity = velocity;
//    }
}
