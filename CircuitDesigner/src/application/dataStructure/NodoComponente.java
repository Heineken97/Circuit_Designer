package application.dataStructure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import application.controller.Mouse;
import application.controller.Types;
import application.model.Conexion;


public class NodoComponente {
	
	private static ArrayList<NodoComponente> allNodes= new ArrayList();
	private int diameter = 10;
	private static Color outLineColor= Color.gray;
	private static int outlinePadding= 6;
	private static float dash[]= {4.0f};
	private static Stroke outLineStroke= new BasicStroke(1.4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f,dash,0.0f);
	private Rectangle outline;
	private static Color color= Color.green;
	private Ellipse2D.Double shaped;
	private int x;
	private int y;
	private int xExt;
	private int yExt;
	public ArrayList<NodoComponente> connectedTO= new ArrayList<>();
	private Types.IO type;
	private Conexion conexion;
	private Boolean state;
	
	public NodoComponente(int x, int y, Conexion con, Types.IO type) {
        xExt = x;
        yExt = y;
        this.x = x - diameter / 2;
        this.y = y - diameter / 2;
        shaped = new Ellipse2D.Double(x, y, diameter, diameter);
        outline = new Rectangle(x - outlinePadding / 2, y - outlinePadding / 2, diameter + outlinePadding, diameter + outlinePadding);
        this.type = type;
        this.conexion = con;
        allNodes.add(this);
    }
	
	
	public void draw(Graphics2D g2d) {
		if (getBounds().contains(Mouse.getMouseLocation())) {
            drawOutline(g2d);
        }
        g2d.setColor(color);
        g2d.fill(shaped);
    }

    public void drawOutline(Graphics2D g2d) {
        g2d.setColor(outLineColor);
        g2d.setStroke(outLineStroke);
        g2d.draw(outline);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    public Boolean getState() {
        updateState();
        return state;
    }

    public void updateState() {
        if (type == Types.IO.Output) {
            state = conexion.getState();
            return;
        }
        ArrayList<Boolean> shortTest = new ArrayList<>();
        for (NodoComponente n : connectedTO) {
            if (n.type == Types.IO.Output) {
                state = n.getState();
                shortTest.add(state);
            }
        }
        for (NodoComponente n : connectedTO) {
            if (n.type == Types.IO.Input) {
//                System.out.println("here: "+n.state);
                state = n.state;
                return;
            }
        }
        for(NodoComponente n:connectedTO){
            
        }
    }
    
    /**
	 * @return the xExt
	 */
	public int getxExt() {
		return xExt;
	}


	/**
	 * @return the yExt
	 */
	public int getyExt() {
		return yExt;
	}


	/**
	 * @param xExt the xExt to set
	 */
	public void setxExt(int xExt) {
		this.xExt = xExt;
	}


	/**
	 * @param yExt the yExt to set
	 */
	public void setyExt(int yExt) {
		this.yExt = yExt;
	}

 

}
