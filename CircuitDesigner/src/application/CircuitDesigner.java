package application;

import java.awt.Window;
import java.util.ArrayList;

import application.model.Component;

public class CircuitDesigner {
	
	static Window window;

	public static void main(String[] args) {
		System.out.println("Main started");
		window= new Window();
	}
	public static Component classForName(String selectedComponent, int x, int y) {
        System.out.println("ComponentSelected:  "+selectedComponent);
//        if(selectedComp==null) return;
        Component c = null;
        switch (selectedComponent) {
            case "And - 2":
                c = new And(x, y);
                break;
            case "And - 3":
                c = new And(x, y, 3);
                break;
            case "And - 4":
//                c = new And(x, y, 4);
                c = new DFlipFlop(x, y);
                break;
            case "Or - 2":
                c = new Or(x, y);
                break;
            case "Or - 3":
                c = new Or(x, y, 3);
                break;
            case "Or - 4":
                c = new Or(x, y, 4);
                break;
            case "Not":
                c = new Not(x, y);
                break;
            case "XOR - 2":
                c = new Xor(x, y);
                break;
            case "XOR - 3":
                c = new Xor(x, y, 3);
                break;
            case "XOR - 4":
                c = new Xor(x, y, 4);
                break;
            case "XNOR - 2":
                c = new Xnor(x, y);
                break;
            case "XNOR - 3":
                c = new Xnor(x, y, 3);
                break;
            case "XNOR - 4":
                c = new Xnor(x, y, 4);
                break;
            case "NOR - 2":
                c = new Nor(x, y, 2);
                break;
            case "NOR - 3":
                c = new Nor(x, y, 3);
                break;
            case "NOR - 4":
                c = new Nor(x, y, 4);
                break;
            case "NAND - 2":
                c = new Nand(x, y, 2);
                break;
            case "NAND - 3":
                c = new Nand(x, y, 3);
                break;
            case "NAND - 4":
                c = new Nand(x, y, 4);
                break;
        }
        return c;
	}
	
	


}
