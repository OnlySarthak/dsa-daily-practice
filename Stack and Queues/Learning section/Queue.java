import java.util.Stack;

public class Queue {
    Stack<Integer> st = new Stack<>();
    public Queue() {
        
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){       //shift data from st to temp
            temp.push(st.pop());
        }
        st.push(x);
        while(!temp.isEmpty()){       //shift data from temp to st
            st.push(temp.pop());
        }
    }
    public void push2(int x) {      //fast but not standard
        int[] temp = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()){       //shift data from st to temp
            temp[i] = st.pop();
            i++;
        }
        st.push(x);
        while(i != -1){       //shift data from temp to st
            st.push(temp[i]);
            i--;
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}
