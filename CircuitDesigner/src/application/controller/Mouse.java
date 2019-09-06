package application.controller;

import java.awt.Point;

public class Mouse {
	private static String component = null;
    private static Point MouseLocation = new Point(0, 0);
   	private static Point ClickLocation = new Point(0, 0);
    private static Mode mode = Mode.Component;
    private static State state = State.resting;
    private static Point DeleteLocation = new Point(-50, -50);

    public enum State {
        placingComponent,
        resting
    };

    public enum Mode {
        Track,
        Component,
        Select
    };

    public static void setComponent(String in) {
        component = in;
    }

    public static String selectedComponent() {
        return component;
    }

   public  static void setMouseLocation(Point p) {
        MouseLocation = p;
    }

    public static void setMouseLocaiton(int x, int y) {
        MouseLocation.setLocation(x, y);
    }

    public static void setClickLocation(int x, int y) {
        ClickLocation.setLocation(x, y);
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

    public static void setMode(Mode m) {
        mode = m;
    }

    public static Mode getMode() {
        return mode;
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
        DeleteLocation = MouseLocation;
        autoReset.start();
    }

  
	public static Point getMouseLocation() {
		return MouseLocation;
	}
	
    public static void resetDeleteLocation() {
        setDeleteLocation(new Point(-50, -50));
    }

	public static Point getDeleteLocation() {
		return DeleteLocation;
	}

	public static void setDeleteLocation(Point deleteLocation) {
		DeleteLocation = deleteLocation;
	}
}

