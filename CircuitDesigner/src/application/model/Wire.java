package application.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import application.dataStructure.NodoComponente;

public class Wire extends Component{
	
	private static CopyOnWriteArrayList<Wire> allTheWires = new CopyOnWriteArrayList<>();
    private static float width = 3;
    private static Color color = Color.green;
    private static Color mouseOverColor = Color.red;
    private static BasicStroke stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    private NodoComponente from;
    private NodoComponente to;
    private GeneralPath polyline;
    private int[] x;
    private int[] y;
    private int npoints;

    public Wire(int[] x, int[] y, int _npoints, NodoComponente n1, NodoComponente n2) {
        from = n1;
        to = n2;
        n1.connectedTO.add(n2);
        n2.connectedTO.add(n1);
        npoints = _npoints;
        x = new int[npoints];
        y = new int[npoints];
        for (int i = 0; i < npoints; i++) {
            x[i] = x[i];
            y[i] = y[i];
        }
        x[0] = n1.getxExt();
        y[0] = n1.getyExt();
        x[npoints - 2] = n2.getxExt();
        y[npoints - 2] = n2.getyExt();
        polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, npoints);
        polyline.moveTo(x[0], y[0]);
        for (int index = 1; index < npoints; index++) {
            polyline.lineTo(x[index], y[index]);
        };
        allTheWires.add(this);
    }

    public Wire(NodoComponente c1, NodoComponente c2) {
        from = c1;
        to = c2;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
//        if(polyline.intersect(new Point(Mouse.getLocX(),Mouse.getLocY()))) {
//            System.out.println("asdf");
//            g2d.setColor(mouseOverColor);
//        }
        g2d.setStroke(stroke);
        g2d.draw(polyline);
    }

    public static void delete(final ArrayList<Conexion> in, final ArrayList<Conexion> out) {
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

    public static void DrawAll(Graphics2D g2d) {
        for (Wire wire : allTheWires) {
            wire.draw(g2d);
        }
    }

    public String getName() {
        return "Wire";
    }

}
