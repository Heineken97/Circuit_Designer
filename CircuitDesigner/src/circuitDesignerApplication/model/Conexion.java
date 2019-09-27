package circuitDesignerApplication.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public class Conexion extends Component{
	private int x,y;
	private LinkedList wires = new LinkedList();
	private Line2D.Double shape;
	private Types.IO type;
	private NodoComponent node;
	private Boolean state= null;
	private Component component;
	
	public Conexion(Types.IO type) {
		node = new NodoComponent(this, type);
        this.type = type;
        shape = new Line2D.Double(x, y, x + 20, y);
	}
	public Conexion(Types.IO type,Component c) {
		component=c;
		node = new NodoComponent(this, type);
        this.type = type;
        shape = new Line2D.Double(x, y, x + 20, y);
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2d.draw(shape);
		node.draw(g2d);
		}
	
	public void updateState() {
		state = node.getState();
		}
	
	///Getters
	
	public NodoComponent getNode() {
		return node;
	}	
	public Boolean getState() {
		if (type == Types.IO.Input) {
            updateState();
            return state;
        } else {
            return component.getState();
        }
	}
	
	///Setters
	
    public void setState(Boolean in) {
        state = in;
    }
    public void setNode(NodoComponent node) {
		this.node = node;
	}

}
