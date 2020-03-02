package com.oops.utility;

/**
 * Purpose: To perform queue operation using linked list
 * 
 * @author Sahil Kudake
 *
 */
public class QueueusingLinkedListUtility {

	@SuppressWarnings("rawtypes")
	static Node head;

	public static class Node<E> {
		E data;
		@SuppressWarnings("rawtypes")
		Node next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	public static <E> void enqueue(E data) {
		Node<?> temp;
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public static <E> E dequeue() {
		E data = null;
		if (!isEmpty()) {
			Node temp = head;
			data = (E) temp.data;
			head = temp.next;
		}
//			else {
//				System.out.println("Queue is empty");
//			}
		return data;
	}

	public static <E> void enqueueFront(E data) {
		Node temp;
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			temp = head;
			temp.next = temp;
			head = temp;
		}
	}

	public static <E> void enqueueRear(E data) {
		Node temp;
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp = head;
		}
	}

	public static <E> E dequeueFront() {
		E data = null;
		if (!isEmpty()) {
			Node temp = head;
			data = (E) temp.data;
			head = temp.next;
		} else {
			System.out.println("Queue is empty");
		}
		return data;

	}

	public static <E> E dequeueRear() {
		E data = null;
		if (!isEmpty()) {
			Node temp = head;
			Node prev = temp;
			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			data = (E) temp.data;
			prev.next = null;
		} else {
			System.out.println("Queue is empty");
		}
		return data;

	}

	public static boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public static void printQueue() {
		if (!isEmpty()) {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		} else {
			System.out.println("Queue is empty");
		}
	}
}
