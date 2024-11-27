/** * @author Heineken97 - Joseph Jimenez */
package model;

public class NotGate extends LogicGate {
    private LogicGate input;

    public NotGate(String id, LogicGate input) {
        super(id, "NOT");
        this.input = input;
    }

    @Override
    public boolean evaluate() {
        return !input.evaluate();
    }
}
