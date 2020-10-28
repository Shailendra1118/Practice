package com.basic.bookish;

import java.util.Arrays;

public class InsertionIt {

	public static void main(String[] args) {
		int arr[] = {41, 2, 71, 1, 57, 32, 2, 5, 66, 3, 7, 88, 51};
		
		for (int i = 0; i < arr.length-1; i++) {
			int j = i+1;
			int temp = arr[j];
			while(j-1 >=0 && arr[j-1] > temp){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
			System.out.println(Arrays.toString(arr));
		}

	}

}
