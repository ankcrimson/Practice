package mac.hr;

import java.util.Date;
import java.util.HashMap;
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
public class TelephoneDirectoryApproach1 {

	public void solve(String[] operations){
		Map<String,Integer> lookup=new HashMap<>();
		for(String operation: operations){
			String[] parts=operation.split(" ");
			if("add".equals(parts[0])){
				//add item
				add(parts[1],lookup);
			}else{
				//find item
				if(lookup.containsKey(parts[1]))
					System.out.println(lookup.get(parts[1]));
				else
					System.out.println(0);
			}
		}
	}
	


	private void add(String string, Map<String, Integer> lookup) {
		// TODO Auto-generated method stub
		int strlen=string.length();
		for(int i=1;i<=strlen;i++){
			String hash=string.substring(0, i);
			if(lookup.containsKey(hash)){
				int number=lookup.get(hash);
				lookup.put(hash, number+1);
			}else{
				lookup.put(hash, 1);
			}
		}
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
