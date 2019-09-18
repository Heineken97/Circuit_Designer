package application.model.logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import application.controller.Mouse;
import application.model.Component;
import application.model.Conexion;
import application.model.logicShape.NotShape;
import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.logicGate.Primitives;

public class Not extends Component {

	private Color shapeColor = Color.gray;
    private Polygon triangle;
    private int bubbleDiameter = 10;
    private Ellipse2D.Double bubble;
    private Area shaped;
	private int height = 25;
    private int width = 50;
    private boolean state = false;
    private static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public Not(int x, int y) {
    	this.setX(x);
        this.setY(y);
        setShaped(new NotShape(x, y));
        setBubble(new Ellipse2D.Double(x + getWidth(), y + getWidth() - getBubbleDiameter() / 2, getBubbleDiameter(), getBubbleDiameter()));
        shaped.add(new Area(bubble));
        inConexion.add(new Conexion(x + getBubbleDiameter() - 8, y + getHeight(), Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        outConexion.add(new Conexion(x + getBubbleDiameter() + getWidth(), y + getHeight(), Types.Orientation.Horizontal, Types.IO.Output, this));
    }

	public Ellipse2D.Double getBubble() {
		return bubble;
	}
	public Area getShaped() {
		return shaped;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setBubble(Ellipse2D.Double bubble) {
		this.bubble = bubble;
	}
	public void setShaped(Area shaped) {
		this.shaped = shaped;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getBubbleDiameter() {
		return bubbleDiameter;
	}

	public void setBubbleDiameter(int bubbleDiameter) {
		this.bubbleDiameter = bubbleDiameter;
	}

    public Rectangle getBounds() {
        return new Rectangle(getX()-getPadding(),getX()-getPadding(),width+2*getPadding(),height+2*getPadding());
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public Boolean getState() {
        return Primitives.NOT(inConexion.get(0).getState());
    }

    public void draw(Graphics2D g2d) {
        if (getBounds().contains(Mouse.getDeleteLocation())) {
            delete();
        }
        g2d.translate(getTx(), getTy());
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shaped);
        drawConexion(g2d);
    }

    public void delete() {
        System.out.println("Deleter");
        Component.drawable.remove(this);
    }

    public String getName() {
        return "Not";
    }

}
