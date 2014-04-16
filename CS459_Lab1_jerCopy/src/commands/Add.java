package commands;

import java.io.IOException;

import os.CliCommand;
import os.Process;

public class Add extends CliCommand 
		     
{
	public Add(){}
	@SuppressWarnings("static-access")
	@Override
	public String execute(String[] arg)throws ClassNotFoundException, IOException{
		long pid = System.currentTimeMillis() % 100000;
		if(runList != null){
			process = new Process(arg, process.IDLE, pid);
			runList.enQueue(process);
		}else
			return "ERROR: Batch not created!\n";
		return "process " + process.getName() + " added to batch.\n";
	}

}
