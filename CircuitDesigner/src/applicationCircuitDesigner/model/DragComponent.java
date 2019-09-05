package applicationCircuitDesigner.model;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class DragComponent extends AnchorPane{
	
	private DragComponentType cType;
	public DragComponent() {
		FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/applicationCircuitDesigner/view/DragComponent.fxml"));
		//fxmlLoader.setRoot(this);
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
	        
	    case and:
			getStyleClass().add("component-and");
		break;

		case nand:
			getStyleClass().add("component-nand");			
		break;

		case or:
			getStyleClass().add("component-or");
		break;

		case xnor:
			getStyleClass().add("component-xnor");
		break;

		case xor:
			getStyleClass().add("component-xor");
		break;

		case not:
			getStyleClass().add("component-not");
		break;

		case nor:
			getStyleClass().add("component-nor");
		break;
		
	        
	    default:break;
	    }
	}

}
