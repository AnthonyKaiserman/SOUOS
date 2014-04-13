package os;

//Class for maintaining a doubly linked list of processors.
public class ProcessList
{ 
	private Process     head;
	private Process     tail;
	
	public ProcessList()			// Constructor.
	{
		head = tail = null;
	}
//	public Process setPriority(long id, int priority) // Change priority.
//	{
//		return Process;
//	}
//	public String toString()
//	{
//		
//	}
	public boolean isEmpty()        // Check if queue is Empty.
	{
		if(peek() == null)			//if head is null the list isEmpty
			return true;
		else 
			return false;
	}
	public Process peek(){          // Return the process at the head.
		return head;
	}
	public void enQueue(Process p)  // Add process to the tail.
	{
		
	}
	public Process deQueue()        // Remove from the head.
	{
		Process temp = peek();		// temp stores head 
		head = head.next;
		return temp;
	}
//	public Process remove(long id)  // Remove process from the list.
//	{
//		
//	}
	public Process find(long id)   // Find process in the queue.
	{
		Process current = peek();
		if(current != null){
			if (current.getId() == id)
				return current;
			else
				current = current.next;
		}
		return null;
	}
}
