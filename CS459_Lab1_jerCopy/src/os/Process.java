package os;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import programs.Program;

//Class to represent a process.
public class Process
{ 
	public static final int RUNNING    = 0;
	public static final int WAIT       = 1;
	public static final int IDLE       = 2;
	public static final int TERMINATED = 3;
	public static final int ABORTED    = 4;
	
	private String[] args;   	 // The calling arguments.
	private long id;             // Process Id number (pid).
	private int  priority;       // Priority.
	private long startTime;      // Process start time.
	private long endTime;        // End time after process completes.
	private int  status;         // Process status.
	
	Class<?>   className;        // Byte code name of class.
	Program classInstance;       // Class instance that can be called.
	
	public Process next;         // Links for next and previous list entries.
	public Process previous;
	
	// Constructors and methods.
	public Process(String[] args, int priority, long id)  
	       throws ClassNotFoundException, IOException
	{
		this.args = args;
		this.priority = priority;
		this.id = id;
		this.status = 2;
	}
	public String run(PrintWriter out) 
	       throws InstantiationException, IllegalAccessException
	{
		try{
			className = Class.forName("programs." + getName());
			classInstance = (Program)className.newInstance();
			startTime = System.currentTimeMillis();
			status = 0;
			classInstance.run(out, args);
			status = 3;
			endTime = System.currentTimeMillis();
		}catch(Throwable thrown)
		{
			status = 4;
			return ("java.ClassNotFoundException for " + getName());
		}
		return getName() +" ran successfully time = "+ (endTime - startTime) + " milliseconds\n";
	}
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	public long getId(){
		return id;
	}
	public int getPriority(){
		return priority;
	}
	public String getName(){
		
		return args[0] = Character.toUpperCase(args[0].charAt(0)) + args[0].substring(1);
	}
	public String[] getArgs(String[] args)
	{
		String[] a = new String[args.length - 1];
		System.arraycopy(args, 1, a, 0, a.length);
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
			return "ERROR: No Status!";
			
		}
	}
	public String toString()
	{
		return getName() + "\t" + getId() + "\t" + getStatus() + 
	   "\t"+getRunTime()+"\t" + getPriority() + "\t " + Arrays.toString(getArgs(this.args));
	}
}