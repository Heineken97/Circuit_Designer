package applicationCircuitDesigner.controllers;

import applicationCircuitDesigner.model.DragComponent;
import applicationCircuitDesigner.model.DragComponentType;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class raizController extends AnchorPane{
	@FXML SplitPane base_pane;
    @FXML AnchorPane right_pane;
    @FXML VBox left_pane;

    private DragComponent mDragOverIcon = null;
    
    @FXML
    private void initialize() {
    	mDragOverIcon = new DragComponent();
    	 
        mDragOverIcon.setVisible(false);
        mDragOverIcon.setOpacity(0.65);
        getChildren().add(mDragOverIcon); 

        for (int i = 0; i < 7; i++) {
     
            DragComponent icn = new DragComponent();
     
            icn.setType(DragComponentType.values()[i]);
            left_pane.getChildren().add(icn);
    }
    }
}
