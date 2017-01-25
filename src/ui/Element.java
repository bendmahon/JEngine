package ui;


import java.awt.*;

abstract class Element {
    Point screenPosition;
    Point dimensions;
    String label;
    Element(Point screenPosition, Point dimensions, String label){
        this.screenPosition = screenPosition;
        this.dimensions = dimensions;
        this.label = label;
    }
}
