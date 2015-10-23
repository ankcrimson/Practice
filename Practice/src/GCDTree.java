import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node
{
	long value;
	List<Node> nodes=new ArrayList<Node>();
	Node parent;
	long gcd=0;
	public void setParent(Node p)
	{
		this.parent=p;
	}
	public Node getParent()
	{
		return parent;
	}
	public long getGcd()
	{
		return gcd;
	}
	public long getValue()
	{
		return this.value;
	}
	public void setValue(long value)
	{
		this.value=value;
	}
	public void addNode(Node n)
	{
		
		nodes.add(n);
		n.setParent(this);
		updateGcd(n);
		
	}
	public List<Node> getNodes()
	{
		return nodes;
	}
	public void updateGcd(Node n)
	{
		if(gcd==0)
		gcd=n.getValue();
		else
		{
		long gcd2=1;
		long a=gcd;
		long b=n.getValue();
		for(int i=2;i<16;i++)
		{
			if(a%i==0&&b%i==0)
			{
				a=a/i;b=b/i;
				gcd2*=i;
				i--;
				continue;
			}
		}
		gcd2*=a*b;
		gcd=gcd2;
		}
	if(parent!=null)
		{
			parent.updateGcd(this);
		}
	}
}

class GCDTree {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        Node[] nodes=new Node[N];
        line=br.readLine();
        String[] elements=line.split(" ");
        for (int i = 0; i < N; i++) {
          nodes[i]=new Node();
          nodes[i].setValue(Long.parseLong(elements[i]));
        }
        for (int i = 0; i < N-1; i++) {
          line=br.readLine();
          String[] el=line.split(" ");
          int x=Integer.parseInt(el[0]);
          int y=Integer.parseInt(el[1]);
          nodes[x-1].addNode(nodes[y-1]);
        }
        
     
    }
}
