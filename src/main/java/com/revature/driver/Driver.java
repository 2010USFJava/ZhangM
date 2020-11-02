package com.revature.driver;

import java.util.Scanner;

import com.revature.beans.Cat;
import com.revature.util.*;

public class Driver {

	public static void main(String[] args) {
	
		//Cat testCat = new Cat("dave", 20, 5, "tabby", "orange");
		//FileStuff.writeCatFile(Roster.catList);
		FileStuff.readCatFile();
		System.out.println(Roster.catList);
		Cat myCat = makeCat();
		FileStuff.writeCatFile(Roster.catList);

	}
	
	//static {FileStuff.readCatFile();}
	
	public static Cat makeCat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of your cat?");
		String name = sc.nextLine();
		System.out.println("What is the weight of your cat?");
		Double weight = Double.parseDouble(sc.nextLine());
		System.out.println("What is the age of your cat?");
		Integer age = Integer.parseInt(sc.nextLine());
		System.out.println("What is the breed of your cat?");
		String breed = sc.nextLine();
		System.out.println("What is the color of your cat?");
		String color = sc.nextLine();
		Cat myCat = new Cat(name, weight, age, breed, color);
		LogThis.LogIt("info", name +" the "+ color + " " + breed + " has been saved.");
		System.out.println("Thank you. Your cat " + name + " has been saved!");
		return myCat;
	}

}
