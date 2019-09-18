package application.model.logicShape;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class AndShape extends Area {

    private int width = 60;
    private int height = 60;
    private Rectangle rectShape;
    private Ellipse2D.Double ellipseShape;
    private int x;
    private int y;
    
    public AndShape(int x, int y) {
    	this.setX(x);
        this.setY(y);
        setEllipseShape(new Ellipse2D.Double(x, y, width, height));
        setRectShape(new Rectangle(x, y, width / 2, height));
        this.add(new Area(rectShape));
        this.add(new Area(ellipseShape));
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

	public Rectangle getRectShape() {
		return rectShape;
	}
	public Ellipse2D.Double getEllipseShape() {
		return ellipseShape;
	}

	public void setRectShape(Rectangle rectShape) {
		this.rectShape = rectShape;
	}

	public void setEllipseShape(Ellipse2D.Double ellipseShape) {
		this.ellipseShape = ellipseShape;
	}

}
