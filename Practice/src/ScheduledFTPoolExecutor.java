import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ScheduledFTPoolExecutor {
public static void main(String[] args) {
	ScheduledExecutorService exec=Executors.newScheduledThreadPool(10);
	
exec.schedule(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<Integer.MAX_VALUE;i++)
			System.out.println("Hii"+i);
		}
	},5,TimeUnit.SECONDS);
exec.schedule(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<Integer.MAX_VALUE;i++)
		System.out.println("Bye"+i);
	}
},5,TimeUnit.SECONDS);

}
}
