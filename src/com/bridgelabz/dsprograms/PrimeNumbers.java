package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumbers {
	private static ArrayList<ArrayList<Integer>> printPrimeNumber(int maxLimit) {
		ArrayList<ArrayList<Integer>> primeNumbers = new ArrayList<ArrayList<Integer>>();
		int index = 0;
		int k=0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i=2;i<=maxLimit;i++) {
			    
			boolean flag = true;
			for(int j=2;j<=i/2;j++) {
				if(i%j == 0) flag = false; 
			}
			
			if(k<100) {
				if(flag) arrayList.add(i);
				k++;
			}
			else {
				k = 0;
				primeNumbers.add(arrayList);
				arrayList = new ArrayList<Integer>();
				if(flag) arrayList.add(i);
				k++;
			}
				
		}
		primeNumbers.add(arrayList);
		return primeNumbers;
	}
	public static void main(String[] args) {
		int maxLimit = 1000;
		System.out.println("Prime numbers in the range 0-"+maxLimit+" are:");
		ArrayList<ArrayList<Integer>> primeNumbers = printPrimeNumber(maxLimit);
		for(int i=0;i<primeNumbers.size();i++) {
			System.out.println(primeNumbers.get(i)+" ");
		}
		
	}
}
