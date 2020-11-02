package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cat;

public class FileStuff {
	//public static final File catFile = new File("catList.txt");

	public static void writeCatFile(List<Cat> catList) {
		try {
			File catFile = new File("catList.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(catFile));
			objectOut.writeObject(catList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readCatFile() {
		try {
			File catFile = new File("catList.txt");
			ObjectInputStream objectIn= new ObjectInputStream(new FileInputStream(catFile));
			Roster.catList=(ArrayList<Cat>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
