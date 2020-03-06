
public class myStack<T> implements Stack<T> {

	private MyLinkedList<T> data; // my new list

	public myStack(T k) {
		data = new MyLinkedList<T>(k);

	}
	//check if the stack is empty
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	//add elements to the stack
	public void push(T x) {
		
		data.addFirst(x);

	}
	
	//remove elements from the queue in the LIFO principle
	public T pop() {

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
	
	public void printStack() {
		
		System.out.println(data.toString());
	}
	
	public String toString() {
		return data.toString();
	}
	
	//main method with test cases
	public static void main(String args[]) {
		
		myStack<Integer> test = new myStack<>(0);
		
		System.out.println("trying out as a stack:");
		test.push(10);
		test.push(20);
		test.push(30);
		System.out.println("test: " + test);
		
		while (!test.isEmpty()) {
			Integer x = test.peek();
			System.out.println("top: " + x);
			test.pop();
		}
		
		System.out.println("test: " + test);
		
//		myStack theStack = new myStack(10);
//		theStack.push(1);
//		theStack.push(2);
//		theStack.push(3);
//		theStack.push(4);
//		System.out.println("now the current size of the stack is "+ theStack.sizeOfStack);
//		System.out.println("pop out element " + "'" + theStack.pop() + "'");
//		System.out.println("pop out element " + "'" + theStack.pop() + "'");
//		System.out.println("pop out element " + "'" + theStack.pop() + "'");
//		System.out.println("pop out element " + "'" + theStack.pop() + "'");
//		System.out.println("the top of the stack contains " + theStack.peek()+ " and the size is "+ theStack.sizeOfStack);
//		System.out.println();
		
	}

}
