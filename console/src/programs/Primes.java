package programs;

import java.io.PrintWriter;

public class Primes extends Program
{ 

	private static final long serialVersionUID = 1L;

	public Primes() { super("Find Prime Numbers"); }
	public int run(PrintWriter out, String[] args)
	{ 
	   int maxNumber = Integer.parseInt(args[1]);
	   if (maxNumber<1) return(ILLEGAL_PARAMETER);

	   out.println(args[0]+ ": First " + maxNumber + " prime numbers");
	   if (maxNumber>=1) out.println(1);
	   if (maxNumber>=2) out.println(3);
	   if (maxNumber>=3) out.println(5);
	   if (maxNumber>=4) out.println(7);
	   if (maxNumber>=5) out.println(11);
	   if (maxNumber>=6)
	   {
		   long currentNum = 12;
		   int count=6;
		   int div=2;
		   while(maxNumber>=count)
		   {   
			   if(currentNum%div!=0)
			   {
				   div++;
				   if(currentNum%div!=0)
				   {
					   div++;
					   if(currentNum%div!=0)
					   {
						   div++;
						   if(currentNum%div!=0)
						   {
							   div++;
							   if(currentNum%div!=0)
							   {
								   div++;
								   if(currentNum%div!=0)
								   {
									   div++;
									   if(currentNum%div!=0)
									   {
										   div++;
										   if(currentNum%div!=0)
										   {
											   out.println(currentNum);
											   count++;
										   }
									   }
								   }
							   }
						   }
					   }
				   }
			   }
			   div=2;
			   currentNum++;
		   }
	   }
	   return SUCCESS;
	}	

}