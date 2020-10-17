public class LinkedLists<E>
{
//we will use all this data later
	private Node<E> head;
	private int size;

	private class Node<E>
	{
		E data;
		Node<E> next;

		private Node(E data)
		{
			this.data = data;
			Node<E> next =null;
		}
	}

	public LinkedLists()
	{
		head = null;
		size=0;
	}	

		//function to add an item to the Linked List, follows what we learned in class
		public void add(E node)
		{
		Node<E> nextNode = new Node<E>(node);
		Node<E> prev = head;
		if(head == null) //head is a special case
		{
			head = new Node<E>(node);
			size++;
		}
		else
		{
			for (int i = 0; i < size; i++)
			{
				
				if(prev.next != null)
					prev = prev.next;
			}
			prev.next = nextNode;
			size++;
		}
	}
		
	
//function to add an item with a specific position to the Linked List, follows what we learned in class
	public void add(E node, int pos)
	{
		if(pos == 0) //special case for the head
		{
			Node<E> newNode = new Node<E>(node);
			newNode.next = head;
			head = newNode;
			size++;
		}
		else 
		{
			Node<E> prev = head;
			for(int i = 0; i < pos - 1; i ++)
			{
				prev = prev.next;
			}
			Node<E> newNode = new Node<E>(node);
			newNode.next = prev.next;
			prev.next = newNode;
			size++;
		}
	}

//function to get an item to the Linked List, follows what we learned in class
	public Node<E> get(int pos) 
	{ 
		Node<E> prev = head;
		
		for(int i = 0; i < pos && prev.next != null; i ++) 
			prev = prev.next;

		if(prev.next ==null)
			return null; //makes sure it isnt empty

		else
			return prev;
	}


//function to remove an item to the Linked List, follows what we learned in class
	public Node<E> remove(int pos)
	{
		if(pos == 0)
		{
			Node<E> node = head;
			head = head.next;
			size--;
			return node;
		}
		else
		{
			Node<E> prev = head;
			for(int i = 0; i < pos - 1; i ++) 
				prev = prev.next;

			Node<E> node = prev.next;
			prev.next = node.next;
			size--;
			return node;
		}
	}

//function to reverse an item to the Linked List
	public Node<E> reverse()
	{
		Node<E> curr = head;
		Node<E> prev = null, next = head;

		while(curr != null) //makes sure it is not empty
		{
			next = next.next;
			curr.next = prev;
			prev = curr;
			curr = next;		
		}

		head = prev;
		return prev;
	}

	//prints the list
	public void printList()
	{
		if(head == null)
		{
			System.out.println("There is nothing in this Linked List");
		}
		else
		{
			Node<E> prev = head;
			while(prev.next != null)
			{
				System.out.print(prev.data + " ");
				prev=prev.next;
			}
			System.out.println(prev.data);
		}
	}

	public static void main(String [] args)
	{

		LinkedLists linkedList = new LinkedLists();
		
		//adds to the linked list one at a time
		linkedList.add("this");
		linkedList.add("is");
		linkedList.add("before");
		linkedList.add("removing");

		System.out.println("\nIndex 2 of the Linked List:");
		System.out.println(linkedList.get(2).data); //gets item in position 2

		System.out.println("\nEntire linked list:");
		linkedList.printList();
		System.out.println();

		linkedList.remove(3); //removes item in position 3 and prints it
		linkedList.printList();

		linkedList.add("reversing", 3); //adds word to position 3
		linkedList.printList();

		linkedList.reverse(); //reverses linked list and prints it
		linkedList.printList();


	}
}