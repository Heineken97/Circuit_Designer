package applicationCircuitDesigner;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	
	@Override
	 public void start(Stage primaryStage) throws Exception{
		BorderPane root= new BorderPane();
		
		try {
			Scene scene = new Scene(root,1200,1200);
			scene.getStylesheets().add(getClass().getResource("/applicationCircuitDesigner/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
			}
		root.setCenter(FXMLLoader.load(getClass().getResource("/applicationCircuitDesigner/view/RootLayout.fxml")));
		

	 }

	public static void main(String[] args) {
		launch(args);

	}

}
