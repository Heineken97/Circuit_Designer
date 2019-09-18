package circuitDesignerApplication.model;

import java.util.ArrayList;

import application.model.Conexion;
import application.model.Wire;
import circuitDesignerApplication.model.dataStructure.LinkedList;

public class Wire extends Component{
	private static LinkedList allTheWires=new LinkedList();
	private NodoComponent from;
	private NodoComponent to;
	
	public Wire(NodoComponent nodo1, NodoComponent nodo2) {
		from=nodo1;
		to=nodo2;
		nodo1.connectedTO.insertFirst(nodo2);
		allTheWires.insertFirst(this);
		
	}
	public static void delete(final LinkedList in, final LinkedList out) {
        Thread deleteThread = new Thread() {
            public void run() {
                for (Wire wire : allTheWires) {
                    for (Conexion con : in) {
                        if (wire.from.getBounds().intersects(con.getNode().getBounds())) {
                            allTheWires.remove(wire);
                        }
                        if (wire.to.getBounds().intersects(con.getNode().getBounds())) {
                            allTheWires.remove(wire);
                        }
                    }
                    for (Conexion con : out) {
                        if (wire.from.getBounds().intersects(con.getNode().getBounds())) {
                            allTheWires.remove(wire);
                        }
                        if (wire.to.getBounds().intersects(con.getNode().getBounds())) {
                            allTheWires.remove(wire);
                        }
                    }

                }
            }
        };
        deleteThread.start();
    }

	
	

}
