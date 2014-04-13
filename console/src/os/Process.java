package os;

import java.io.IOException;
import java.io.PrintWriter;

import programs.Program;

//Class to represent a process.
class Process
{ 
	public static final int RUNNING    = 0;
	public static final int WAIT       = 1;
	public static final int IDLE       = 2;
	public static final int TERMINATED = 3;
	public static final int ABORTED    = 4;
	
	private String[] args;       // The calling arguments.
	private long id;             // Process Id number (pid).
	private int  priority;       // Priority.
	private long startTime;      // Process start time.
	private long endTime;        // End time after process completes.
	private int  status;         // Process status.
	
	Class<?>   className;           // Bytecode name of class.
	Program classInstance;       // Class instance that can be called.
	
	public Process next;         // Links for next and previous list entries.
	public Process previous;
	
	// Constructors and methods.
	public Process(String[] args, int priority, long id)  
	       throws ClassNotFoundException, IOException
	{
		this.args=args;
		this.priority=priority;
		this.id=id;
	}
	public String run(PrintWriter out) 
	       throws InstantiationException, IllegalAccessException
	{
		
		String[] argData = this.args;
		String[] args = new String[argData.length - 1];
		argData[0]=Character.toUpperCase(argData[0].charAt(0))+argData[0].substring(1);
		System.arraycopy(argData, 1, args, 0, args.length);
		try{
			className = Class.forName(argData[0]);
			classInstance = (Program)className.newInstance();
			classInstance.run(out,args);
		}catch(Throwable thrown){
			
			return ("java.classNotFoundException for "+ argData[0]);
		}
		return argData[0]+" ran successfully tim = "+(endTime-startTime);
	}
	public void setPriority(int priority)
	{
		this.priority=priority;
	}
	public long getId(){
		return id;
	}
	public int getPriority(){
		return priority;
	}
	public String getName(){
		return args[0];
	}
	public String[] getArgs()
	{
		String[] a=new String[this.args.length-1];
		System.arraycopy(this.args, 1, a, 0, a.length);
		return a;
	}
	public long getRunTime()
	{
		return endTime - startTime;
	}
	public String getStatus()
	{
		switch(this.status) 
		{
		case 0:
			return "Running";
		case 1:
			return "Wait";
		case 2:
			return "Idle";
		case 3:
			return "Terminated";
		case 4:
			return "Aborted";
		default:
			return null;
			
		}
	}
	public String toString()
	{
		return getName() + "/t" + getId() + "/t" + getStatus() + 
			   "/t"+getRunTime()+"/t" + getPriority() + "/t" + getArgs();
	}
}