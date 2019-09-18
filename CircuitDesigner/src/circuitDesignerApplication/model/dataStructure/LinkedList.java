package circuitDesignerApplication.model.dataStructure;

public class LinkedList {
	
	private Nodo head;
	private int size;
	
	
	public LinkedList () {
	        this.head = null;
	        this.size = 0;
	    }
	
	public boolean isEmpty() {
		return head==null;
		}
	
	public int getSize() {
		return size;
		}

	public Object search(Object value){ 
		if (head != null){
			
			Nodo aux = head;
			int cont = 0;
			
			while (aux != null){
				if (aux.getData() == value){
					return cont;
					}else{
						cont++;
						aux = aux.getNext();
						}
				return -1;
				}
	        }
		return null;
		}
	
	    public Object getDatabyIndex(int index){
	         Nodo current= this.head;
	         int a = 0;
	         while(a!=this.size){
	             if(index==a){
	                 return current.getData();
	             } else {
	                 current=current.getNext();
	                 a++;
	             }
	         }
	         return -1;
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
	    
	    public void insertFirst(Object data){
	        Nodo NewNode= new Nodo();
	        NewNode.setData(data);
	        
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
	                System.out.print(i + ".[ " + aux.getData()+ " ]" + " ->  ");
	                aux = aux.getNext();
	                i++;
	                }
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
	    
	    
	    
	    public void insertByPosicion(int posicion, Object valor){
	            if(posicion>=0 && posicion<=size){
	            	Nodo newNode = new Nodo();
	            	newNode.setData(valor);
	                if(posicion == 0){
	                	newNode.setNext(head);
	                    head = newNode;
	                    }else{
	                    	
	                    	if(posicion == size){
	                    		Nodo aux = head;
	                    		
	                    		while(aux.getNext() != null){
	                    			aux = aux.getNext();
	                    			}
	                    		aux.setNext(newNode);
	                    		}else{
	                    			Nodo aux = head;
	                    			for (int i = 0; i < (posicion-1); i++) {
	                    				aux = aux.getNext();
	                    				}
	                    			Nodo siguiente = aux.getNext();
	                    			aux.setNext(newNode);
	                    			newNode.setNext(siguiente);
	                    			}
	                    	}
	                size++;
	                }
	            }
	    }

