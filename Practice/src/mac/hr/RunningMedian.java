package mac.hr;

import java.util.PriorityQueue;

import org.junit.Test;

public class RunningMedian {
	
	public void addNumber(int number, PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers){
		if(lowers.size()==0){
			lowers.add(number);
			return;
		}
		if(number>lowers.peek()){
			highers.add(number);
		}else lowers.add(number);
	}
	
	public void solve(String[] inputs){
		//Priority queue to make heaps
		PriorityQueue<Integer> highers=new PriorityQueue<>();
		PriorityQueue<Integer> lowers=new PriorityQueue<>((a,b)-> -a.compareTo(b));
		for(int i=1;i<inputs.length;i++){
			addNumber(Integer.parseInt(inputs[i]), highers, lowers);
			rebalance(highers, lowers);
			double answer = calculate(highers,lowers);
			System.out.println(answer);
		}
	}
	
	
	private double calculate(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> bigger=highers.size()>lowers.size()?highers:lowers;
		PriorityQueue<Integer> smaller=highers.size()>lowers.size()?lowers:highers;
		if(bigger.size()==smaller.size()){
			return ((double)bigger.peek()+smaller.peek())/2;
		}
		return bigger.peek();
	}

	private void rebalance(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> bigger=highers.size()>lowers.size()?highers:lowers;
		PriorityQueue<Integer> smaller=highers.size()>lowers.size()?lowers:highers;
		while(bigger.size()-smaller.size()>=2){
			smaller.add(bigger.poll());
		}
	}

	@Test
	public void test(){
		String[] inputs="6,12,4,5,3,8,7".split(",");
		solve(inputs);
	}

}
