package applicationCircuitDesigner.model;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class DragComponent extends AnchorPane{
	
	private DragComponentType cType;
	public DragComponent() {
		FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/applicationCircuitDesigner/view/DragComponent.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public DragComponentType getType() { 
		return cType;
		}

	public void setType(DragComponentType type) {

	    cType = type;

	    getStyleClass().clear();
	    getStyleClass().add("dragComponent");
	    switch (cType) {
	        
	    case blue:getStyleClass().add("component-blue");
	    break;

	    case red:getStyleClass().add("component-red");            
	    break;

	    case green:getStyleClass().add("component-green");
	    break;

	    case grey:getStyleClass().add("component-grey");
	    break;

	    case purple: getStyleClass().add("component-purple");
	    break;

	    case yellow: getStyleClass().add("component-yellow");
	    break;

	    case black:getStyleClass().add("component-black");
	    break;
	        
	    default:break;
	    }
	}

}
