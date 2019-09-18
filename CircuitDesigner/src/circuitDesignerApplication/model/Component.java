package circuitDesignerApplication.model;

import circuitDesignerApplication.model.dataStructure.LinkedList;

public abstract class Component {
	
	///private int x, y;
	
	private static Boolean pullState=false;
	
	private LinkedList inConexion=new LinkedList();
	private LinkedList outConexion=new LinkedList();
	
	private int gateInputs=999;
	
	public Component() {
		
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

	///Setters
	public void setGateInputs(int gateInputs) {
		this.gateInputs = gateInputs;
	}

	public static void setPullState(Boolean pullState) {
		Component.pullState = pullState;
	}


}
