package os;

import java.io.PrintWriter;

public abstract class CliCommand 
{
	protected final static String ROOT = "user";
	
	protected static ProcessList runList = null;
	protected static Process     process = null;
	protected static PrintWriter   trace = null;
	protected static String       prompt = "--->>";
	protected static String		msg = null;
	
	public static String outLog()
	{
		return msg;
//		BatchOS.outLog(data, true);
	}
	
	public static void outTrace(String data){
		if (trace != null) trace.println(data);
	}
	
	public void execute(String[] args) throws Throwable{
		
	}
	
}
