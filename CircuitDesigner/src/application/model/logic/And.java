package application.model.logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import application.controller.Mouse;
import application.controller.Types;
import application.model.Component;
import application.model.Conexion;

public class And extends Component {
	private Color shapeColor = Color.DARK_GRAY;
    private Area shape;
    private int height = 60;
    private int width = 60;
    private boolean state = false;
    private static BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

    public And(int x, int y) {
        this(x, y, 2);
    }

    public And(int x, int y, int n) {
        setGateInputs(n);
        this.setX(x);
        this.setY(y);
        shape = new AndShape(x, y);

        outConexion.add(new Conexion(x + width, y + (height / 2), Types.Orientation.Horizontal, Types.IO.Output, this));
        int gap = height / (n + 1);
        int yt = y;
        for (int i = 0; i < n; i++) {
            yt += gap;
            inConexion.add(new Conexion(x, yt, Types.Orientation.Horizontal, Types.Position.LEFT, Types.IO.Input, this));
        }
    }

    public Area getShape() {
        return shape;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX()-getPadding(),getX()-getPadding(),width+2*getPadding(),height+2*getPadding());
    }


    public Color getShapeColor() {
        return shapeColor;
    }

    public Boolean getState() {
        return Primitives.AND(inConexion);
    }

    public void draw(Graphics2D g2d) {
        if(getBounds().contains(Mouse.getDeleteLocation())){
            delete();
        }
        g2d.translate(tx, ty);
        drawConexion(g2d);
        g2d.setColor(shapeColor);
        g2d.setStroke(stroke);
        g2d.draw(shape);
    }
    
    public String getName(){
        return "And - "+ getGateInputs();
    }
}
