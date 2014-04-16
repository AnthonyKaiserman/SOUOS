package os;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class CliCommand 
{
	protected final static String ROOT = "user";
	
	protected static ProcessList runList = null;
	protected static Process     process = null;
	protected static PrintWriter   trace = null;
	protected static String       prompt = "--->>";
	
	public static void outLog(String data){
//		BatchOS.outLog(data, true);
	}
	
	public static void outTrace(String data){
		if (trace != null) trace.println(data);
	}
	
	public abstract String execute(String[] args)
		   throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException;
}
