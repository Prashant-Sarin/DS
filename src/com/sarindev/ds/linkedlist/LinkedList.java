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

			n.next = temp.next;
			temp.next = n;
			length++;
		}

	}

	public void delete(T data) {
		Node<T> n = new Node<>(data);
		Node<T> previous = null;
		Node<T> temp = head;

		if (head.data == data) {
			head = head.next;
			length--;
			return;
		} else {
			while (temp.next != null) {
				previous = temp;
				temp = temp.next;
				if (temp.data == n.data) {
					previous.next = temp.next;
					temp.next = null;
					length--;
					return;
				}
			}
		}

	}

	public void reverse() {
		Node<T> temp = head;
		// Node<T> temp1=head;
		Node<T> current = null;
		Node<T> previous = null;
		while (temp != null) {
			current = temp;
			temp = current.next;
			current.next = previous;
			previous = current;
		}
		head = previous;
	}

	// public void reverse() {
	// Node<T> temp = head;
	// LinkedList<T> reverseList = new LinkedList<T>();
	// while(temp!=null) {
	// reverseList.insertAtFirst(temp.data);
	// temp= temp.next;
	// }
	// this.head = reverseList.head;
	// }

	public T nFromLast(int n) {
		Node<T> node = null;
		int diff = length - n;
		// Node<T> previous=null;
		Node<T> current = head;
		if (diff < 0) {
			return null;
		} else {
			int count = 0;
			while (current != null && count != diff) {
				current = current.next;
				count++;
			}
			node = current;
		}
		return node.data;
	}

	public int getLength() {
		if (head == null)
			return 0;
		else {
			head = head.next;
			return 1 + getLength();
		}
		// return length;
	}

	public boolean contains(T data) {
		Node<T> current = head;
		while (current != null) {
			// System.out.println("current.data = "+current.data);
			if (current.data == data)
				return true;
			current = current.next;
		}
		return false;
	}

	public void swap(T data1, T data2) {
		Node<T> node1 = null;
		Node<T> node2 = null;
		Node<T> previous1 = null;
		Node<T> previous2 = null;
		Node<T> next1 = null;
		Node<T> next2 = null;
		Node<T> previous = null;
		Node<T> current = head;
		boolean found1 = false;
		boolean found2 = false;
		while ((current != null) && !(found1 && found2)) {
			if (current.data == data1) {
				found1 = true;
				node1 = current;
				previous1 = previous;
				System.out.println("Node1  = " + node1.data);
				// System.out.println("previous1 = "+previous1.data);
				next1 = current.next;
				// If both nodes are adjacent nodes
				if (next1 != null) {
					if (next1.data == data2) {
						next2 = next1.next;
						if (previous1 != null) {
							previous1.next = next1;
						} else {
							head = next1;
						}
						next1.next = current;
						current.next = next2;
						return;
					}
				}
			} else if (current.data == data2) {
				found2 = true;
				node2 = current;
				previous2 = previous;
				System.out.println("Node2  = " + node2.data);
				// System.out.println("previous2 = "+previous2.data);
				next2 = current.next;
				// If both nodes are adjacent nodes
				if (next2 != null) {
					if (next2.data == data1) {
						next1 = next2.next;
						if (previous2 != null) {
							previous2.next = next2;
						} else {
							head = next2;
						}
						next2.next = current;
						current.next = next1;
						return;
					}
				}
			}
			previous = current;
			current = current.next;
		}
		if (found1 && found2) {
			if (previous1 != null) {
				previous1.next = node2;
			} else {
				head = node2;
			}
			node2.next = next1;
			if (previous2 != null) {
				previous2.next = node1;
			} else {
				head = node1;
			}
			node1.next = next2;
		}
	}

}
