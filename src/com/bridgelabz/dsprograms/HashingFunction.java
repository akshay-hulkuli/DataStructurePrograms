package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HashingFunction<K extends Comparable <K>> {
	
	private final int numBuckets; 
	ArrayList<MyLinkedList<K>> myBucketArray; 
	
	public HashingFunction() {
		this.numBuckets = 11;
		this.myBucketArray = new ArrayList<>(numBuckets);
		for(int i=0; i< numBuckets; i++) this.myBucketArray.add(null);
	}
	
	private int getBucketIndex(K key) {
		int hashCode = (key == null)?0:Math.abs(key.hashCode());
		int index = hashCode% numBuckets;
		return index;
	}
	
	public boolean isPresent(K key) {
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) return false;
		MyNode<K> myNode = (MyNode<K>) myLinkedList.search(key);
		return (myNode == null) ? false : true;
	}
	
	public void add(K key) {
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) {
			myLinkedList = new MyLinkedList<K>();
			this.myBucketArray.set(index,myLinkedList);
		}
		MyNode<K> myNode = (MyNode<K> ) myLinkedList.search(key);
		if(myNode == null) {
			myNode = new MyNode(key);
			myLinkedList.append(myNode);
		}
		else {
			myNode.setKey(key);
		}
	}
	
	public void remove(K key){
		int index = getBucketIndex(key);
		MyLinkedList<K> myLinkedList = myBucketArray.get(index);
		if(myLinkedList == null) return;
		MyNode<K> myNode = (MyNode<K>)myLinkedList.delete(key); 
		if(myNode != null)
		System.out.println("Deleted (key="+myNode.getKey()+")");
	}
	
	public void display() {
		int i = 0;
		System.out.print("the content of hash set is :");
		System.out.print("{");
		while(i< numBuckets) {
			System.out.print(" { ");
			if(myBucketArray.get(i) == null)System.out.print("null");
			else {
				MyNode<K> temp =(MyNode<K>) myBucketArray.get(i).head;
				while(temp!= null) {
					System.out.print(temp.getKey()+"->");
					temp = (MyNode<K>)temp.getNext();
				}
				System.out.print("null");
			}
			System.out.print(" }");
			i++;
		}
		System.out.println(" }");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Integers");
		int count = sc.nextInt();
		System.out.println("enter the Intrgers");
		HashingFunction<Integer> hashSet = new HashingFunction<Integer>();
		for(int i=0;i<count;i++) {
			hashSet.add(sc.nextInt());
		}
		hashSet.display();
		System.out.println("Enter element to be searched");
		int key = sc.nextInt();
		if(hashSet.isPresent(key)) {
			hashSet.remove(key);
			System.out.println("the key : "+key+" is found hence removed it from the hashset");
		}
		else {
			hashSet.add(key);
			System.out.println("the key : "+key+" is not found hence added it to the hashset");
		}
		hashSet.display();
		sc.close();
	}
}
