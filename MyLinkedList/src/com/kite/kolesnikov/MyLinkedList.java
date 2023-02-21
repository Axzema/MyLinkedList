package com.kite.kolesnikov;

import java.util.Arrays;

public class MyLinkedList {
	
	private Node first;
	private Node last;
	private int size;
	
	
	// add a new value to a list
	public void add(int value) {
		last = first;
		Node newNode = new Node(value);
		if (first == null) {
			first = newNode;

		} else {
			while (last.next != null) {
				last.prev = last;
				last = last.next;
			}

			last.next = newNode;
			newNode.prev = last;
		}
		size++;

	}
	
	
	// remove node from a list through its index
	public void remove(int index) {
		int currentIndex = 0;
		Node temp = first;

		// if its a first Node
		if (index == 0) {
			first = first.next;
			first.prev = null;
			size--;
			return;
		}

		// if its a last Node
		if (index == size - 1) {
			while (temp.next != null) {
				temp.prev = temp;
				temp = temp.next;
			}
			temp.prev.next = null;
			temp.prev = null;

			size--;
			return;

		}

		while (temp != null) {
			if (currentIndex == index) {
				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
				temp.next = null;
				temp.prev = null;

				size--;
				return;
			}

			temp = temp.next;
			currentIndex++;
		}

	}
	
	
	
	// return value by its index in a list
	public int get(int index) {
		int currentIndex = 0;
		Node temp = first;

		while (temp != null) {
			if (currentIndex == index) {
				return temp.value;
			}
			temp = temp.next;
			currentIndex++;

		}
		throw new IllegalArgumentException();
	}
	
	
	// size of a list
	public int size() {
		return this.size;
	}
	
	
	
	//print our list
	public String toString() {
		int[] result = new int[size];
		Node temp = first;
		int i = 0;

		while (temp != null) {
			result[i++] = temp.value;
			temp = temp.next;

		}
		return Arrays.toString(result);
	}
	
	
	
	public static class Node{
		
		private Node prev;
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
	}

}
