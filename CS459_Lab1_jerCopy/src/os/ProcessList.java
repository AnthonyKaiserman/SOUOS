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
	public Process setPriority(long id, int priority) // Change priority.
	{
		Process process = find(id);
		if(process==null)
			return null;
		else
			process.setPriority(priority);
		return process;
	}
	public String toString()
	{
		String s="Current batch queue\n"+
				 "Name\t\tID\tStatus\tRunTime\tPriority Arguments\n";
	
		Process p = peek();
		if(p == null)
			return s;
		while(p!=null){
			s = s + p.toString() + "\n";
			p = p.next;
		}
		return s;	
	}
	public boolean isEmpty()        // Check if queue is Empty.
	{
		if(peek() == null)			//if head is null the list isEmpty
			return true;
		else 
			return false;
	}
	public Process peek()			// Return the process at the head.
	{          
		return this.head;
	}
	public void enQueue(Process p)  // Add process to the tail.
	{
		if(head == null)
			head = tail = p;
		else{
			tail.next = p;
			p.previous = tail;
			tail = p;
		}
	}
	public Process deQueue()        // Remove from the head.
	{
		Process temp = peek();		// temp stores head 
		head = head.next;
		return temp;
	}
	public Process remove(long id)  // Remove process from the list.
	{
		Process p = find(id);
		if(p != null){
			if(p == peek()){					//if head make new head
				head = p.next;
				head.previous = null;
				return p;
			}else if(p == tail){				//if tail make new tail
				p.previous = tail;
				p.previous.next = null;
				return p;
			}else{								//else link around p
				p.next.previous = p.previous; 
				p.previous.next = p.next;
				return p;
			}
				
		}else									//if not found return null
			return p;
		
	}
	public Process find(long id)   // Find process in the queue.
	{
		Process current = peek();
		if(current != null){
			if (current.getId() == id)
				return current;
			else
				current = current.next;
		}
		return current;
	}
}
