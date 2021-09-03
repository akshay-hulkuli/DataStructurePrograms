package com.bridgelabz.dsprograms;

import com.bridgelabz.datastructures.*;
import java.util.Scanner;

public class BalancedParentheses {
	
	
	private static boolean parenthesesChecker(char[] expression) {
		MyStack<Character> myStack = new MyStack<Character>();
		for(char ch : expression) {
			if(ch == '(' ) {
				myStack.push(ch);
			}
			else if(ch == ')') {
				if(myStack.isEmpty()) return false;
				myStack.pop();
			}
		}
		return myStack.isEmpty();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Arithmetic Expression");
		String inputExpression = sc.nextLine();
		char[] expression = inputExpression.toCharArray();
		
		System.out.println("Is the expression "+inputExpression+" balanced : "+ parenthesesChecker(expression));
		sc.close();
	}
}
