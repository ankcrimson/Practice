//https://www.hackerrank.com/challenges/synchronous-shopping
package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SynchronousShopping {

	static class City{
		int distance;
		int number;
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}public int getNumber() {
			return number;
		}public void setNumber(int number) {
			this.number = number;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return number+" - "+distance;
		}
	}
	
	/**
	 * DFS from start to end
	 * Array of Set to contains list of fishes
	 * integer length of route
	 * note: keep a track of cities visited in current route to avoid getting into inf loop
	 * @param n
	 * @param m
	 * @param k
	 * @param fishes
	 * @param routes
	 */
	public void solve(int n,int m, int k, int[][] fishes, ArrayList<City>[] routes){
		int start=1;
		int end=n;
		
		
	}
	
	public void printDataStructure(int n,int m, int k, int[][] fishes, ArrayList<City>[] routes){
		System.out.println("Number of cities: "+n);
		System.out.println("Number of routes: "+m);
		System.out.println("Number of fishes: "+m);
		System.out.println("Fishes:");
		for(int i=1;i<fishes.length;i++){
			int[] fishesPerCity=fishes[i];
			for(int j=0;j<fishesPerCity.length;j++){
				System.out.print(i+" -> "+fishesPerCity[j]+" ");
			}
			System.out.println();
		}
		System.out.println("Routes");
		for(int i=0;i<routes.length;i++){
			ArrayList<City> route=routes[i];
			System.out.println(i+" -> "+route);
		}
	}
	
	public static void main(String[] args) {
		SynchronousShopping synchronousShopping=new SynchronousShopping();
		int n=0,m=0,k=0;
		int[][] fishes=null;
		ArrayList<City>[] routes=null;
		try(InputStreamReader inputStreamReader=new InputStreamReader(System.in);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader)){
					String[] nmk=bufferedReader.readLine().split(" ");
					n=Integer.parseInt(nmk[0]);
					m=Integer.parseInt(nmk[1]);
					k=Integer.parseInt(nmk[2]);
					//get the shopping center details
					fishes=new int[n+1][];//+1 because everything is 1 indexed
					for(int i=0;i<n;i++){
						String[] fishesString=bufferedReader.readLine().split(" ");
						//as the first int is number of fishes so skipping it
						fishes[i+1]=new int[fishesString.length-1];
						for(int j=1;j<fishesString.length;j++){
							fishes[i+1][j-1]=Integer.parseInt(fishesString[j]);
						}
					}
					//get the amount of time it takes to travel a->b
					routes=new ArrayList[m+1];
					for(int i=0;i<m+1;i++){
						routes[i]=new ArrayList<>();
					}
					//add biderctional routes
					for(int i=0;i<m;i++){
						String[] route=bufferedReader.readLine().split(" ");
						City city1=new City();
						City city2=new City();
						city1.setNumber(Integer.parseInt(route[1]));
						city1.setDistance(Integer.parseInt(route[2]));
						city2.setNumber(Integer.parseInt(route[0]));
						city2.setDistance(Integer.parseInt(route[2]));
						routes[Integer.parseInt(route[0])].add(city1);
						routes[Integer.parseInt(route[1])].add(city2);
					}
				}catch(Exception ex){
					ex.printStackTrace();
		}
		synchronousShopping.solve(n, m, k, fishes, routes);
		synchronousShopping.printDataStructure(n, m, k, fishes, routes);

	}

}
