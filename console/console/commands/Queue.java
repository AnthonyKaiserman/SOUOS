package commands;
import os.CliCommand;

public class Queue extends CliCommand{
	public Queue(){}
	public String execute(String[] args){
		return runList.toString();
	}
}
