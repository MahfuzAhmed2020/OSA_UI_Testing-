package com.own.practice;

import java.util.Scanner;

public class Pro {
	public static void main(String[] args) {
//	System.out.println("java.runtime.version = "+System.getProperty("java.runtime.version"));
//	System.out.println("java.version = "+System.getProperty("java.version"));
//	System.out.println("os.name = "+System.getProperty("os.name"));
//	assignOperator();
//	logicalOperator();
	bitwiseExample();
	}
	public static void assignOperator() {
		
		int a=5;
		int b=15;
		String x="name"; 
	      b=a+b;//20
	      a=a+b;//5+20= 25
		 a+=10; // a=a+10   a=25+10=35
		 a-=11;// a=a-11
		// a++;
		 System.out.println("a+=10;=  "+a);//24
		 System.out.println("a=  "+a);//24
		 System.out.println("a++  = "+a++);//24
		 System.out.println("a++  = "+a++);//25
		 System.out.println("a++  = "+--a);//25
	}
	public static void logicalOperator() {
		Scanner input=new Scanner(System.in);
		int p=input.nextInt();
		System.out.println(p);
		
	}
	public static void bitwiseExample() {

		int a=12;
		int b=32;
		int c=a|b;
		System.out.println(c);
		System.out.println(a);
		
	}

}
