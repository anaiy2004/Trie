import java.io.*;
import java.util.*;
import java.net.*;
public class Delete 
{
	public static void main(String[] args) throws IOException
	{
		Socket x = new Socket("127.0.0.1", 2033);
	    System.out.println("Please type in the word you would like to delete.");
	    PrintWriter out = new PrintWriter(x.getOutputStream(), true);
	    BufferedReader in= new BufferedReader(new InputStreamReader(x.getInputStream()));
	    Scanner input = new Scanner(System.in);
	    out.println("delete");
	    out.println(input.next());
	    System.out.println("The word is not in the trie anymore.");
	    x.close();

	}
}
