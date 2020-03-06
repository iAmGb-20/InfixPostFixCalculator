import java.util.Collection;
import java.util.Iterator;

public class URLinkedList<AnyType> implements Iterable<AnyType>, URList<AnyType> {
	URNode<AnyType> head;
	URNode<AnyType> lastNode;

	URLinkedList(AnyType data) {
// constructor initializing the data
		URNode<AnyType> a = new URNode<AnyType>(data, null, null);
		head = a;
		lastNode = a;
	}

	private int mySize = size();

	public void addFirst(AnyType e) throws NullPointerException {
		URNode<AnyType> newNode = new URNode<AnyType>(e, null, null);
		if (head == null) {
// if the list is empty
			head = newNode;
		} else {
// the element is added to the beginning of the Linked list
			head.setPrev(newNode);
			newNode.setNext(head);
			newNode.setPrev(null);
			head = newNode;
			mySize++;
		}
	}

	public void addLast(AnyType e) {
		URNode<AnyType> lastone = new URNode<AnyType>(e, null, null);

		lastNode.setNext(lastone);// lastnode becomes lastone
		lastone.setPrev(lastNode);// the previous of lastone becomes lastnode
		lastNode = lastone;// lastone is the new lastnode
		mySize++;
	}

	@Override
	public boolean add(AnyType e) {
		URNode<AnyType> myNode = new URNode<AnyType>(e, null, null);
// adding node with element e at the end of the list
		lastNode.setNext(myNode);
		myNode.setPrev(lastNode);
		lastNode = myNode;

		return true;
	}

	@Override
	public void add(int index, AnyType element) {
// adding element at given index
		int count = 0;

		URNode<AnyType> myNode = new URNode<AnyType>(element, null, null);
		URNode<AnyType> current = head;
		while (count < index - 1) {
// iterating till we reach that index we are going to add node
			count++;
			if (current.next() != null) {
				current = current.next();
			}
		}
		current.next().setPrev(myNode);
		myNode.setNext(current.next());

		current.setNext(myNode);
		myNode.setPrev(current);
		mySize++;
	}

	@Override
	public boolean addAll(Collection<? extends AnyType> c) {
// Adding all elements in the collection
		for (AnyType i : c) {
			add(i);
			mySize++;
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends AnyType> c) {
// adding all elements in the collection at the given index
		for (AnyType i : c) {
			add(index, i);
			index++;
			mySize++;
		}
		return true;
	}

	@Override
	public void clear() {

		URNode<AnyType> a = new URNode<AnyType>(null, null, null);
		head = a;
		lastNode = a;
		mySize = 0;
	}

	@Override
	public boolean contains(Object o) {
		URNode<AnyType> temp = head;
// iterating through the linkedlist to look for the object
		while (temp.next() != null) {
			temp = temp.next();
			if (temp.element().equals(o)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		URNode<AnyType> temp = head;
		int x = 0, y = 0;
		while (temp.next() != null) {
			temp = temp.next();
			for (Object i : c) {
				x++;
				if (temp.element().equals(i)) {
					y++;
				}
			}

		}
		if (x == y) {
			return true;
		}
		return false;
	}

	@Override
	public AnyType get(int index) throws NullPointerException {
		int count = 0;
		if (head == null) {
			throw new NullPointerException();
		}
		URNode<AnyType> toGet = head;

		while (count < index) {

			count++;
			if (toGet.next() != null) {
				toGet = toGet.next();
			}
		}

		return toGet.element();
	}

	@Override
	public int indexOf(Object o) {
		int counter = 0;
		URNode<AnyType> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;
			if (temp.element().equals(o)) {
				return counter;

			}

		}
		return -1;
	}

	@Override
	public boolean isEmpty() {

		return head.element().equals(null);
	}

// added size here
	@Override
	public AnyType remove(int index) {
		int count = 0;
		int mySize = size();
		URNode<AnyType> removehim = head;
		while (count < index) {

			count++;
			if (removehim.next() != null) {
				removehim = removehim.next();
			}
		}
		removehim.prev().setNext(removehim.next());
		removehim.next().setPrev(removehim.prev());
		mySize--;

		return removehim.element();
	}

	@Override
	public boolean remove(Object o) {
		int counter = 0;
		URNode<AnyType> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;
			if (temp.element().equals(o)) {
				remove(counter);
				return true;
			}

		}
		mySize--;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object i : c) {
			remove(i);
			mySize--;
		}
		return true;
	}

	@Override
	public AnyType set(int index, AnyType element) {
		int count = 0;
		URNode<AnyType> setHim = head;
		while (count < index) {
			count++;
			if (setHim.next() != null) {
				setHim = setHim.next();
			}
		}
		setHim.setElement(element);

		return setHim.element();
	}

	@Override
	public int size() {
		if (head == null) {
			return 0;
		}
		int counter = 0;
		URNode<AnyType> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;

		}
		return counter;
	}

// additional method that returns a node in an index
	public URNode<AnyType> getNode(int index) throws IndexOutOfBoundsException {
		URNode<AnyType> check = head;
		int countMe = 0;
		while (check != null) {
			if (countMe == index) {
				return check;
			}
			countMe++;
			check = check.next();
		}
		throw new NullPointerException();
	}

// additional method to add a node to a list, should i increment size?
	public void addNode(URNode<AnyType> node) {
		if (head == null) {
			head = node;
		} else {
			getLastNode().setNext(node);
		}

	}

// additional method to get the last node in the list
	public URNode<AnyType> getLastNode() throws NullPointerException {
		URNode<AnyType> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
		}
		return temp;
	}

// check later and improve
	@Override
	public URList<AnyType> subList(int fromIndex, int toIndex) throws NullPointerException {
		if (fromIndex < 0 || toIndex < fromIndex) {
			throw new NullPointerException();
		}

		URLinkedList<AnyType> mySubList = new URLinkedList<AnyType>(null);
		URNode<AnyType> intheIndex = getNode(fromIndex);
// intheIndex = head;
		int i = 0;
		int difference = toIndex - fromIndex;
		while (intheIndex != null) {
			if (i <= difference) {
				mySubList.addNode(intheIndex);
			}
			intheIndex = intheIndex.next();
			i++;
		}

		return mySubList;
	}

	public void printAnyList(URList<AnyType> c) {

	}

	@Override
	public Object[] toArray() {
		int counter = 0;

		URNode<AnyType> loop = head;
		while (loop.next() != null) {
			loop = loop.next();
			counter++;
		}
		Object[] myArray = new Object[counter];
		URNode<AnyType> loop2 = head;
		int i = 0;
		while (loop2.next() != null) {
			myArray[i] = loop2.element();
			loop2 = loop2.next();
			i++;
		}
		return myArray;
	}

	public AnyType peekFirst() throws NullPointerException {
		if (head != null) {
			return head.element();
		} else {
			throw new NullPointerException();
		}
	}
	public AnyType rPeekFirst(int index) {
		while (!isEmpty()) {
			if(head != null) {
				return head.element();
				
			}
			if(head.next()!=null) {
				return head.next().element();
			}
		}
		throw new NullPointerException();
	}

	public AnyType peekLast() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return getLastNode().element();
	}

	public AnyType pollFirst() {

		URNode<AnyType> temp = head;
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			head.next().setPrev(null);
			head = head.next();

		}
		return temp.element();
	}

// help change this a bit
	public AnyType pollLast() {
		URNode<AnyType> notNeeded = new URNode<AnyType>(lastNode.element(), null, null);
		if (isEmpty()) {
			throw new NullPointerException();
		} else {
			getLastNode().prev().setNext(null);

		}
		return notNeeded.element();
	}

// additional method..help here
	public void removingDuplicateElements() {
		if (head == null) {
			return;
		}
		int counter = 0;
		URNode<AnyType> temp = head;
		while (temp.next() != null) {
			temp = temp.next();
			counter++;

		}
		for (int i = 0; i < size(); i++) {
			for (int j = 1; j < size() - 1; j++) {
				if (getNode(i).element().equals(getNode(j).element())) {
					counter = counter - 1;

				}
			}
		}
	}

// should we put size()++ whenever we add an element to the linked list??
// iterator(additional) method
	public boolean hasNext() {
		URNode<AnyType> currentNode = head;
		return currentNode.next() != null;
	}

	public AnyType Next() {
		URNode<AnyType> currentNode = head;
		if (!hasNext()) {
			throw new NullPointerException();
		}
		AnyType element = currentNode.element();
		currentNode = currentNode.next();
		return element;
	}

// additional method
	public void printmyList() {
		URNode<AnyType> temp = head;
		while (iterator().hasNext()) {
// finish this
		}
	}

// print without iterator
	public void printList() throws NullPointerException {
		URNode<AnyType> temp = head;
		if (isEmpty()) {
			throw new NullPointerException();
		}
//		System.out.println("here are the nodes of my doubly linked list: ");
		System.out.print("[ ");
		while (temp != null) {
			System.out.print(temp.element() + " ");
			temp = temp.next();
		}
		System.out.println("]");
	}

	@Override
	public Iterator<AnyType> iterator() {

		return this.iterator();

	}

	public static void main(String[] args) {
		URLinkedList<Integer> linkedlist = new URLinkedList<Integer>(1);
// testing for all the methods
		linkedlist.printList();
		linkedlist.add(22);
		linkedlist.printList();
		linkedlist.addFirst(30);
		linkedlist.printList();
		linkedlist.addFirst(10);
		linkedlist.printList();
		System.out.println("here is the test for pollfirst");
		System.out.println("here is the test for object to array");
// System.out.println(linkedlist.toArray().toString());
		linkedlist.set(0, 1000);
		linkedlist.printList();

	}

	@Override
	public boolean isAnytypempty() {
		// TODO Auto-generated method stub
		return false;
	}

}
