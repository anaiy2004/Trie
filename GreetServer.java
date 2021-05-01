import java.io.*;
import java.net.*;
import java.util.*;
public class GreetServer 
{
	private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public void start(int port, Trie trie) throws IOException 
    {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String command = in.readLine(); 
        
        if(command.equals("add"))
        {
        	String word = in.readLine();
        	trie.insert(word);
            stop(); 
        }
        else if(command.equals("search"))
        {
        	String word = in.readLine();
        	out.println(trie.search(word));
            stop(); 
        }
        else if(command.equals("delete"))
        {
        	String word = in.readLine();
        	trie.delete(word);
            stop(); 
        }
        else if(command.equals("autocomplete"))
        {
        	String word = in.readLine();
        	List<String> x = trie.autocomplete(word);
        	out.println(x.size());
        	for(int i = 0; i < x.size(); i ++)
        	{
        		out.println(x.get(i));
        	}
            stop(); 
        }
        else if(command.equals("printall"))
        {
        	ArrayList<String> ans = new ArrayList<String>();
        	for(char i = 'a'; i < 'z'; i ++)
        	{
        		List<String> x = trie.autocomplete("" + i);
        		if(x.size() != 0)
        		{
        			for(int j = 0; j < x.size(); j ++)
        			{
        				ans.add(x.get(j));
        			}
        		}
        	}
        	out.println(ans);
        }
        stop(); 
    }
    
    public void stop() throws IOException 
    {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public static void main(String[] args) throws IOException
    {

        GreetServer server=new GreetServer();
        Trie head = new Trie();
       for(int i = 0; i < Integer.MAX_VALUE; i ++)
       {
    	   server.start(2033, head); 
       }
        server.stop();
    }
}
class TrieNode 
{
	// general idea for what variables to keep in the TrieNode class was from online
    char data;     
    TrieNode parent;
    LinkedList<TrieNode> children; 
    boolean isEnd;

    public TrieNode(char c) 
    {
    	data = c;
        isEnd = false; 
        children = new LinkedList<TrieNode>();
    }  
    
    public TrieNode getChild(char c) 
    {
        if (children != null)
        {
            for (int i = 0; i < children.size(); i ++) 
            {
                if (children.get(i).data == c)
                {
                    return children.get(i);
                }
            }
        }
        return null;
    }
    protected List<String> getWords() 
    {
       List<String> list = new ArrayList<String>();      
       if (isEnd) 
       {
    	   list.add(toString());
       }
       
       if (children != null) 
       {
	       for (TrieNode child : children) 
	       {
	          if (child != null) 
	          {
	             list.addAll(child.getWords());
	          }
	       }
       }       
       return list; 
    }
    
	public String toString() 
	{
		if (parent == null) 
		{
			return "";
		} 
		else 
		{
			String string = new String(new char[] {data});
			return parent.toString() + string;
		}
	}
}
class Trie 
{
    private TrieNode root;
    public Trie()
    {
        root = new TrieNode(' '); 
    }
    public void insert(String word) 
    {
        TrieNode current = root; 
        TrieNode par ;
        if (search(word) == true) 
            return;    
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i ++)
        {
        	par = current;
            TrieNode child = current.getChild(charArray[i]);
            if (child != null) 
            {
                current = child;
                child.parent = par;
            } 
            else 
            {
                 current.children.add(new TrieNode(charArray[i]));
                 current = current.getChild(charArray[i]);
                 current.parent = par;
            }
        }
        current.isEnd = true;
    }
    public boolean search(String word)  
    {
        TrieNode current = root;      
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i ++)
        {
            if (current.getChild(charArray[i]) == null)
                return false;
            else 
            {
                current = current.getChild(charArray[i]);    
            }
        }      
        if (current.isEnd == true) 
        {       
            return true;
        }
        return false;
    }
    public boolean delete(String word) 
    {
        TrieNode deleteBelow = null;
        char deleteChar = 'a';
        TrieNode parent = root;
        
        if (word == null || word.length() == 0) 
        {
            return false;
        }
        for (char element : word.toCharArray())
        {
            TrieNode child = parent.getChild(element); 

            if (child == null) 
            { 
                return false;
            }
            if (parent.children.size() > 0 || parent.isEnd)
            { 
                deleteChar = element;
                deleteBelow = parent;
            }
            parent = child;
        }
        if (!parent.isEnd)
        { 
            return false;
        }
        
        if (parent.children.isEmpty()) 
        {
        	deleteBelow.children.remove(deleteBelow.getChild(deleteChar));
        } 
        else 
        {
            parent.isEnd = false;
        }
        return true;
    }
    public List<String> autocomplete(String pre)
    {     
       TrieNode last = root;

       char[] charArray = pre.toCharArray();
       for (char element : charArray) 
       {
	       last = last.getChild(element);	     
	       if (last == null) 
	       {
	    	   return new ArrayList<String>();     
	       }
       }
       return last.getWords();
    }
}    