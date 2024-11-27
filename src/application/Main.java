/** * @author Heineken97 - Joseph Jimenez */
package application;
import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainView view = new MainView(primaryStage);
        MainController controller = new MainController(view);
        view.setController(controller);
        view.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}