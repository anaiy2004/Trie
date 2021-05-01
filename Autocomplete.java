import java.io.*;
import java.util.*;
import java.net.*;
public class Autocomplete 
{
	public static void main(String[] args) throws IOException
	{
		Socket x = new Socket("127.0.0.1", 2033);
	    PrintWriter out = new PrintWriter(x.getOutputStream(), true);
	    BufferedReader in= new BufferedReader(new InputStreamReader(x.getInputStream()));
	    Scanner input = new Scanner(System.in);
	    out.println("autocomplete");
	    System.out.println("Please type in the word you would like to autocomplete.");
	    out.println(input.next());
	    int num = Integer.parseInt(in.readLine());
	    if(num == 0)
	    	System.out.println("No words can be autocompleted");
	    else
	    {
	    	System.out.print("List of words: ");
	    }
	    for(int i = 0; i < num; i ++)
	    {
	    	if(num - 1 != i)
	    		System.out.print(in.readLine() + ", ");
	    	else
	    		System.out.print(in.readLine());
	    }
	    x.close();

	}
}
