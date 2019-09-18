package circuitDesignerApplication.model.dataStructure;

public class Nodo {
	private Object data;
    private Nodo next;
    private Nodo previous;

    public Nodo() {
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object Data) {
        this.data = Data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo Next) {
        this.next = Next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo Previous) {
        this.previous = Previous;
    }
 
}

