package circuitDesignerApplication.model.logicGate;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;

import circuitDesignerApplication.controller.Mouse;
import circuitDesignerApplication.controller.Types;
import circuitDesignerApplication.model.Component;
import circuitDesignerApplication.model.Conexion;
import circuitDesignerApplication.model.logicGate.shapes.AndShape;


public class Xnor extends Component {
	private boolean state= false;
	private Area shape; 
	
	public Xnor() {
		this.setGateInputs(2);
		this.setX(0);
		this.setY(0);
		this.shape=new AndShape(0,0);
		
		outConexion.insertFirst(new Conexion(Types.IO.Output));
		for (int i = 0; i < 2; i++) {
			inConexion.insertFirst(new Conexion(Types.IO.Input));
			}
	}

    public Xnor(int x, int y, int n) {
    	this.setGateInputs(n);
        this.setX(x);
		this.setY(y);
		this.shape=new AndShape(x,y);
    	
		outConexion.insertFirst(new Conexion(Types.IO.Output));
    	for (int i = 0; i < n; i++) {
    		inConexion.insertFirst(new Conexion(Types.IO.Input));
        }
    }
    
    public synchronized Boolean getState() {
        Thread stateUpdater = new Thread() {
            public void run() {
                updateState();
            }
        };
        try {
            return state;
        } finally {
            stateUpdater.start();
        }
    }

    void updateState() {
        state = Primitives.XNOR(inConexion);
    }
    
    public String getName(){
        return "Xnor - "+ getGateInputs();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX()-8,getY()-8,60+2*8,60+2*8);
    }
	
	public void draw(Graphics2D g2d) {
		
		if(getBounds().contains(Mouse.getDeleteLocation())){
            delete();
        }
		g2d.translate(getMovX(), getMovY());
        drawConexions(g2d);
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2d.draw(shape);
    }


}
