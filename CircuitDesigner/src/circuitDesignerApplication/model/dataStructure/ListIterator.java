package circuitDesignerApplication.model.dataStructure;

import java.util.Iterator;

public class ListIterator <Object> implements Iterator<Object> { 
	Nodo current; 

    public ListIterator(LinkedList<Object> list)  { 
        current = list.getHead();
    } 
    public boolean hasNext(){ 
        return current != null; 
    } 
    public Object next() { 
        Object data = (Object) current.getData(); 
        current = current.getNext(); 
        return data; 
    } 
      
    public void remove()  { 
        throw new UnsupportedOperationException(); 
    }  
}
