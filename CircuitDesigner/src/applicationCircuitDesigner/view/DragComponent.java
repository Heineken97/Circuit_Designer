package applicationCircuitDesigner.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class DragComponent {
	
	public DragComponent() {

	    FXMLLoader fxmlLoader = new FXMLLoader(
	    getClass().getResource("")
	    );
	        
	    fxmlLoader.setRoot(this); 
	    fxmlLoader.setController(this);
	        
	    try { 
	    fxmlLoader.load();
	        
	    } catch (IOException exception) {
	    throw new RuntimeException(exception);
	    }
	}

}
