
public class myQueue<T> implements Queue<T> {

//	//the size of the queue is 1 because my linkedlist file takes in data as a parameter
//	//therefore the size of the queue begins with one and is incrememented as more elements
//	//are added to it
//	int sizeQueue = 1;
//
//	
//
//	URLinkedList<AnyType> myNewList;
//	//public <AnyType> arr[];
//
//	
//	public myQueue(AnyType k) {
//
//		myNewList = new URLinkedList<AnyType>(k);
//
//	}
//
//	//check if the queue is empty
//	public boolean isEmpty() {
//
//		if (sizeQueue == 0) {
//
//			return true;
//
//		}
//
//		return false;
//
//	}
//
//	//add elements to the queue
//	public void enqueue(AnyType x) {
//
//		myNewList.add(x);
//
//		
//
////		System.out.println("Element " + sizeQueue + " is added into queue");
//		sizeQueue++;
//	}
//
//	//remove elements from the queue in the FIFO principle
//	public AnyType dequeue() {
//
//		if (isEmpty()) {
//
//			return null;
//
//		}
//
//		sizeQueue--;
//
//		return myNewList.pollFirst();
//
//	}
//
//	//check what is at the top of the queue
//	public AnyType peek() {
//
//		if (isEmpty()) {
//
//			return null;
//
//		}
//		return myNewList.peekFirst();
//
//	}
//	public void printQueue2() {
//		AnyType[] arr = (AnyType[]) myNewList.toArray();
//		System.out.print("[ ");
//		for (int i = 0; i< arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println("]");
//	}
//	
//	public void printQueue() {
//		myNewList.printList();
//	}
	
	private MyLinkedList<T> data; // my new list

	public myQueue(T k) {
		data = new MyLinkedList<T>(k);

	}
	
	//check if the stack is empty
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	//add elements to the stack
	public void enqueue(T x) {
		
		data.addLast(x);

	}
	
	//remove elements from the queue in the LIFO principle
	public T dequeue() {

		if (isEmpty()) {
			return null;
		}

		return data.pollFirst();

	}
	
	//check what is at the top of the stack
	public T peek() {
		
		if (isEmpty()) {

			return null;
		}
	
		return data.peekFirst();
	}
	
	public void printQueue() {
		
		System.out.println(data.toString());
	}
	
	public String toString() {
		return data.toString();
	}
	
	
//main method which has test cases shown
	public static void main(String args[]) {
		
		myQueue<Integer> test = new myQueue<>(0);
		
		System.out.println("trying out as a queue:");
		test.enqueue(10);
		test.enqueue(20);
		test.enqueue(30);
		System.out.println("test: " + test);
		
		while (!test.isEmpty()) {
			Integer x = test.peek();
			System.out.println("top: " + x);
			test.dequeue();
		}
		
		System.out.println("test: " + test);
		

//		myQueue theQueue = new myQueue(9);
//
//		theQueue.enqueue(100);
//
//		theQueue.enqueue(200);
//
//		theQueue.enqueue(300);
//
//		theQueue.enqueue(400);
//
//		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
//		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
//
//		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
//		System.out.println("removing/dequeing of element " + "'" + theQueue.dequeue() + "'");
//		// System.out.println("the top of the stack contains "+ theStack.peek());
//
//		System.out.println();
//		System.out.println("here is the current size of the queue: " + theQueue.sizeQueue);
//
//		System.out.println("peeking element on top of the queue " + theQueue.peek());

		// System.out.println(
		// "here is the check for the method " + theQueue.topOfStack + " the size is " +
		// theStack.sizeOfStack);

	}

}