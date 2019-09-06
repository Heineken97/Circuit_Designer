package application.model;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import application.controller.Mouse;


public abstract class Component {
	
	private int x, y;
	
	//width, height
	private int tx=0, ty=0;
	private static Boolean pullState=false;
	
	public ArrayList<Component> runnable= new ArrayList<>();
	public ArrayList<Conexion> inConexion= new ArrayList<>();
	public ArrayList<Conexion> outConexion= new ArrayList<>();
	
	private static CopyOnWriteArrayList<Component> drawable = new CopyOnWriteArrayList<>();
	private int gateInputs=9999;


	//cambiar nombre
	private int padding=8;
	public Component() {
		
	}
	
	public abstract void draw (Graphics2D g2d);
	
	public void drawConexion(Graphics2D g2d) {
		drawOutConexion(g2d);
        drawInConexion(g2d);
		
	}
	
	public void  drawOutConexion(Graphics2D g2d) {
		for (Conexion con: outConexion) {
			con.draw(g2d);
		}
	}
	public void  drawInConexion(Graphics2D g2d) {
		for (Conexion con: inConexion) {
			con.draw(g2d);
		}
	}
	public void delete() {
		Wire.delete(this.inConexion, this.outConexion);
		Component.drawable.remove(this);
		Mouse.resetDeleteLocation();
		
	}
	
	/**
	 * @return the padding
	 */
	public int getPadding() {
		return padding;
	}

	/**
	 * @param padding the padding to set
	 */
	public void setPadding(int padding) {
		this.padding = padding;
	}
	
	public String getName() {
		return null;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
	public Boolean getState() {
		return null;
	}
	
	public Shape getShape() {
		return null;
	}
	/**
	 * @return the gateInputs
	 */
	public int getGateInputs() {
		return gateInputs;
	}

	/**
	 * @param gateInputs the gateInputs to set
	 */
	public void setGateInputs(int gateInputs) {
		this.gateInputs = gateInputs;
	}
	
	public void onClick() {
		
	}

	/**
	 * @return the pullState
	 */
	public static Boolean getPullState() {
		return pullState;
	}

	/**
	 * @param pullState the pullState to set
	 */
	public static void setPullState(Boolean pullState) {
		Component.pullState = pullState;
	}
}

