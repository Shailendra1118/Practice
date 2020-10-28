package com.basic.bookish;

public class MirrorMatrix {
	static int R = 3;
	static int C = 3;
	/*
	 * Mirror matrix against its primary diagonal
	 */
	public static void main(String[] args) {
		int arr[][] = {{ 1,2,3},
					   {4,5,6},
					   {7,8,9}
						};
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		int start = 0;
		for (int i = 0; i < R; i++) {
			for (int j = start; j < C; j++) {
				if(i != j){
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
			start++;
		}
		
		System.out.println("Post process:");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]+" ");
			}
		}
		
	}

}
