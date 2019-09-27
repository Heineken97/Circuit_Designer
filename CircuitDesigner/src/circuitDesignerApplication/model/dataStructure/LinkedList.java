package circuitDesignerApplication.model.dataStructure;

import java.util.Iterator;

public class LinkedList<Object> implements Iterable<Object> {
	
	private Nodo head=null;;
	private int size;
	
	
	public LinkedList () {
	        head = null;
	        size = 0;
	    }
	
	public boolean isEmpty() {
		return head==null;
		}
	
	public int getSize() {
		return size;
		}
	
	@Override
	public Iterator<Object> iterator() { 
        return new ListIterator<Object>(this); 
    } 

	
	public Nodo getHead() { 
        return head; 
    } 


	public void insertLast(Object data){
		Nodo NewNode= new Nodo();
		NewNode.setData(data);
		
		if (isEmpty()){
			head=NewNode;
			}else{
				Nodo aux = head;
				while(aux.getNext()!= null){
					aux= aux.getNext();
					}
				aux.setNext(NewNode);
				}
		size++;
		}
	public void enlistar(){
        if (!isEmpty()) {
            Nodo aux = head;
            int i = 0;
            while(aux != null){
                System.out.print(i + ".[ " + aux.getData()+ " ]" + " ->  ");
                aux = aux.getNext();
                i++;
            }
        }
    }
	
	
	public void insertFirst(Object data){
		Nodo NewNode= new Nodo();
		NewNode.setData(data);
		NewNode.setNext(null);
		
		if (isEmpty()){
			head=NewNode;
		}else{
			NewNode.setNext(head);
			head=NewNode;
			}
		size++;
		}
	
	
	public void printAllNodes(){
		if (!isEmpty()) {
			Nodo aux = head;
			int i = 0;
			while(aux != null){
				System.out.print(i + ".[ " +aux.getData()+ " ]" + " ->  ");
				aux = aux.getNext();
				i++;
				}
			}
		}
	
	public void remove(Object item) {
		Nodo current=this.head;
		Nodo previous= null;
		boolean found= false;
		while(found==false) {
			if(current.getData()==item) {
				found=true;
				}else {
					previous=current;
					current=current.getNext();
					}
			}
		if(previous==null) {
			this.head=current.getNext();
			}else {
				previous.setNext(current.getNext());
				}
		}
	
	public void removeByPosicion(int posicion){
		if(posicion>=0 && posicion<size){
			
			if(posicion == 0){
				head = head.getNext();
				}else{
					
					Nodo aux = head;
					for (int i = 0; i < posicion-1; i++) {
						aux = aux.getNext();
						}
					
					Nodo siguiente = aux.getNext();
					aux.setNext(siguiente.getNext());
					}
			size--;
			}
		}
	}

