package objects;

import core.Clickable;

import java.awt.*;

import static core.Main.mouse;

public abstract class Entity implements Clickable{
    Point position = new Point();
    Point velocity = new Point();
    Point acceleration = new Point();
    public boolean mouseOver;
    public boolean pressed;
    public boolean clicked;
    Entity(Point position, Point velocity, Point acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        mouse.mouseObservers.add(this);
    }

    public abstract void tick();

    public abstract void render(Graphics2D g);
    public abstract boolean mouseCollide(Point mousePos);

    public void clickNotify(Point mousePos, boolean move, boolean press, boolean release) {
        if(move){
            mouseOver = mouseCollide(mousePos);
        }
        if(press){
            if(mouseCollide(mousePos)) pressed = true;
        }
        clicked = pressed && release && mouseCollide(mousePos);

        if(release){
            pressed = false;
        }
//        if(!release){
//            pressed = false;
//            clicked = false;
//        }

    }
}