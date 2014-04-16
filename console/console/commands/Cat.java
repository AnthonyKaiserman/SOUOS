package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import os.CliCommand;

public class Cat extends CliCommand{

	@Override
	public String execute(String[] args) {
		
		BufferedReader in;
		String strVar = null;
		try{
			String sCurrent=null;
			in = new BufferedReader(new FileReader(args[0]));
			//StringBuffer strBuffer = new StringBuffer();
			while((sCurrent = in.readLine())!= null){
				strVar+=sCurrent+"\n";
			}
			in.close();
		}catch(IOException ioe){
			return "ERROR: File does not Exist!";
		}
		return strVar;
	}
}
