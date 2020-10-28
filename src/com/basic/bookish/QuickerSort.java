package com.basic.bookish;

import java.util.Arrays;

public class QuickerSort {

	public static void main(String[] args) {
		int arr[] = {7, 2, 4, 6, 4, 5, 3, 4};
		quickSort(arr, 0, arr.length-1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start < end){
			int pIdx = partition(arr, start, end);			
			quickSort(arr, start, pIdx-1);
			quickSort(arr, pIdx, end);
		}
		//System.out.println("Final: "+Arrays.toString(arr));
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIdx = start;
		for (int i = start; i < end; i++) {
			if(arr[i] <= pivot){ 			// items in left of pIdx should be less and vice-versa 
				int temp = arr[pIdx];
				arr[pIdx] = arr[i];
				arr[i] = temp;
				pIdx++;
			}
			System.out.println(Arrays.toString(arr)+" with start-"+start+" end-"+end);
		}		
		int temp = arr[end];
		arr[end] = arr[pIdx];
		arr[pIdx] = temp;
		System.out.println(Arrays.toString(arr)+" with start-"+start+" end-"+end+" pivot: "+pIdx);
		
		return pIdx;
	}

}
