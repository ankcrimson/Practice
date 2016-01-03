package hr.algos;

import java.util.Scanner;

public class Four_Diagonal_Difference {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        long i=0;
        long j=0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                if(a_i==a_j)
                    i+=a[a_i][a_j];
                if(a_i+a_j==n-1)
                    j+=a[a_i][a_j];
            }
        }
        long ans=i-j;
        if(ans<0)
            ans=ans*-1;
        System.out.println(ans);
    }
}
