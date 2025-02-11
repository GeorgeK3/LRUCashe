import java.io.PrintStream;
import java.util.NoSuchElementException;

public class QueueImpl<T> implements Queue<T> {

	Node<T> head = null;
	Node<T> tail = null;
	int size = 0;

    public boolean isEmpty(){
		return head == null;
	}

	public void put(T item){

		Node<T> n = new Node<>(item);
		size ++;

		if (isEmpty()){
			head = n;
			tail = n;
		}else{
			tail.setNext(n);
			tail = n;
		}
	}

	public T get() throws NoSuchElementException{
		if (isEmpty()){
			throw new NoSuchElementException();
		}else{
			Node<T> n = head;
			head = head.getNext();
			size--;
			return n.getData();
		}
	}

	public void update(T item) throws NoSuchElementException{
		if (head.getData()== item){
			return ;
		}else{
			Node n = head;
			while (n.next!=null){
				if (n.next.getData()==item){

					T data = (T) n.next.getData();

					n.setNext(n.next.next);

					put(data);

					return ;
					
				}
				n = n.next;
			}

			put(item);
			return ;

		}
	}

	public T peek() throws NoSuchElementException{
		if (isEmpty()){
			throw new NoSuchElementException();
		}else{
			return head.getData();
		}
	}

	public void printQueue(PrintStream stream){
		if (isEmpty()){
            stream.println("The Queue is Empty!!!");
        }else{
            for (Node<T> i = head; i != null ; i = i.getNext() ){
				if (i == head){
                	stream.println("\nHEAD --> " + i.getData());
				}else if (i == tail){
					stream.println("TAIL --> " + i.getData());
				}else{
					stream.println("\t " + i.getData());
				}
            }
        }
	}

	public int size(){
		return size;
	}
} 
