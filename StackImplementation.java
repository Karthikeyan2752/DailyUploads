/* Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.


 */
package com.leetcodes1;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementation {
	Queue<Integer> q1 = new LinkedList<>();

	public void push(int x) {
		int s = q1.size();
		q1.add(x);

		int i = 0;
		while (s > i) {
			q1.add(q1.remove());
			i++;
		}
	}

	public int pop() {
		if (q1.isEmpty()) {
			return -1;
		}

		return q1.remove();
	}

	public int top() {

		if (q1.isEmpty()) {
			return -1;
		}
		return q1.peek();
	}

	public boolean empty() {
		return q1.isEmpty();
	}

	public static void main(String[] args) {
		StackImplementation myStack = new StackImplementation();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False
	}
}
