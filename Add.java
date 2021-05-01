import java.io.*;
import java.util.*;
import java.net.*;
public class Add 
{
	public static void main(String[] args) throws IOException
	{
		Socket x = new Socket("127.3.2.1", 2033);
	    PrintWriter out = new PrintWriter(x.getOutputStream(), true);
	    BufferedReader in= new BufferedReader(new InputStreamReader(x.getInputStream()));
	    out.println("add");
	    Scanner systemIn = new Scanner(System.in);
	    System.out.println("Please type in the word you would like to add.");
	    out.println(systemIn.next());
	}
}
