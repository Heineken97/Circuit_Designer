/** * @author Heineken97 - Joseph Jimenez */
package controller;
import javafx.scene.shape.Line;
import model.*;
import view.MainView;
import view.LogicGateNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainController {
    private MainView view;
    private Random random;
    private List<LogicGate> gates;
    private List<Wire> wires;

    public MainController(MainView view) {
        this.view = view;
        this.random = new Random();
        this.gates = new ArrayList<>();
        this.wires = new ArrayList<>();
    }

    public void addGate(String gateType) {
        LogicGate gate;
        switch (gateType) {
            case "AND":
                gate = new AndGate(generateId(), null, null);
                break;
            case "OR":
                gate = new OrGate(generateId(), null, null);
                break;
            case "NOT":
                gate = new NotGate(generateId(), null);
                break;
            case "NAND":
                gate = new NandGate(generateId(), null, null);
                break;
            case "NOR":
                gate = new NorGate(generateId(), null, null);
                break;
            case "XOR":
                gate = new XorGate(generateId(), null, null);
                break;
            case "XNOR":
                gate = new XnorGate(generateId(), null, null);
                break;
            default:
                throw new IllegalArgumentException("Unknown gate type: " + gateType);
        }

        LogicGateNode gateNode = new LogicGateNode(gate, this);
        gateNode.setLayoutX(random.nextInt((int) view.getDrawingPane().getWidth() - 50));
        gateNode.setLayoutY(random.nextInt((int) view.getDrawingPane().getHeight() - 50));
        view.addGateToPane(gateNode);
        gates.add(gate);
    }

    public void connectGates(LogicGate outputGate, LogicGate inputGate) {
        Wire wire = new Wire(outputGate, inputGate);
        wires.add(wire);

        LogicGateNode outputNode = findNodeByGate(outputGate);
        LogicGateNode inputNode = findNodeByGate(inputGate);

        if (outputNode != null && inputNode != null) {
            Line line = new Line();
            line.startXProperty().bind(outputNode.layoutXProperty().add(outputNode.getWidth() / 2));
            line.startYProperty().bind(outputNode.layoutYProperty().add(outputNode.getHeight() / 2));
            line.endXProperty().bind(inputNode.layoutXProperty().add(inputNode.getWidth() / 2));
            line.endYProperty().bind(inputNode.layoutYProperty().add(inputNode.getHeight() / 2));

            view.getDrawingPane().getChildren().add(line);
        }
    }

    private LogicGateNode findNodeByGate(LogicGate gate) {
        for (LogicGateNode node : view.getGateNodes()) {
            if (node.getGate().getId().equals(gate.getId())) {
                return node;
            }
        }
        return null;
    }

    private String generateId() {
        return "Gate-" + random.nextInt(1000);
    }
}