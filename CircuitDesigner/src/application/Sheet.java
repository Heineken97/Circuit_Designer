package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import application.controller.Mouse;
import application.dataStructure.NodoComponente;
import application.model.Component;
import application.model.Wire;

public class Sheet extends JPanel{
	private Component c = null;
    private Graphics2D g2d;
    private Wire wire = null;
    private int npoint = 1;
    private int[] xl = new int[50];
    private int[] yl = new int[50];
    private int gridSize = 23;
    private boolean grid = true;
    private Point mouseLoc = new Point(20, 20);
    private NodoComponente startingNode = null;
    private NodoComponente endingNode = null;
    private static Sheet ref;
    
    public void addPoint() {
        try {
            xl[npoint - 1] = Mouse.getLocX();
            yl[npoint - 1] = Mouse.getLocY();
            npoint++;
            xl[npoint - 1] = Mouse.getLocX();
            yl[npoint - 1] = Mouse.getLocY();
        } catch (Exception e) {
        }
    }

    public void deletePoint() {
        if (npoint != 1) {
            npoint--;
            xl[npoint - 1] = Mouse.getLocX();
            yl[npoint - 1] = Mouse.getLocY();
        } else {
            startingNode = null;
        }
    }

    public void resetLine() {
        npoint = 1;
    }

    public Sheet(int w, int h) {
        ref = this;
        Timer timer2 = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint(); }});
        
        timer2.start();

        new CirElement(100, 20);
        setPreferredSize(new Dimension(w, h));
        
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Mouse.setClockLocation(e.getPoint());
                System.out.println(Mouse.selectedComponent());
                checkClick();
                
                switch (Mouse.getMode()) {
                    case Component:
                        component(e);
                        break;
                    case Select:
                        select(e);
                        break;
                    case Track:
                        track(e);
                        break;
                }
            }});

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseLoc.x = e.getX();
                mouseLoc.y = e.getY();
                Point p = e.getPoint();
                CircuitDesigner.window.getSim().changeMousePosition(mouseLoc.x, mouseLoc.y);
                if (CirElement.drawable.get(0).underMouse(p)) {
                    CirElement.drawable.get(0).moveComponent(p);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (Mouse.getState() == Mouse.State.placingComponent) {
                    if (c != null) {
                        c.setTx(e.getX() - Mouse.getClickX());
                        c.setTy(e.getY() - Mouse.getClickY());
                    }
                }
                xl[npoint - 1] = e.getX();
                yl[npoint - 1] = e.getY();

                mouseLoc.setLocation(e.getX(), e.getY());
                Mouse.setMouseLocaiton(e.getX(), e.getY());
                CircuitDesigner.window.getSim().changeMousePosition(mouseLoc.x, mouseLoc.y);
//                drawOutLineOnNodes();
            }
        });

        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public void checkClick() {
        if (Mouse.getState() == Mouse.State.placingComponent) {
            return;
        }
        for (Component i : Component.drawable) {
            if(i==null) return;
            if (i.getShape().intersects(new Rectangle(mouseLoc.x, mouseLoc.y, 2, 2))) {
                i.onClick();
            }
        }
    }

    public void component(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) && Mouse.getState() == Mouse.State.placingComponent) {
            Mouse.setState(Mouse.State.resting);
            c = null;
            return;
        }
        if (Mouse.selectedComponent() != null) {
            String selectedComp = Mouse.selectedComponent();
            c = CircuitDesigner.classForName(selectedComp, mouseLoc.x, mouseLoc.y);

            if (Mouse.getState() == Mouse.State.resting) {
                Mouse.setState(Mouse.State.placingComponent);
            } else if (Mouse.getState() == Mouse.State.placingComponent) {
                Component.drawable.add(c);
                if(c instanceof Clock){
                    new Thread(((Clock)c)).start();
                }
                c = null;
                Mouse.setState(Mouse.State.resting);
            }
        }
    }

    public void track(MouseEvent e) {
        if (startingNode != null) {
            if (SwingUtilities.isRightMouseButton(e)) {
                deletePoint();
            } else {
                addPoint();
            }
        }
        for (NodoComponente node : NodoComponente.allNodes) {
            if (node.getBounds().contains(mouseLoc)) {
                if (startingNode == null) {
                    startingNode = node;
                    addPoint();
                } else {
                    endingNode = node;
                    wire = new Wire(xl, yl, npoint, startingNode, endingNode);
                    npoint = 1;
                    startingNode = null;
                    resetLine();
                }
                break;
            }
        }
    }

    public void select(MouseEvent e) {
        if (e.getClickCount() == 2&&SwingUtilities.isRightMouseButton(e)){
            Mouse.setDeleteLocation();
            System.out.println("Success");
        }
    }


    public void paint(Graphics g) {
        super.paint(g);
        drawGrid(g);
        drawShapes(g);

        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Wire.DrawAll(g2d);
        if (c != null) {
            c.draw(g2d);
        }
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, npoint);
        polyline.moveTo(xl[0], yl[0]);
        for (int index = 1; index < npoint; index++) {
            polyline.lineTo(xl[index], yl[index]);
        };
        g2d.draw(polyline);
    }

    public void drawShapes(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Component i : Component.drawable) {
            i.draw(g2d);
        }
    }

    public void drawGrid(Graphics g) {
        g.setColor(Color.lightGray);
        int h = this.getHeight();
        int w = this.getWidth();
        if (grid) {
            for (int x = 0; x < w; x += gridSize) {
                for (int y = 0; y < h; y += gridSize) {
                    g.drawRect(x, y, gridSize, gridSize);
                }
            }
        }
    }

    public void gridOff() {
        grid = false;
    }

    public void toggleGrid() {
        if (grid) {
            grid = false;
        } else {
            grid = true;
        }
    }

}
