package com.topcode.prob;

public class Circuits {
	static int ROW = 13;
	static int COL = 13;
	static String connect[] = {"","2 3 5","4 5","5 6","7","7 8","8 9","10",
		 "10 11 12","11","12","12",""}; //{"1","2","3","","5","6","7",""}; //{"1 2","2", ""};
	static String cost[] = {"","3 2 9","2 4","6 9","3","1 2","1 2","5",
		 "5 6 9","2","5","3",""}; //{"2","2","2","","3","3","3",""};   //{"5 3","7", ""};
	
			
		
		
	
	static String arr[][] = new String[ROW][COL];
	public static void main(String[] args) {
		
		populateArr(arr);
		display(arr);
		int max = 0, curMax = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				curMax = findLong(arr, i, j);
				if(curMax > max)
					max = curMax;
			}
			
		}
		System.out.println("Max: "+max);
	}

	private static int findLong(String[][] arr, int r, int c1) {
		int curMax = 0;
		boolean found = false;
		while(r < ROW) {
			System.out.println("Row: "+r);
			int c = 0;
			for (c = c1; c < COL; c++) {
				if(arr[r][c] != "0"){
					curMax = curMax + Integer.valueOf(arr[r][c]);
					System.out.println("Col: "+c);
					r = c;
					found = true;
					break;
				}
			}
			if(c == COL){
				System.out.println("Graph ends here.");
				break;
			}
			if(!found)
				r++;
			
		}
		System.out.println("curMax: "+curMax);
		return curMax;
	}

	private static void display(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+": ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void populateArr(String[][] arr) {
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if(arr[i][j] == null)
					arr[i][j] = "0";
			}
		}
		
		for (int i = 0; i < connect.length; i++) {
			String[] ip = connect[i].split(" ");
			for (int j = 0; j < ip.length; j++) {
				System.out.println(i+" connnects to "+ip[j]+" with cost:"+cost[i].split(" ")[j]);
				if(ip[j] != ""){
					int k = Integer.valueOf(ip[j]);
					arr[i][k] = cost[i].split(" ")[j];
				}
			}
			
		}
		
		
	}

}

