package circuitDesignerApplication.model.dataStructure;

public class Nodo {
	private Object data;
    private Nodo next;

    public Nodo() {
        this.data = null;
        this.next = null;
    }
    
    public Nodo(Object data2) {
    	this.data = data2;
        this.next = null;
	}
    ///Getters
	public Object getData() {
        return data;
    }
    public Nodo getNext() {
        return next;
    }
    
    ///Setters
    public void setData(Object Data) {
        this.data = Data;
    }

    public void setNext(Nodo Next) {
        this.next = Next;
    }

 
}

