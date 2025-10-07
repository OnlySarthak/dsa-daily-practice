package Stack

import java.util.Deque;

class Stack {
    Deque<Integer> dq = new ArrayDeque<>();

    public MyStack() {
    }
    
    public void push(int x) {
        dq.addLast(x);   // push element at back
    }
    
    public int pop() {
        return dq.removeLast(); // remove from back
    }
    
    public int top() {
        return dq.getLast(); // peek last element
    }
    
    public boolean empty() {
        return dq.isEmpty(); // check if deque is empty
    }
}