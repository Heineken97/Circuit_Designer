package circuitDesignerApplication.controller;

import java.awt.Point;


public class Mouse {
	private static String component = null;
    private static Point MouseLocation = new Point(0, 0);
   	private static Point ClickLocation = new Point(0, 0);
    private static State state = State.resting;
    private static Point deleteLocation = new Point(-50, -50);

    public enum State {
        placingComponent,
        resting
    };

    public enum Mode {
        Component
    };
    
/// Getters
    
    public static String getselectedComponent() {
        return component;
    }
    public static int getClickX() {
        return (int) ClickLocation.getX();
    }
    public static int getClickY() {
        return (int) ClickLocation.getY();
    }
    public static int getLocX() {
        return (int) MouseLocation.getX();
    }
    public static int getLocY() {
        return (int) MouseLocation.getY();
    }
    public static Point getMouseLocation() {
		return MouseLocation;
	}
    public static Point getDeleteLocation() {
		return deleteLocation;
	}
    public static State getState() {
		return state;
	}
    
    ///Setters

    public static void setComponent(String component) {
        component = Mouse.component;
    }
    public  static void setMouseLocation(Point p) {
        MouseLocation = p;
    }
    public static void setMouseLocation(int x, int y) {
        MouseLocation.setLocation(x, y);
    }
    public static void setClickLocation(int x, int y) {
        ClickLocation.setLocation(x, y);
    }
    public static void setClickLocation(Point p) {
        ClickLocation = p;
    }
    public static void resetDeleteLocation() {
        deleteLocation=new Point(-50, -50);
    }
	public static void setState(State state) {
		Mouse.state = state;
	}

	public static void setDeleteLocation() {
    	Thread autoReset = new Thread() {
    		public void run() {
    			try {
    				Thread.sleep(400);
    				} catch (InterruptedException ex) {
    					System.out.println("Interrupted");
    					}
    			resetDeleteLocation();
    			}
    		};
    		deleteLocation = MouseLocation;
    		autoReset.start();
    		}

}

