package application.model.logicShape;

import java.awt.Polygon;
import java.awt.geom.Area;

public class NotShape extends Area {
	int width = 50;
    int height = 25;
    Polygon triangle;
    int x, y;

    public NotShape(int x, int y) {
        this.x = x;
        this.y = y;
        triangle = new Polygon();
        triangle.addPoint(x + width, y + height);
        triangle.addPoint(x, y + 2 * height);
        triangle.addPoint(x, y);
        triangle.addPoint(x + width, y + height);
        this.add(new Area(triangle));
    }

}
