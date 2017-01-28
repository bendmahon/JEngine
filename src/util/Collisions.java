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

    public static boolean pointCircleCollision(Point p, Point circle, int radius){
        return distanceFormula(p, new Point(circle.x + radius, circle.y + radius)) <= radius;
    }

    public static boolean circleCircleCollision(Point circle1, Point circle2, int r1, int r2){
        return distanceFormula(new Point(circle1.x + r1, circle1.y + r1), new Point(circle2.x + r2, circle2.y + r2)) < r1 + r2;
    }

    private static int distanceFormula(Point p, Point p2){
        double dist = Math.sqrt(Math.pow(p2.x - p.x , 2)+ Math.pow(p2.y - p.y, 2));
        return (int) dist;
    }
}
