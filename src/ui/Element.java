package ui;


import java.awt.*;

abstract class Element {
    Point screenPosition;
    Point dimensions;
    Element(Point screenPosition, Point dimensions){
        this.screenPosition = screenPosition;
        this.dimensions = dimensions;
    }
}
