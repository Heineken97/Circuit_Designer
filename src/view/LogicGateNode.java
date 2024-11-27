/** * @author Heineken97 - Joseph Jimenez */
package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import model.LogicGate;
import controller.MainController;

public class LogicGateNode extends StackPane {
    private LogicGate gate;
    private MainController controller;
    private LogicGateNode selectedNode = null;

    public LogicGateNode(LogicGate gate, MainController controller) {
        this.gate = gate;
        this.controller = controller;
        switch (gate.getType()) {
            case "AND":
                createAndGate();
                break;
            case "OR":
                createOrGate();
                break;
            case "NOT":
                createNotGate();
                break;
            case "NAND":
                createNandGate();
                break;
            case "NOR":
                createNorGate();
                break;
            case "XOR":
                createXorGate();
                break;
            case "XNOR":
                createXnorGate();
                break;
        }

        // Permite arrastrar la compuerta
        setOnMousePressed(event -> {
            setTranslateX(event.getSceneX() - getLayoutX());
            setTranslateY(event.getSceneY() - getLayoutY());
        });

        setOnMouseDragged(event -> {
            setLayoutX(event.getSceneX() - getTranslateX());
            setLayoutY(event.getSceneY() - getTranslateY());
        });

        // Permite seleccionar y conectar compuertas
        setOnMouseClicked(event -> {
            if (selectedNode == null) {
                selectedNode = this; // Selecciona la compuerta
                setStyle("-fx-background-color: yellow;"); // Cambia el color para indicar selección
            } else {
                // Conectar la compuerta seleccionada con la compuerta actual
                controller.connectGates(selectedNode.getGate(), this.gate);
                selectedNode.setStyle(""); // Restablece el estilo de la compuerta seleccionada
                selectedNode = null; // Reinicia la selección
            }
        });

        createInputOutputCircles();
    }

    // Crea los círculos de entrada y salida
    private void createInputOutputCircles() {
        switch (gate.getType()) {
            case "AND":
            case "NAND":
            case "OR":
            case "NOR":
            case "XOR":
            case "XNOR":
                addInputCircle(0);
                addInputCircle(15);
                addOutputCircle(10);
                break;
            case "NOT":
                addInputCircle(10);
                addOutputCircle(10);
                break;
        }
    }

    // Agrega un círculo de entrada
    private void addInputCircle(double yPosition) {
        Circle inputCircle = new Circle(5, Color.BLACK);
        inputCircle.setTranslateX(-18); // Posición de entrada
        inputCircle.setTranslateY(yPosition - 6);
        getChildren().add(inputCircle);
    }

    // Agrega un círculo de salida
    private void addOutputCircle(double yPosition) {
        Circle outputCircle = new Circle(5, Color.BLACK);
        outputCircle.setTranslateX(27); // Posición de salida
        outputCircle.setTranslateY(yPosition - 8);
        getChildren().add(outputCircle);
    }

    // Crea una compuerta AND
    private void createAndGate() {
        Polygon andGate = new Polygon();
        andGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            0.0, 0.0
        );
        andGate.setFill(Color.LIGHTBLUE);
        andGate.setStroke(Color.BLACK);
        getChildren().add(andGate);
    }

    // Crea una compuerta OR
    private void createOrGate() {
        Polygon orGate = new Polygon();
        orGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            10.0, 25.0
        );
        orGate.setFill(Color.LIGHTGREEN);
        orGate.setStroke(Color.BLACK);
        getChildren().add(orGate);
    }

    // Crea una compuerta NOT
    private void createNotGate() {
        Polygon notGate = new Polygon();
        notGate.getPoints().addAll(
            0.0, 0.0,
            50.0, 25.0,
            0.0, 50.0
        );
        notGate.setFill(Color.LIGHTPINK);
        notGate.setStroke(Color.BLACK);
        getChildren().add(notGate);

        Circle circle = new Circle(55, 25, 5);
        circle.setFill(Color.LIGHTPINK);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(20); // Mover el círculo a la punta
        getChildren().add(circle);
    }

    // Crea una compuerta NAND
    private void createNandGate() {
        Polygon nandGate = new Polygon();
        nandGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            0.0, 0.0
        );
        nandGate.setFill(Color.LIGHTYELLOW);
        nandGate.setStroke(Color.BLACK);
        getChildren().add(nandGate);

        Circle circle = new Circle(55, 25, 5);
        circle.setFill(Color.LIGHTYELLOW);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(20); // Mover el círculo a la punta
        getChildren().add(circle);
    }

    // Crea una compuerta NOR
    private void createNorGate() {
        Polygon norGate = new Polygon();
        norGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            10.0, 25.0
        );
        norGate.setFill(Color.LIGHTCORAL);
        norGate.setStroke(Color.BLACK);
        getChildren().add(norGate);

        Circle circle = new Circle(55, 25, 5);
        circle.setFill(Color.LIGHTCORAL);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(20); // Mover el círculo a la punta
        getChildren().add(circle);
    }

    // Crea una compuerta XOR
    private void createXorGate() {
        Polygon xorGate = new Polygon();
        xorGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            10.0, 25.0
        );
        xorGate.setFill(Color.LIGHTCYAN);
        xorGate.setStroke(Color.BLACK);
        getChildren().add(xorGate);

        Line line = new Line(-5, 0, -5, 50);
        line.setStroke(Color.BLACK);
        getChildren().add(line);
    }

    // Crea una compuerta XNOR
    private void createXnorGate() {
        Polygon xnorGate = new Polygon();
        xnorGate.getPoints().addAll(
            0.0, 0.0,
            30.0, 0.0,
            50.0, 25.0,
            30.0, 50.0,
            0.0, 50.0,
            10.0, 25.0
        );
        xnorGate.setFill(Color.LIGHTGOLDENRODYELLOW);
        xnorGate.setStroke(Color.BLACK);
        getChildren().add(xnorGate);

        Line line = new Line(-5, 0, -5, 50);
        line.setStroke(Color.BLACK);
        getChildren().add(line);

        Circle circle = new Circle(55, 25, 5);
        circle.setFill(Color.LIGHTGOLDENRODYELLOW);
        circle.setStroke(Color.BLACK);
        circle.setTranslateX(20); // Mover el círculo a la punta
        getChildren().add(circle);
    }

    public LogicGate getGate() {
        return gate;
    }
}
