package circuitDesignerApplication.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.dataStructure.LinkedList;
import circuitDesignerApplication.model.dataStructure.Nodo;

public class NodoComponent extends Component{

	public static LinkedList<Nodo> allNodes= new LinkedList<>();
	private LinkedList<Nodo> connectedTO= new LinkedList<>();
	private float[] dashStroke= {4.0f};
	private Rectangle outline;
	private Types.IO type;
	private Ellipse2D.Double shape;
	private Conexion conexion;
	private Boolean state;
	
	public NodoComponent(Conexion conexion, Types.IO type) {
		 this.setType(type);
		 this.setConexion(conexion);
		 Nodo newNode=new Nodo();
		 newNode.setData(conexion);
		 allNodes.insertFirst(newNode);
	}
	
	 public void updateState() {
		 if (type == Types.IO.Output) {
			 state = conexion.getState();
			 return;
			 }
		 
		 for (Nodo n : connectedTO) {
			 if (n.getData() == Types.IO.Output) {
				 state = ((NodoComponent) n.getData()).getState();
				 }
			 }
		 for (Nodo n : connectedTO) {
			 if (n.getData() == Types.IO.Input) {
				 state = ((NodoComponent) n.getData()).getState();
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
	public LinkedList<Nodo> getConnectedTO() {
		return connectedTO;
	}


	///Setters
	public void setConnectedTO(LinkedList<Nodo> connectedTO) {
		this.connectedTO = connectedTO;
	}
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



}
