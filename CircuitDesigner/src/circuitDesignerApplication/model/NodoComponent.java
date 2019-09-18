package circuitDesignerApplication.model;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public class NodoComponent extends Component{

	private LinkedList allNodes= new LinkedList();
	private LinkedList connectedTO= new LinkedList();
	///private Rectangle outline;
	private Types.IO type;
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

}
