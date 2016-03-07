package lin.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Passcode_Derivation_Keylog {

	public void addNode(Node root, String key)
	{
		String[] keys=key.split("");
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileReader fr=new FileReader("p079_keylog.txt");
		BufferedReader br=new BufferedReader(fr);
		String line="";
		List<String> keys=new ArrayList<String>();
		Node root=new Node();
		while((line=br.readLine())!=null)
		{
			//System.out.println(line);
			keys.add(line);
		}
		Collections.sort(keys);
		for(String k:keys)
			{
				System.out.println(k);
			
			}
	
	}

}

class Node{
	String val;
	Node next;
	Node prev;
	
	
}
