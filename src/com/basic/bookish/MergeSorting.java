package com.basic.bookish;

import java.util.Arrays;

// using mycodeschool algorithm
public class MergeSorting {

	public static void main(String[] args) {
		int arr[] = {2, 4, 1, 6, 8, 5, 3, 7};
		
		mergeSort(arr);
	}

	private static void mergeSort(int[] arr) { //int[] return required ?
		if(arr.length < 2) //very important
			return;
		
		int mid = arr.length/2;
		int lArr[] = new int[mid];
		int rArr[] = new int[arr.length-mid];
		lArr = Arrays.copyOfRange(arr, 0, mid);
		rArr = Arrays.copyOfRange(arr, mid, arr.length);
		System.out.println("left: "+Arrays.toString(lArr));
		System.out.println("right: "+Arrays.toString(rArr));
		mergeSort(lArr);
		mergeSort(rArr);
		
		//merge now
		int nL = lArr.length;
		int nR = rArr.length;
		int i = 0, j = 0, k = 0;
		while(i < nL && j < nR ){  // 0 < 1
			if(lArr[i] <= rArr[j]){
				arr[k++] = lArr[i++];
			}else{
				arr[k++] = rArr[j++];
			}
		}
		while(i < nL){
			arr[k++] = lArr[i++];
		}
		while(j < nR){
			arr[k++] = rArr[j++];
		}
		//System.out.println("Left: "+Arrays.toString(lArr) +" Right: "+Arrays.toString(rArr));
		System.out.println(Arrays.toString(arr));
	}

}
