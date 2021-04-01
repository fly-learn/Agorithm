package com.fly.ftx.leedcode.swordOffer.array.questions;

import java.util.Stack;

class Q09 {
    Stack<Integer> stack;
    Stack<Integer> stack2;
    public Q09() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack.empty()) {
            stack2.push(stack.pop());
        }
        stack.push(value);
        while(!stack2.empty()) {
            stack.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if(!stack.empty()) {
            return stack.pop();
        }
        return -1;
    }
}
