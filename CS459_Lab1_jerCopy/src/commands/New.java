package commands;

import os.CliCommand;
import os.ProcessList;

public class New extends CliCommand{
	public New(){
		//create a ProcessList or queue	 
	}
	@Override
	public String execute(String[] args){
		runList = new ProcessList();
		return "new batch created.";
	}
}
