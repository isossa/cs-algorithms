package algorithms;

public class LinkedList<T>
{
	private ListNode<T> head;
	private int length;
    
    /** Initialize your data structure here. */
    public LinkedList()
    {
        head = null;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public T get(int index) 
    {
        if (index >= 0 && index < length)
        {
            int counter = 0;
            ListNode<T> next = head;
            
            while (counter++ < index)
            {
                next = next.next;
            }
            
            return next.data;
        }
        
        return null;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(T data) 
    {
        ListNode<T> newHead = new ListNode<T>(data);
        newHead.next = head;
        head = newHead;
        length++;
    }
    
    /** Append a node of value data to the last element of the linked list. */
    public void addAtTail(T data) 
    {
        ListNode<T> current = head;
        
        while (current.next != null)
        {
            current = current.next;
        }
        
        current.next = new ListNode<T>(data);
        length++;
    }
    
    /** Add a node of value data before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, T data)
    {
        if (index == 0)
        {
            addAtHead(data);
        }
        else if (index == length)
        {
            addAtTail(data);
        }
        else if (index > 0 && index < length)
        {
            ListNode<T> current = head;
            int counter = 0;
            
            while (++counter < index)
            {
                current = current.next;
            }
            ListNode<T> temp = current.next;
            current.next = new ListNode<T>(data, temp);
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index)
    {
        if (index >= 0  && index < length)
        {
            if (index == 0)
            {
                head = head.next;
            }
            else
            {
                ListNode<T> current = head;
                int counter = 0;
                
                while (++counter < index)
                {
                    current = current.next;
                }
                current.next = current.next.next;
            }
            
            length--;
        }
    }
    
	// Search for a key
	public static ListNode<Integer> search(ListNode<Integer> headIn, int key)
	{
		while (headIn != null && headIn.data != key)
		{
			headIn = headIn.next;
		}
		return headIn;
	}
	
	// Insert a node after a specified node
	public static void insert(ListNode<Integer> node, ListNode<Integer> toInsert)
	{
		toInsert.next = node.next;
		node.next = toInsert;
	}
	
	// Delete node after node
	public static void delete(ListNode<Integer> node)
	{
		node.next = node.next.next;
	}
}

class ListNode<T>
{
	T data;
	ListNode<T> next;
	
	ListNode(T dataIn)
    {
        this(dataIn, null);
    }
    
    ListNode(T dataIn, ListNode<T> nextIn)
    {
        data = dataIn;
        next = nextIn;
    }
}
