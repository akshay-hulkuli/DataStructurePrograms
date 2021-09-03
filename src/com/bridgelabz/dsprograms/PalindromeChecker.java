package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;
import java.util.Scanner;

public class PalindromeChecker {
	private static boolean palindromeChecker(char[] charArray) {
		MyDequeue<Character> myDeque = new MyDequeue<Character>();
		for(char ch : charArray) {
			myDeque.addRear(ch);
		}
		while(myDeque.size()>1) {
			if(myDeque.size() == 2) {
				if(myDeque.removeFront() == myDeque.removeFront()) return true;
				else return false;
			}
			if(myDeque.removeFront() != myDeque.removeRear()) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String string = sc.nextLine();
		char[] charArray = string.toCharArray();
		
		System.out.println("Is the String "+string+" a palindrome : "+ palindromeChecker(charArray));
		sc.close();
	}
}
