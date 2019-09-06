package application.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import application.controller.Types;
import application.controller.Types.Orientation;
import application.dataStructure.NodoComponente;

public class Conexion extends Component {
	
	public ArrayList<Wire> wires= new ArrayList<>();
	
	private static float width=3;
	private static int length= 20;
	private Color color = Color.green;
	private int x;
	private int y;
	private Types.IO type;
	private Line2D.Double shaped;
	private BasicStroke stroke;
	private NodoComponente node;
	private Boolean state= null;
	private Component component;
	
	
	public Conexion(int x, int y, Orientation _orientation, Types.IO type) {
        this.x = x;
        this.y = y;
        node = new NodoComponente(x + length, y, this, type);
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        shaped = new Line2D.Double(x, y, x + length, y);
    }
	
	public Conexion(int x, int y, Orientation _orientation, Types.IO type, Component c) {
		component = c;
        this.x = x;
        this.y = y;
        node = new NodoComponente(x + length, y, this, type);
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        shaped = new Line2D.Double(x, y, x + length, y);
	}
	
	public Conexion(int x, int y, Orientation _orientation, Types.Position pos, Types.IO type, Component c) {
        component = c;
        this.x = x;
        this.y = y;
        this.type = type;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        switch (pos) {
            case LEFT:
                shaped = new Line2D.Double(x-length, y, x, y);
                node = new NodoComponente(x - length, y, this, type);
                break;
            case RIGHT:
                shaped = new Line2D.Double(x, y, x + length, y);
                node = new NodoComponente(x + length, y, this, type);
                break;
        }
    }
	
	public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(stroke);
        g2d.draw(shaped);
        node.draw(g2d);
    }

    public Boolean getState() {
        if (type == Types.IO.Input) {
            updateState();
            return state;
        } else {
            return component.getState();
        }
   }

    public void setState(Boolean in) {
        state = in;
    }

    public void updateState() {
        state = node.getState();
    }
    

	/**
	 * @return the node
	 */
	public NodoComponente getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(NodoComponente node) {
		this.node = node;
	}
    public String getName(){
    	return "Conexion";
    }
	

}
