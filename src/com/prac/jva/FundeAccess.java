package com.prac.jva;

import com.prac.main.YourClass;

public class FundeAccess {
	private static int arr[] = {5,2,1,8,3};
	public static void main(String[] args) {
		YourClass obj = new YourClass();
		obj.setCount(11);
		Temp a = new Temp();
		System.out.println(a);
		//methodOfA();
		
		//Integer i = new Integer(null); // runtime numberformat exception
		// String str = new String(null); compliation error
		//System.out.println("i: "+i);
		System.out.println("combo: "+combo());
	}
	
	private static int methodOfA()
    {
        return (true ? new Integer(null) : 0); //numberFormat exception
    }
	
	private static int combo(){
		int res = 0;
		// n!
		int evenCount =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0){
				evenCount++;
			}
		}
		int n = evenCount;
		System.out.println("evenCount "+evenCount);
		res = getFact(n)/(getFact(2)*getFact(n-2));
		
		n = arr.length-evenCount;
		System.out.println("Oddcount "+n);
		res = res + getFact(n)/(getFact(2)*getFact(n-2));
		
		return res;
	}
	
	private static int getFact(int n){
		int nFact = 1;
		for (int i = n; i > 0; i--) {
			nFact = nFact * (i);
		}
		System.out.println("fact of "+n+" is: "+nFact);
		return nFact;
	}

}


