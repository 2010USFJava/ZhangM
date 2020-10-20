package com.driver;

import com.revature.Cat;
import com.revature.Paw;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paw paw1 = new Paw(5, "pink");
		Paw paw2 = new Paw(5, "pink");
		Paw paw3 = new Paw(4, "pink");
		Paw paw4 = new Paw(4, "chocolate");
		Paw[] paws = {paw1, paw2, paw3, paw4};
		Cat pepper = new Cat("Pepper", "grey and white", 2, paws);
		System.out.println(pepper);
	}

}
