import java.io.*;
import java.util.*;
import java.net.*;
public class PrintAll 
{
	public static void main(String[] args) throws IOException
	{
		Socket x = new Socket("127.0.0.1", 2033);
	    PrintWriter out = new PrintWriter(x.getOutputStream(), true);
	    BufferedReader in= new BufferedReader(new InputStreamReader(x.getInputStream()));
	    Scanner input = new Scanner(System.in);
	    out.println("printall");
	    System.out.println("List of words in the trie: " + in.readLine());
	    x.close();
	}
}
