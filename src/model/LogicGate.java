/** * @author Heineken97 - Joseph Jimenez */
package model;
public abstract class LogicGate {
    private String id;
    private String type;
    public LogicGate(String id, String type) {
        this.id = id;
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public abstract boolean evaluate();
}
