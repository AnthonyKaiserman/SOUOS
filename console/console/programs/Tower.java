package programs;

import java.io.PrintWriter;

public class Tower extends Program
{ 
	
	private static final long serialVersionUID = 1L;
	
	public Tower() { super("Tower of Hanoi"); }
	public int run(PrintWriter out, String[] args)
	{ 
	   int numRings = Integer.parseInt(args[1]);
	   if (numRings<1) return(ILLEGAL_PARAMETER);
	
	   out.println(args[0]+ ": With " + numRings + " rings");
	  
	   doTowers(out,numRings, 'A', 'B', 'C');
	   
	   return SUCCESS;
	}	
	
	public static void doTowers(PrintWriter out,int topN, char from, char inter, char to) {
	    if (topN == 1){
	      out.println("Ring 1 from " + from + " to " + to);
	    }else {
	      doTowers(out,topN - 1, from, to, inter);
	      out.println("Ring " + topN + " from " + from + " to " + to);
	      doTowers(out,topN - 1, inter, from, to);
	    }
	  }
}
