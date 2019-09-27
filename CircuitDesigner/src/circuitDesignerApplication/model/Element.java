package circuitDesignerApplication.model;

import java.awt.Point;
import java.awt.Rectangle;

import circuitDesignerApplication.model.dataStructure.LinkedList;

public class Element {
	
	public static LinkedList<Element> drawing= new LinkedList<>();
	private Point local;
	
	public Element(int x, int y) {
		local=new Point(x,y);
		drawing.insertFirst(this);
	}
	
	
	public boolean underMouse(Point p) {
		if (getBounds().contains(p)) {
			return true;
		}else {
			return false;
		}
		
	}
	///Getters
	
	public Rectangle getBounds() {
		Rectangle bounds= new Rectangle(local.x,local.y,50,50);
		return bounds;
	}
	public int getLocalX() {
		return local.x;
	}
	public int getLocalY() {
		return local.y;
	}
	
	///Setters
	
	public void moveComponent(int x, int y) {
		local.x=x;
		local.y=y;
	}
	public void moveComponent(Point p) {
		local=p;
	}



}
