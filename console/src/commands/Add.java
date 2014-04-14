package commands;

import os.*;
import os.Process;

public class Add extends CliCommand{
	@Override
	public void execute(String[] arg) throws Throwable
	{
		process = new Process(arg,5,0);
		runList.enQueue(process);
		msg="Process "+ arg[0]+" has been added to the queue.";
	}

}
