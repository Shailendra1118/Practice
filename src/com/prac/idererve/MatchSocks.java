package com.prac.idererve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MatchSocks {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("D:\\Keppler\\Practice\\src\\com\\prac\\idererve\\socInput.txt"));
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        System.out.println(Arrays.toString(c));
        int carr[] = new int[200];
        for(int i=0; i<n; i++){
            int idx = c[i];
            carr[idx]++;
        }
        System.out.println(Arrays.toString(carr));
        int max = 0;
        for(int j=0; j<carr.length; j++){
            if(carr[j] >= 2)
            	//max = max + carr[j]/2; OR
            	max += carr[j] >> 1;
        }
        in.close();
        System.out.println("Max: "+max);

	}

}
