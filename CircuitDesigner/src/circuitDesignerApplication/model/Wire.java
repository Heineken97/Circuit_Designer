package circuitDesignerApplication.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import circuitDesignerApplication.model.dataStructure.LinkedList;
import circuitDesignerApplication.model.dataStructure.Nodo;

public class Wire extends Component{
	private int [] x;
	private int [] y;
	private GeneralPath polyline;
	int npoints;
	private static CopyOnWriteArrayList<Wire> allTheWires = new CopyOnWriteArrayList<>();
	private NodoComponent from;
	private NodoComponent to;
	
	public Wire(int[] _x, int[] _y,int _npoints,NodoComponent nodo1, NodoComponent nodo2) {
		from=nodo1;
		to=nodo2;
		
		Nodo nodoo2=new Nodo();
		nodoo2.setData(nodo2);
		Nodo nodoo1=new Nodo();
		nodoo1.setData(nodo1);
		
		nodo1.getConnectedTO().insertFirst(nodoo2);
		nodo2.getConnectedTO().insertFirst(nodoo1);
		
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
        allTheWires.add(this);
		
	}
	
	 public void draw(Graphics2D g2d) {
	        g2d.setColor(Color.green);
	        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
	        g2d.draw(polyline);
	    }
	 
	public static void delete(final LinkedList<Conexion> in, final LinkedList<Conexion> out) {
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
