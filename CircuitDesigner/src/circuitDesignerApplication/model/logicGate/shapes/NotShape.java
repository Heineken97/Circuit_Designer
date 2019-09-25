package circuitDesignerApplication.model.logicGate.shapes;

import java.awt.Polygon;
import java.awt.geom.Area;

public class NotShape extends Area {
    private Polygon triangle;
    private int x, y;

    public NotShape(int x, int y) {
        this.x = x;
        this.y = y;
        triangle = new Polygon();
        triangle.addPoint(x + 50, y + 25);
        triangle.addPoint(x, y + 2 * 25);
        triangle.addPoint(x, y);
        triangle.addPoint(x + 50, y + 25);
        this.add(new Area(triangle));
    }

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

}
