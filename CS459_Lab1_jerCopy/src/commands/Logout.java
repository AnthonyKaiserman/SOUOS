package commands;

import os.CliCommand;

public class Logout extends CliCommand{

	@Override
	public String execute(String[] args){
		System.exit(0);
		return null;
	}
}
