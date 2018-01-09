package com.sarindev.ds.linkedlist;

import com.sarindev.ds.linkedlist.LinkedList.Node;

public class LinkedList<T> {

	private Node<T> head;
	private int length = 0;

	public class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	public void insertAtFirst(T data) {
		Node<T> n = new Node<T>(data);
		if (head != null) {
			n.next = head;
		}
		head = n;
		length++;

	}

	public void insertAtLast(T data) {
		Node<T> n = new Node<T>(data);
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = n;
		length++;
	}

	public void printAll() {
		Node<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public int length() {
		return length;
	}

	public void insertAt(int position, T data) throws Exception {
		Node<T> n = new Node<>(data);
		if (position == 0) {
			insertAtFirst(data);
			return;
		}
		if (position == length) {
			insertAtLast(data);
			return;
		}
		if (position > length || position < 0) {
			Exception e = new Exception("Cannot insert at mentioned position.");
			throw e;
		} else {

			Node<T> temp = head;
			for (int i = 0; i < position - 1; i++) {
				temp = temp.next;
			}
			System.out.println("temp  = " + temp.data);

			n.next = temp.next;
			temp.next = n;
		}

	}

	public void delete(T data) {
		Node<T> n = new Node<>(data);
		Node<T> previous = null;
		Node<T> temp = head;

		if(head.data == data) {
			head=head.next;
			return;
		}else {
			while (temp.next!=null) {
				previous=temp;
				temp=temp.next;
				if (temp.data == n.data) {
					previous.next =temp.next;
					temp.next=null;
					return;
				}
			}
		}
				
	}

}
