package com.bridgelabz.dsprograms;

import java.util.*;

public class Calendar {
	
	public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    public static boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
    }

    
    public static int[][] getCalendar(int month, int year){
        
        int[] numberOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) numberOfDays[month] = 29;

        int d = day(month, 1, year);
        int [][] calendar = new int[6][7];
//        for (int i = 0; i < d; i++)
        int i =0, k =d-1;    
        for (int j = 1; j <= numberOfDays[month]; j++) {
            calendar[i][k] = j;
            k++;
            if (((j + d) % 7 == 0) || (j == numberOfDays[month])) {
            	i++;k=0;
            }
        }
        return calendar;
    }

	public static void main(String[] args) {
	    int month = Integer.parseInt(args[0])-1;    
	    int year = Integer.parseInt(args[1]); 
	    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
	    System.out.println( months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
	    int[][] calendar = getCalendar(month, year);
	    for(int i=0;i<6;i++) {
	    	for(int j=0;j<7;j++) {
	    		System.out.printf("%2d ",calendar[i][j]);
	    	}
	    	System.out.println();
	    }
	}
}



