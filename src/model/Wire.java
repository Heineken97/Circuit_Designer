/** * @author Heineken97 - Joseph Jimenez */
package model;
public class Wire {
    private LogicGate input;
    private LogicGate output;

    public Wire(LogicGate input, LogicGate output) {
        this.input = input;
        this.output = output;
    }

    public LogicGate getInput() {
        return input;
    }

    public LogicGate getOutput() {
        return output;
    }
}
