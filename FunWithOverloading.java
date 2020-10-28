package com.revature;

public class FunWithOverloading {
	
	public static class A {
		
	}
	
	public static class B extends A {
		
	}
	
	public static class C extends B {
		
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Matching- exact match
		star(8);
		
		// 2. Conversion: primitives and objects
		int myInt = 127;
		long myLong = myInt;
		System.out.println("myLong: " + myInt);
		
		//int myInt2 = myLong; // This doesnt work!!
		
		B objectB = new B();
		A objectA = objectB; 
		//C objectC = objectB; //This doesnt work
		
		
		// 3. Boxing/unboxing
		Integer y = new Integer(10);
		star(y);
		int x = 5;
		starWrapper(x);
		// 4. varargs
		star(1, 2, 3, 4);

	}
	
	public static void star(int A) {
		System.out.println("arguments: " + A);
	}
	
	public static void starWrapper(Integer A) {
		System.out.println("arguments: " + A);
	}
	
	public static void star(int A, int B) {
		System.out.println("arguments: " + A + " and " + B);
	}
	
	public static void star(int ... myStars) {
		System.out.println("myStars args:");
		for (int star : myStars) {
			System.out.println(star);
		}
	}

}
