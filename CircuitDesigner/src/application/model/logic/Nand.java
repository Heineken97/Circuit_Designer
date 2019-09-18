package application.model.logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import application.controller.Mouse;
import application.model.Component;
import application.model.Conexion;
import application.model.logicShape.AndShape;
import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.logicGate.Primitives;


public class Nand extends Component {
	private Color shapeColor = Color.DARK_GRAY;
    private Rectangle rectShape;
    private Ellipse2D.Double ellipseShape;
    private Area shaped;
    private int height = 60;
    private int width = 60;
    private Boolean state = false;
    private static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public Nand(int x, int y) {
        this(x, y, 2);
    }

    public Nand(int x, int y, int n) {
    	this.setGateInputs(n);
        this.setX(x);
        this.setY(y);
        setShaped(new AndShape(x, y));
        shaped.add(new Area(new Ellipse2D.Double(x + getWidth(), y - 5 + getWidth() / 2, 10, 10)));
        outConexion.add(new Conexion(x + getWidth() + 10, y + (getHeight() / 2), Types.Orientation.Horizontal, Types.IO.Output, this));
        int gap = height / (n + 1);
        int yt = y;
        for (int i = 0; i < n; i++) {
            yt += gap;
            inConexion.add(new Conexion(x, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
    }

    public Area getShaped() {
        return shaped;
    }
	public void setShaped(Area shaped) {
		this.shaped = shaped;
	}

	public Color getShapeColor() {
        return shapeColor;
    }

    public synchronized Boolean getState() {
        Thread stateUpdater = new Thread() {
            public void run() {
                updateState();
            }
        };
        try {
            return state;
        } finally {
            stateUpdater.start();
        }
    }

    public void updateState() {
        state = Primitives.NAND(inConexion);
    }
    public Rectangle getBounds(){
        return new Rectangle(getX()-getPadding(),getY()-getPadding(),getWidth()+2*getPadding(),getHeight()+2*getPadding());
    }
    
    public void draw(Graphics2D g2d) {
        if (getBounds().contains(Mouse.getDeleteLocation())) {
            delete();
        }
        g2d.translate(getTx(), getTy());
        drawConexion(g2d);
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shaped);
//        g2d.translate(0, 0);
    }

    public void delete() {
        System.out.println("Delete");
        Component.drawable.remove(this);
    }

    public String getName() {
        return "NAND - " + getGateInputs();
    }

	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}
