package circuitDesignerApplication.model.logicGate.shapes;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class OrShape extends Area{
	private Rectangle rectShape;
	private Ellipse2D.Double ellipseShape;
	private Ellipse2D.Double ellipseShape2;

	public OrShape(int x, int y) {
		ellipseShape = new Ellipse2D.Double(x, y, 60, 60);
		rectShape = new Rectangle(x, y, 60 / 2, 60);
		ellipseShape2 = new Ellipse2D.Double(x - (60 / 4), y, (60 / 2), 60);
		
		this.add(new Area(ellipseShape));
		this.add(new Area(rectShape));
		this.subtract(new Area(ellipseShape2));
	    }

}
