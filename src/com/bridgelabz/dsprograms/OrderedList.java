package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;
import java.util.Scanner;

public class OrderedList {
	private static MyLinkedList<Integer> orderedList = new MyLinkedList<Integer>();
	private static void searchInteger(int key) {
		INode<Integer> searchedNode  = orderedList.search(key);
		if(searchedNode == null ) {
			MyNode<Integer> newNode = new MyNode<Integer>(key);
			orderedList.addInOrder(newNode);
			System.out.println("the key : "+key+" is not found hence added it to the list");
		}
		else {
			orderedList.delete(key);
			System.out.println("the key : "+key+" is found hence removed it from the list");
		}
		
		orderedList.display();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		
		int count  = sc.nextInt();
		System.out.println("Enter the elements");
		for(int i=0;i<count ;i++) {
			MyNode<Integer> newNode  = new MyNode<Integer>(sc.nextInt());
			orderedList.addInOrder(newNode);
		}
		orderedList.display();
		System.out.println("enter the key to be searched ");
		int key = sc.nextInt();
		
		searchInteger(key);
	}
}
