package commands;
import os.CliCommand;

public class Priority extends CliCommand{
	public Priority(){}
	public String execute(String[] args){
		runList.setPriority(Long.parseLong(args[0]), Integer.parseInt(args[1]));
		return process.toString();
	}

}
