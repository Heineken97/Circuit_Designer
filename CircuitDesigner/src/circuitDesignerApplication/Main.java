package circuitDesignerApplication;

import circuitDesignerApplication.view.Window;

public class Main {
	
	private static Window window;
	private static String[] Components = {""};
    private static Object[][] data;

	public static void main(String[] args) {
		window=new Window();
		System.out.println("Main started");
	}

	public static Object[][] getData() {
		return data;
	}

	public static void setData(Object[][] data) {
		Main.data = data;
	}

}
