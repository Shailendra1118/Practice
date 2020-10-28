package com.basic.bookish;

public class Bubbles {

	public static void main(String[] args) {
		int arr[] = {5, 2, 3, 4, 1};
		
		for (int i = 0; i < arr.length-1; i++) { // -1 because no need to compare last element
			for (int j = 0; j < arr.length-i; j++) {    // -i because skip last already sorted elements
				if((j+1) < arr.length && arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}				
			}
			System.out.print("after i:"+i+"th pass:");
			System.out.println();
			showIt(arr);
		}
	}

	private static void showIt(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
