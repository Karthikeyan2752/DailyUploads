package com.dailyuploads;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInALinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public int[] nextLargerNodes(ListNode head) {
		ArrayList<Integer> a = new ArrayList<>();
		for (ListNode node = head; node != null; node = node.next) {
			a.add(node.val);
		}
		int[] result = new int[a.size()];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < a.size(); i++) {
			while (!stack.isEmpty() && a.get(stack.peek()) < a.get(i)) {
				result[stack.pop()] = a.get(i);
			}
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
