/** * @author Heineken97 - Joseph Jimenez */
package view;

import controller.MainController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MainView {
    private Stage stage;
    private BorderPane root;
    private Pane drawingPane;
    private MainController controller;

    public MainView(Stage stage) {
        this.stage = stage;
        this.root = new BorderPane();
        this.drawingPane = new Pane();
        VBox menu = createMenu();

        root.setCenter(drawingPane);
        root.setRight(menu);

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        stage.setTitle("Circuit Designer");

        root.setStyle("-fx-background-color: #ffffff;"); 
        drawingPane.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #4a4a4a; -fx-border-width: 2px;");
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    private VBox createMenu() {
        VBox menu = new VBox(15);
        menu.setPadding(new Insets(10));
        menu.setStyle("-fx-background-color: #ff4c4c; -fx-border-color: #1a1a1a; -fx-border-width: 2px;"); 

        Label title = new Label("Logic Gates");
        title.setFont(new Font("Arial", 20));
        title.setTextFill(Color.WHITE);

        Button andButton = createStyledButton("AND Gate", "#4cff4c"); 
        Button orButton = createStyledButton("OR Gate", "#4cff4c");
        Button notButton = createStyledButton("NOT Gate", "#4cff4c"); 
        Button nandButton = createStyledButton("NAND Gate", "#4cff4c"); 
        Button norButton = createStyledButton("NOR Gate", "#4cff4c"); 
        Button xorButton = createStyledButton("XOR Gate", "#4cff4c"); 
        Button xnorButton = createStyledButton("XNOR Gate", "#4cff4c");

        andButton.setOnAction(e -> controller.addGate("AND"));
        orButton.setOnAction(e -> controller.addGate("OR"));
        notButton.setOnAction(e -> controller.addGate("NOT"));
        nandButton.setOnAction(e -> controller.addGate("NAND"));
        norButton.setOnAction(e -> controller.addGate("NOR"));
        xorButton.setOnAction(e -> controller.addGate("XOR"));
        xnorButton.setOnAction(e -> controller.addGate("XNOR"));

        menu.getChildren().addAll(title, andButton, orButton, notButton, nandButton, norButton, xorButton, xnorButton);
        return menu;
    }

    private Button createStyledButton(String text, String color) {
        Button button = new Button(text);
        button.setFont(new Font("Arial", 16));
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: " + color + "; -fx-border-color: #1a1a1a; -fx-border-width: 2px;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + color + "; -fx-border-color: #1a1a1a; -fx-border-width: 2px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + color + "; -fx-border-color: #1a1a1a; -fx-border-width: 2px;"));
        return button;
    }

    public void addGateToPane(LogicGateNode gateNode) {
        drawingPane.getChildren().add(gateNode);
    }

    public void show() {
        stage.show();
    }

    public Pane getDrawingPane() {
        return drawingPane;
    }

    public List<LogicGateNode> getGateNodes() {
        List<LogicGateNode> gateNodes = new ArrayList<>();
        for (javafx.scene.Node node : drawingPane.getChildren()) {
            if (node instanceof LogicGateNode) {
                gateNodes.add((LogicGateNode) node);
            }
        }
        return gateNodes;
    }
}
