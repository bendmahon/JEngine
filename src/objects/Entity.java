package objects;

import java.awt.*;

abstract class Entity {
    Point position = new Point();
    Point velocity = new Point();
    Point acceleration = new Point();

    Entity(Point position, Point velocity, Point acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public abstract void tick();

    public abstract void render(Graphics2D g);
}