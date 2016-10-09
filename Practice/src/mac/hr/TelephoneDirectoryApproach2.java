package mac.hr;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
/**
 * Assumptions:
 * 1. no spaces in name
 * 2. all statements are commands
 * @author asriv5
 *
 */
public class TelephoneDirectoryApproach2 {

	class Node{
		int count;
		byte val;
		List<Node> children=new ArrayList<>();
	}
	
	public void solve(String[] operations){
		Node root=new Node();
		for(String operation: operations){
			String[] parts=operation.split(" ");
			if("add".equals(parts[0])){
				//add item
				add(parts[1],root);
			}else{
				//find item
				find(parts[1],root);
			}
		}
	}
	
	

	
	private void find(String string, Node root) {
		// TODO Auto-generated method stub
		
	}




	private void add(String string, Node root) {
		// TODO Auto-generated method stub
		byte[] vals=string.getBytes();
		
	}




	@Test
	public void test(){
		String[] commands="add hack,add hackerrank,find hac,find hak".split(",");
		solve(commands);
	}
	
	@Test
	public void test2(){
		String[] commands="add s,add ss,add sss,add ssss,add sssss,find s,find ss,find sss,find ssss,find sssss,find ssssss".split(",");
		solve(commands);
	}
	
	@Test
	public void timeTestFor100kCommands(){
		StringBuffer commands=new StringBuffer();
		for(int i=0;i<999999;i++){
			commands.append("add sssssssssssssssssssssssssssssssssssssssssssssssssssssss,");
		}
		commands.append("find s");
		
		Date start=new Date();
		String[] commandsArr=commands.toString().split(",");
		solve(commandsArr);
		Date end=new Date();
		System.out.println("Time Taken:"+(end.getTime()-start.getTime())+"ms");
	}
}
