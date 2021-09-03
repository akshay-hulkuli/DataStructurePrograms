package com.bridgelabz.dsprograms;

import java.util.ArrayList;
import java.util.Arrays;

import com.bridgelabz.datastructures.MyQueue;

public class AnagramCheckerQueue {
	private static ArrayList<Integer> printPrimeNumber(int maxLimit) {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		for(int i=2;i<=maxLimit;i++) {
			boolean flag = true;
			for(int j=2;j<=i/2;j++) {
				if(i%j == 0) flag = false; 
			}
			if(flag) myQueue.enqueue(i);
		}
		
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		while(!myQueue.isEmpty()) {
			primeNumbers.add(myQueue.dequeue());
		}
		return primeNumbers;
	}
	
	
	private static void anagramChecker(ArrayList<Integer> list) {
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(isAnagram(list.get(i), list.get(j))) {
					System.out.println("the numbers that are Anagrams "+list.get(i)+"-"+list.get(j));
				}
			}
		}
	}
	
	private static boolean isAnagram(int number1 , int number2) {
			String str1 = String.valueOf(number1);
			String str2 = String.valueOf(number2);
			if(str1.length() != str2.length()) return false;
			char[] array1 = str1.toCharArray();
			char[] array2 = str2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			return Arrays.equals(array1, array2);
	}
	
	public static void main(String[] args) {
		int maxLimit = 1000;
		System.out.println("Prime numbers in the range 0-"+maxLimit+" are:");
		ArrayList<Integer> primeNumbers = printPrimeNumber(maxLimit);
		for(int i=0;i<primeNumbers.size();i++) {
			System.out.print(primeNumbers.get(i)+" ");
		}
		System.out.println();
		anagramChecker(primeNumbers);
		
	}	
}
