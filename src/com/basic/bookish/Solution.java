package com.basic.bookish;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		String str =  "00:01:07,400-234-090"+'\n'+
				      "00:05:01,701-080-080"+'\n'+
				      "00:05:00,400-234-090"+'\n'+
				      "00:06:07,300-234-088";
		
		String str1 =  "00:05:00,400-234-090"+'\n'+
						"00:05:00,400-234-091";
		
		int res = solution(str);
		System.out.println("res: "+res);
	}

	private static int solution(String str) {
		HashMap<Integer,Integer> phoneDurationMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> phoneBillMap = new HashMap<>();
		String arr[] = str.split("\n");
		int i = 0;
		while(i < arr.length){
			String cur = arr[i];
			//System.out.println(cur);
			String[] input = cur.split(",");
			String duration = input[0];
			String phone = input[1];
			calDuration(duration, phone, phoneDurationMap);			
			calBill(phone, duration, phoneDurationMap, phoneBillMap);
			i++;
		}
		
		printDuration(phoneDurationMap);
		printBill(phoneBillMap);
		int totalBill = calculateTotalBill(phoneBillMap);
		System.out.println("total: "+totalBill);
		int discount = calculateDisc(phoneDurationMap, phoneBillMap);
		System.out.println("discount: "+discount);
		return totalBill - discount;
		
	}

	private static void printBill(HashMap<Integer, Integer> phoneBillMap) {
		System.out.println("print billing..");
		phoneBillMap.forEach((k,v)->System.out.println(k+": "+v));
	}

	private static void printDuration(HashMap<Integer, Integer> phoneDurationMap) {
		System.out.println("print durations..");
		phoneDurationMap.forEach((k,v)->System.out.println(k+": "+v));
	}

	private static int calculateDisc(
			HashMap<Integer, Integer> phoneDurationMap,
			HashMap<Integer, Integer> phoneBillMap) {
		//find longest duration
		Map<Integer, Integer> result = new LinkedHashMap<>();
		phoneDurationMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		int duration = 0;
		int num = 0;
		Iterator<Entry<Integer,Integer>> iter = result.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer, Integer> e = iter.next();
			num = e.getKey();
			duration = e.getValue();
			break;
		}
		// if only one record no discount
		while(! iter.hasNext()){
			return 0;
		}
		for(Map.Entry<Integer, Integer> entry : result.entrySet()){
			int n = entry.getKey();
			int d = entry.getValue();
			//System.out.println("sorted: "+n+" "+d);
			if(d > duration || d == duration){
				duration = d;
				num = Math.min(n, num);
			}			
		}
		
		int disc = phoneBillMap.get(num);		
		return disc;
	}

	private static int calculateTotalBill(HashMap<Integer, Integer> phoneBillMap) {
		int totalBill = 0;
		for(Map.Entry<Integer, Integer> entry : phoneBillMap.entrySet()){
			totalBill = totalBill + entry.getValue();
		}
		return totalBill;
	}

	private static void calBill(String phone, String duration, HashMap<Integer, Integer> phoneDurationMap, 
			HashMap<Integer, Integer> phoneBillMap) {
		
		String arr1[] = phone.split("-");
		int num = Integer.valueOf(arr1[0].trim()+arr1[1].trim()+arr1[2].trim());
		String arr[] = duration.split(":");
		int sec = Integer.valueOf(arr[0].trim()) * 60 * 60;
		sec = sec + Integer.valueOf(arr[1].trim()) * 60;
		sec = sec + Integer.valueOf(arr[2].trim());
		
		int curBill = getBill(sec);
		if(phoneBillMap.containsKey(num)){
			int bill = phoneBillMap.get(num);
			bill = bill + curBill;
			phoneBillMap.put(num, bill);			
		}else{
			phoneBillMap.put(num, curBill);
		}
		
	}
	
	private static int getBill(int duration){
		//Billing rules
		int bill = 0;
		if(duration < (5*60)){
			bill = duration * 3;
		}
		else if(duration == (5*60)){
			bill = (duration/60) * 150;
		}
		else if(duration > (5*60)){
			int mins = duration/60;
			bill = (mins+1) * 150;
		}
		return bill;
	}

	private static void calDuration(String duration, String phone, HashMap<Integer, Integer> map) {
		String arr[] = duration.split(":");
		int sec = Integer.valueOf(arr[0].trim()) * 60 * 60;
		sec = sec + Integer.valueOf(arr[1].trim()) * 60;
		sec = sec + Integer.valueOf(arr[2].trim());
		
		String arr1[] = phone.split("-");
		int num = Integer.valueOf(arr1[0].trim()+arr1[1].trim()+arr1[2].trim());
		if(map.containsKey(num)){
			int val = map.get(num);
			val = val + sec;
			map.put(num, val);
		}else{
			map.put(num, sec);
		}
		
		
	}

}
