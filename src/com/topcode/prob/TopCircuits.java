package com.topcode.prob;

public class TopCircuits {
	
	static int ROW = 13;
	static int COL = 13;
	static String connect[] = {"1","2","3","","5","6","7",""}; 
		//{"","2 3 5","4 5","5 6","7","7 8","8 9","10",
		// "10 11 12","11","12","12",""}; // //{"1 2","2", ""};
	static String cost[] = {"2","2","2","","3","3","3",""};
		//{"","3 2 9","2 4","6 9","3","1 2","1 2","5",
		// "5 6 9","2","5","3",""};    //{"5 3","7", ""};
	
	public static void main(String args[]){
		System.out.println(howLong(connect, cost));
	}
 public static int howLong(String[] connects, String[] costs) {
	 
	   int N = connects.length;
	   int cost[][] = new int[N][N];
	   for( int i=0; i<N; i++ ) if( !connects[i].equals("") ) {
	     String t1[] = connects[i].split(" ");
	     String t2[] = costs[i].split(" ");
	     for( int j=0; j<t1.length; j++ ) {
	       System.out.println( i + " " + j + " " + t1[j] + " " + t2[j] );
	       int t = Integer.parseInt(t1[j]);
	       int c = Integer.parseInt(t2[j]);
	       if( c > cost[i][t] ) cost[i][t] = c;
	     }
	   }
	   
	   display(cost);
	   for( int k=0; k<N; k++ )
	   for( int i=0; i<N; i++ )
	   for( int j=0; j<N; j++ ) {
	     if( cost[i][j]<cost[i][k]+cost[k][j] && cost[i][k]!=0 && cost[k][j]!=0 ) {
	       cost[i][j] = cost[i][k]+cost[k][j];
	     }
	   }
	   System.out.println("post calc -");
	   display(cost);
	   int ans = 0;
	   for( int i=0; i<N; i++ )
	   for( int j=0; j<N; j++ )
	   if( cost[i][j] > ans )
	     ans = cost[i][j];
	     
	   return ans;
     
 }
 
 private static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+": ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}