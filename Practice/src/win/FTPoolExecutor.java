package win;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class FTPoolExecutor {
public static void main(String[] args) {
	ExecutorService exec=Executors.newFixedThreadPool(10);
exec.submit(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<Integer.MAX_VALUE;i++)
			System.out.println("Hii"+i);
		}
	});
exec.submit(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<Integer.MAX_VALUE;i++)
		System.out.println("Bye"+i);
	}
});

}
}
