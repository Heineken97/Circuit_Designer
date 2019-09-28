package circuitDesignerApplication;


import circuitDesignerApplication.model.Component;
import circuitDesignerApplication.model.logicGate.And;
import circuitDesignerApplication.model.logicGate.Nand;
import circuitDesignerApplication.model.logicGate.Nor;
import circuitDesignerApplication.model.logicGate.Not;
import circuitDesignerApplication.model.logicGate.Or;
import circuitDesignerApplication.model.logicGate.Xnor;
import circuitDesignerApplication.model.logicGate.Xor;
import circuitDesignerApplication.view.Window;

public class Main {
	
	private static Window window;
    public static Object[][] Components;
    
    /***
     * Crear Ventana Desktop
     * @param args
     */

	public static void main(String[] args) {
		window=new Window();
		System.out.println("Main started");
	}
	
	/// Getters
	public static Window getWindow() {
		return window;
	}
	
	/// Setters
	public static void setWindow(Window window) {
		Main.window = window;
	}

	/***
	 * Creating certain component 
	 * @param selectedComponent
	 * @param x
	 * @param y
	 * @param gates
	 * @return
	 */
	public static Component classForName(String selectedComponent,int x,int y,int gates) {
		Component c=null;
		switch(selectedComponent) {
		case "And - 2":
			c=new And();
			break;
		case "And - n":
			c=new And(x,y,gates);
			break;
		case "Nand - 2":
			c=new Nand();
			break;
		case "Nand - n":
			c=new Nand(x,y,gates);
			break;
		case "Or - 2":
			c=new Or();
			break;
		case "Or - n":
			c=new Or(x,y,gates);
			break;
		case "Nor - 2":
			c=new Nor();
			break;
		case "Nor - n":
			c=new Nor(x,y,gates);
			break;
		case "Not - 2":
			c=new Not();
			break;
		case "Not - n":
			c=new Not(x,y,gates);
			break;
		case "Xor - 2":
			c=new Xor();
			break;
		case "Xor - n":
			c=new Xor(x,y,gates);
			break;
		case "Xnor - 2":
			c=new Xnor();
			break;
		case "Xnor - n":
			c=new Xnor(x,y,gates);
			break;
			
		}
		return c;
	}

}
