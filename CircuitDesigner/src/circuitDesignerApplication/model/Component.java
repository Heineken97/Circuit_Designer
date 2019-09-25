package circuitDesignerApplication.model;

import java.awt.Graphics2D;
import java.awt.Shape;

import circuitDesignerApplication.controller.Mouse;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public abstract class Component {
	
	private int x, y;
	private int movX, movY;
	
	private static Boolean pullState=false;
	
	private LinkedList inConexion=new LinkedList();
	private LinkedList outConexion=new LinkedList();
	private static LinkedList draw= new LinkedList();
	
	
	private int gateInputs=999;
	
	public Component() {
	}
	
	public void delete() {
		Wire.delete(this.inConexion, this.outConexion);
        Component.draw.remove(this);
        Mouse.resetDeleteLocation();
	}
	
	public void drawConexions(Graphics2D g2d) {
        drawOutConexion(g2d);
        drawInConexion(g2d);
    }
	
	public void drawOutConexion(Graphics2D g2d) {
        for (Conexion con : outConexion) {
            con.draw(g2d);
        }
    }
	
	public void drawInConexion(Graphics2D g2d) {
        for (Conexion con : inConexion) {
            con.draw(g2d);
        }
    }
	
	///Getters
	public String getName() {
		return null;
	}
	public int getGateInputs() {
		return gateInputs;
	}
	public static Boolean getPullState() {
		return pullState;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getMovX() {
		return movX;
	}
	public int getMovY() {
		return movY;
	}
	public Shape getShape() {
		return null;
	}

	public abstract void draw(Graphics2D g2d) ;

	///Setters
	public void setGateInputs(int gateInputs) {
		this.gateInputs = gateInputs;
	}
	public static void setPullState(Boolean pullState) {
		Component.pullState = pullState;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setMovX(int movX) {
		this.movX = movX;
	}
	public void setMovY(int movY) {
		this.movY = movY;
	}

	/**
	 * @return the draw
	 */
	public static LinkedList getDraw() {
		return draw;
	}
	public static void setDraw(LinkedList draw) {
		Component.draw = draw;
	}
	public LinkedList getInConexion() {
		return inConexion;
	}
	public LinkedList getOutConexion() {
		return outConexion;
	}
	public void setInConexion(LinkedList inConexion) {
		this.inConexion = inConexion;
	}
	public void setOutConexion(LinkedList outConexion) {
		this.outConexion = outConexion;
	}
	
	public void onClick() {
		
	}


}
