import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class PreTree {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        //List<String> list=new ArrayList<String>();
        
        String[] list=new String[N];
        
        for (int i = 0; i < N; i++) {
        list[i]=br.readLine();
        }
        int Q = Integer.parseInt(br.readLine());
       
       Processor[] ps=new Processor[Q];
       
       for (int i = 0; i < Q; i++) {
       	String line2=br.readLine();
       	String[] tmp=line2.split(" ");
       	line=tmp[2];
	    int l=Integer.parseInt(tmp[0]);
       	int r=Integer.parseInt(tmp[1]);
       	
       	Processor p=new Processor(l,r,line,list);
       	p.start();
       	ps[i]=p;
       	
      
       }
       for(Processor p:ps)
       {
    	   p.join(); 	
        System.out.println(p.getFin());
       }
      
       
    }
    
}
class Processor extends Thread
{
	int l=0;
	int r=0;
	String line;
	String[] list;
	String fin="def";
	public String getFin()
	{
		return fin;
	}
	public Processor(int l,int r, String line,String[] list)
	{
		this.l=l;
		this.r=r;
		this.line=line;
		this.list=list;
	}
	public void run()
	{
		List<String> list2=new ArrayList<String>();
       	for(int j=l-1;j<=r-1;j++)
       	{
       		list2.add(list[j]);
       	}
       	
       	String fin="";
       	
       	byte[] bytes=line.getBytes();
       	
       	for(int j=0;j<bytes.length;j++)
       	{
       	List<String> removal=new ArrayList<String>();
       	boolean fnd=false;
       	
       	for(String str:list2)
       	{
       		byte[] bytes2=str.getBytes();
       		if(bytes[j]==bytes2[j])
       		{
       			if(!fnd)
       			{
       			fin+=(char)bytes[j];
       			fnd=true;
       			}
       		}
       		else
       		removal.add(str);
       	}
       	list2.removeAll(removal);
       	}
	this.fin=fin;
	}
}
