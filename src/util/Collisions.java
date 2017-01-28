package util;

import java.awt.*;

/**
 * Created by mahonbd
 */
public class Collisions {
    public static boolean rectCollision(Rectangle r1, Rectangle r2) {
        return !(r2.x > r1.x + r1.width || r2.y > r1.y + r1.height || r2.x + r2.width < r1.x || r2.y + r2.height < r1.y);
    }

    public static boolean pointRectCollision(Point p, Rectangle rect){
        return p.x>=rect.x&&p.x<=rect.x+rect.width&&p.y>=rect.y&&p.y<=rect.y+rect.height;
    }
    //TODO: pointCircleCollision
    public static boolean pointCircleCollision(Point p, Point circle, int radius){
        return false;
    }
    //TODO: circleCircleCollision
}
