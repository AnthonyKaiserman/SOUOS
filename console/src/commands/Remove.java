package commands;

import os.CliCommand;
public class Remove extends CliCommand{
	public String execute(String[] args){
		return runList.remove(Long.parseLong(args[0])).toString() + "\n---removed from queue.";
	}

}
