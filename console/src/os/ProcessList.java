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
		Process process=this.find(id);
		if(process==null)
		{
			return null;
		}
		else
		{
			process.setPriority(priority);
		}
		return process;
	}
	public String toString()
	{
		String s=	"Current batch queue/n"+
					"Name/tID/tStatus/tRunTime/tPriority/tArguments/n";
		
		Process p=this.head;
		if(p==null)
		{
			return null;
		}
		while(p!=null)
		{
			s=s+p.toString()+"/n";
		}
		
		return s;
	}
	public boolean isEmpty()        // Check if queue is Empty.
	{
		if(head == null)			//if head is null the list isEmpty
			return true;
		else 
			return false;
	}
	public Process peek(){          // Return the process at the head.
		return head;
	}
	public void enQueue(Process p)  // Add process to the tail.
	{
		tail.next=p;
		p.previous=tail;
		tail=p;
	}
	public Process deQueue()        // Remove from the head.
	{
		Process temp = head;		// temp stores head 
		head = head.next;
		head.previous=null;
		return temp;
	}
	public Process remove(long id)  // Remove process from the list.
	{
		Process p=this.find(id);
		Process pre;
		Process next;
		if(p==null)
		{
			return null;
		}
		pre=p.previous;
		next=p.next;
		pre.next=next;
		next.previous=pre;
		return p;
	}
	public Process find(long id)   // Find process in the queue.
	{
		Process current = head;
		while(current != null){
			if (current.getId() == id)
				return current;
			else
				current = current.next;
		}
		return null;
	}
}
