package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;
import java.util.Scanner;

public class UnOrderedList {
	
	private static void searchWord(String[] words, String key) {
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		for(String word : words) {
			MyNode<String> newNode = new MyNode<String>(word);
			myLinkedList.append(newNode);
		}
		
		INode<String> searchedNode  = myLinkedList.search(key);
		if(searchedNode == null ) {
			MyNode<String> newNode = new MyNode<String>(key);
			myLinkedList.append(newNode);
			System.out.println("the key : "+key+" is not found hence added it to the list");
		}
		else {
			myLinkedList.delete(key);
			System.out.println("the key : "+key+" is found hence removed it from the list");
		}
		
		myLinkedList.display();
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the setence");
		String inputString = sc.nextLine(); 
		String[] words = inputString.toLowerCase().split(" ");
		System.out.println("Enter the word to be searched");
		String key = sc.next();
		
		searchWord(words,key);
		sc.close();
	}
}
