package circuitDesignerApplication.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public class NodoComponent extends Component{

	private LinkedList allNodes= new LinkedList();
	private LinkedList connectedTO= new LinkedList();
	private float[] dashStroke= {4.0f};
	private Rectangle outline;
	///private Rectangle outline;
	private Types.IO type;
	private Ellipse2D.Double shape;
	private Conexion conexion;
	private Boolean state;
	
	public NodoComponent(Conexion conexion, Types.IO type) {
		 this.setType(type);
		 this.setConexion(conexion);
		 allNodes.insertFirst(this);
	}
	
	 public void updateState() {
		 if (type == Types.IO.Output) {
			 state = conexion.getState();
			 return;
			 }
		 
		 for (NodoComponent n : connectedTO) {
			 if (n.getType() == Types.IO.Output) {
				 state = n.getState();
				 }
			 }
		 for (NodoComponent n : connectedTO) {
			 if (n.getType() == Types.IO.Input) {
				 System.out.println("here: "+n.getState());
				 state = n.state;
				 return;
				 }
			 }
		 }
	 
	 public void draw(Graphics2D g2d) {
		 if (getBounds().contains(circuitDesignerApplication.controller.Mouse.getMouseLocation())) {
			 drawOutline(g2d);
			 }
		 g2d.setColor(Color.BLACK);
		 g2d.fill(shape);
		 }
	 public void drawOutline(Graphics2D g2d) {
		 g2d.setColor(Color.RED);
		 g2d.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashStroke, 0.0f));
		 g2d.draw(outline);
	    }
	 
	
	
	///Getters
	public Types.IO getType() {
		return type;
	}
	public Conexion getConexion() {
		return conexion;
	}
	public Boolean getState() {
		return state;
	}
	public Ellipse2D.Double getShape() {
		return shape;
	}
	public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 10, 10);
    }

	///Setters
	public void setType(Types.IO type) {
		this.type = type;
	}
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public void setShape(Ellipse2D.Double shape) {
		this.shape = shape;
	}

	/**
	 * @return the allNodes
	 */
	public LinkedList getAllNodes() {
		return allNodes;
	}
	public LinkedList getConnectedTO() {
		return connectedTO;
	}
	public void setAllNodes(LinkedList allNodes) {
		this.allNodes = allNodes;
	}
	public void setConnectedTO(LinkedList connectedTO) {
		this.connectedTO = connectedTO;
	}

}
