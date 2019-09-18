package circuitDesignerApplication.model;

import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public class Conexion extends Component{
	private LinkedList wires = new LinkedList();
	private Types.IO type;
	private NodoComponent node;
	private Boolean state= null;
	private Component component;
	
	public Conexion(Types.IO type) {
		node = new NodoComponent(this, type);
        this.type = type;
	}
	public Conexion(Types.IO type,Component c) {
		component=c;
		node = new NodoComponent(this, type);
        this.type = type;
	}
	
	public Boolean getState() {
		return state;
	}
	
    public void setState(Boolean in) {
        state = in;
    }

}
