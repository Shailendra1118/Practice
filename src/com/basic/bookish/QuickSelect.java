package com.basic.bookish;

import java.util.Arrays;

public class QuickSelect {

	public static void main(String[] args) {
		int arr[] = {6,7,8,1,2,3,4,5};
		int k = 3;
		/**
		 *  Median an is 4th largest number in the array so k = 4 to find a median
		 *  i.e. here 5 is median that is 4th largest in this array
		 */
		int res = kthLargest(arr, arr.length-k, 0, arr.length-1);  
		System.out.println("result: "+res);
		
		int res1 = selectK(arr, 0, arr.length-1, arr.length-k);
		System.out.println("result: "+res1);
	}

	private static int selectK(int[] arr, int start, int end, int k) {
		int pIdx = partition(arr, start, end);
		System.out.println("start "+start+" end "+end+" pIdx "+pIdx);
		System.out.println("partition: "+Arrays.toString(arr));
		if(k == pIdx)
			return arr[pIdx];
		else if(k < pIdx)
			return selectK(arr, start, pIdx-1, k);
		else 
			return selectK(arr, pIdx+1, end, k); 
	} 

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIdx = start;
		int i = 0;
		for (i = start; i < end; i++) {
			if(arr[i] < pivot){
				int temp = arr[i];
				arr[i] = arr[pIdx];
				arr[pIdx] = temp;
				pIdx++;
			}	
		}
		int temp = arr[i];
		arr[i] = arr[pIdx];
		arr[pIdx] = temp;
		return pIdx;
	}

	private static int kthLargest(int[] arr, int k, int start, int end) {
		System.out.println("k: "+k+" start: "+start+" end: "+end);
		int pivot = arr[end];
		int l = start;
		int r = end;
		while(true){
			while(arr[l] < pivot && l<r){
				l++;
			}
			while(arr[r] >= pivot && r>l){
				r--;
			}
			if(r == l)
				break;
			swap(arr, l, r);
			//System.out.println("after swap: "+Arrays.toString(arr));
		}
		swap(arr, l, end);
		System.out.println("after swap: "+Arrays.toString(arr));
		if( k == l)
			return pivot;
		else if(k < l)
			return kthLargest(arr, k, start, r-1);
		else 
			return kthLargest(arr, k, r+1, end); 
		
	}

	private static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
