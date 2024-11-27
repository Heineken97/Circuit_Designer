/** * @author Heineken97 - Joseph Jimenez */
package model;

public class AndGate extends LogicGate {
    private LogicGate input1;
    private LogicGate input2;

    public AndGate(String id, LogicGate input1, LogicGate input2) {
        super(id, "AND");
        this.input1 = input1;
        this.input2 = input2;
    }

    @Override
    public boolean evaluate() {
        return input1.evaluate() && input2.evaluate();
    }
}
