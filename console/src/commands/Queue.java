package commands;

import os.CliCommand;

public class Queue extends CliCommand {

	@Override
	public void execute(String[] args) throws Throwable
	{
		msg=runList.toString();
	}
	
}
