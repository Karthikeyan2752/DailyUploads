/*
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 
 */

package com.recursion;

public class MergeTwoSortedLists {

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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-1);
		ListNode retHead = head;

		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				retHead.next = list2;
				list2 = list2.next;
			} else {
				retHead.next = list1;
				list1 = list1.next;
			}
			retHead = retHead.next;
		}
		while (list1 != null) {
			retHead.next = list1;
			list1 = list1.next;
			retHead = retHead.next;
		}
		while (list2 != null) {
			retHead.next = list2;
			list2 = list2.next;
			retHead = retHead.next;
		}
		return head.next;
	}
}
