package circuitDesignerApplication.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import circuitDesignerApplication.model.dataStructure.LinkedList;

public class Wire extends Component{
	private int [] x;
	private int [] y;
	private GeneralPath polyline;
	int npoints;
	private static LinkedList allTheWires=new LinkedList();
	private NodoComponent from;
	private NodoComponent to;
	
	public Wire(int[] _x, int[] _y,int _npoints,NodoComponent nodo1, NodoComponent nodo2) {
		from=nodo1;
		to=nodo2;
		nodo1.getConnectedTO().insertFirst(nodo2);
		nodo2.getConnectedTO().insertFirst(nodo1);
		allTheWires.insertFirst(this);
		
		npoints = _npoints;
        x = new int[npoints];
        y = new int[npoints];
        for (int i = 0; i < npoints; i++) {
            x[i] = _x[i];
            y[i] = _y[i];
        }
        x[0] = nodo1.getX();
        y[0] = nodo1.getY();
        x[npoints - 2] = nodo2.getX();
        y[npoints - 2] = nodo2.getY();
        
        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, npoints);
        polyline.moveTo(x[0], y[0]);
        for (int index = 1; index < npoints; index++) {
            polyline.lineTo(x[index], y[index]);
        };
        allTheWires.insertFirst(this);
		
	}
	
	 public void draw(Graphics2D g2d) {
	        g2d.setColor(Color.green);
	        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
	        g2d.draw(polyline);
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
	
	public static void drawAll(Graphics2D g2d) {
        for (Wire wire : allTheWires) {
            wire.draw(g2d);
        }
    }

	
	

}
