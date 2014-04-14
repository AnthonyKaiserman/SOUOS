package commands;

import os.CliCommand;
import os.ProcessList;

public class New extends CliCommand{
	
	@Override
	public void execute(String[] args)  throws Throwable
	{
		runList = new ProcessList();
		msg="New batch initialized";
	}
	
	//public String toString()
	//{
		//return "New batch initialized";
	//}
}
