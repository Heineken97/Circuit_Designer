package application.model.logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import application.controller.Mouse;
import application.model.Component;
import application.model.Conexion;
import application.model.logicShape.OrShape;
import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.logicGate.Primitives;

public class Or extends Component {
	private Color shapeColor = Color.DARK_GRAY;
    private Area shaped;
    private int height = 60;
    private int width = 60;
    private boolean state = false;
    private static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    
    public Or(int x, int y) {
        this(x, y, 2);
    }

    public Or(int x, int y, int n) {
    	setGateInputs(n);
        this.setX(x);
        this.setY(y);
        setShaped(new OrShape(x, y));

        outConexion.add(new Conexion(x + getWidth(), y + (getHeight() / 2), Types.Orientation.Horizontal, Types.IO.Output, this));
        int number = n;
        int gap = height / (number + 1);
        int yt = y;
        for (int i = 0; i < number; i++) {
            yt += gap;
            inConexion.add(new Conexion(x + 5, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
    }

    public Area getShape() {
        return shaped;
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
	public void setShaped(Area shaped) {
		this.shaped = shaped;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Rectangle getBounds() {
        return new Rectangle(getX()-getPadding(),getX()-getPadding(),getWidth()+2*getPadding(),getHeight()+2*getPadding());
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
        state = Primitives.OR(inConexion);
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

    public String getName() {
        return "Or - " + getGateInputs();
    }

}
