package applicationCircuitDesigner;


import java.io.IOException;


import applicationCircuitDesigner.model.DragComponent;
import applicationCircuitDesigner.model.DragComponentType;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.SplitPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class RootLayout extends AnchorPane{

	@FXML SplitPane base_pane;
	@FXML AnchorPane left_pane;
	@FXML VBox right_pane;

	private DragComponent mDragOverComponent = null;
	
	private EventHandler mComponentDragOverRoot=null;
	private EventHandler mComponentDragDropped=null;
	private EventHandler mComponentDragOverLeftPane=null;
	
	public RootLayout() {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/applicationCircuitDesigner/view/RootLayout.fxml"));
		//fxmlLoader.setRoot(this); 
		fxmlLoader.setController(this);
		
		try { 
			fxmlLoader.load();
	
        
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}

	}
	
	@FXML
	private void initialize() {
		mDragOverComponent = new DragComponent();
		mDragOverComponent.setVisible(false);
		mDragOverComponent.setOpacity(0.65);
		getChildren().add(mDragOverComponent);
		
		//populate left pane with multiple colored icons for testing
		for (int i = 0; i < 7; i++) {
			
			DragComponent icn = new DragComponent();
			
			addDragDetection(icn);
			
			icn.setType(DragComponentType.values()[i]);
			left_pane.getChildren().add(icn);
		}
	}
	
	private void addDragDetection(DragComponent dragComponent) {
		
		dragComponent.setOnDragDetected (new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent event) {
				// set the other drag event handles on their respective objects
				base_pane.setOnDragOver(mComponentDragOverRoot);
	            left_pane.setOnDragOver(mComponentDragOverLeftPane);
	            left_pane.setOnDragDropped(mComponentDragDropped);
	        
	            // get a reference to the clicked DragIcon object
	            DragComponent icn = (DragComponent) event.getSource();

	            //begin drag ops
	            mDragOverComponent.setType(icn.getType());
	            mDragOverComponent.relocateToPoint(new Point2D (event.getSceneX(), event.getSceneY()));

	            ClipboardContent content = new ClipboardContent();
	            content.putString(icn.getType().toString());

	            mDragOverComponent.startDragAndDrop (TransferMode.ANY).setContent(content);
	            mDragOverComponent.setVisible(true);
	            mDragOverComponent.setMouseTransparent(true);
	            event.consume();
	        }
	    });
	}
}

