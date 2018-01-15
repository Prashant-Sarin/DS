package com.sarindev.ds.linkedlist;


/**
 * Class to demonstrate use of custom class LinkedList
 * */
public class Single_Linked_List {

	public static void main(String[] args) {
		//Initialize linkedList
		LinkedList<String> linkedList = new LinkedList<>();
		//insert items in linkedList
		linkedList.insertAtFirst("prashant1");
		linkedList.insertAtFirst("prashant2");
		linkedList.insertAtFirst("prashant3");
		linkedList.insertAtFirst("prashant4");

//		
//		try {
//			linkedList.insertAt(2, "Dev");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		linkedList.printAll();
//		linkedList.delete("prashant3");
//		System.out.println("after deletion : ");
//		linkedList.printAll();
		System.out.println("After reversing : ");
		linkedList.reverse();
		linkedList.printAll();
//		System.out.println("Nth number from last :");
//		System.out.println(linkedList.nFromLast(2));
//		System.out.println("Length of LinkedList = "+linkedList.getLength());
//		System.out.println("contains \"prashant2\" = "+linkedList.contains("prashant2"));
		linkedList.swap("prashant1", "prashant4");
		System.out.println("after swap");
		linkedList.printAll();
	}

}
