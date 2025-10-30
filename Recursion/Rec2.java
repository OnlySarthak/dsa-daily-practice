
import java.util.Stack;

public class Rec2 {

    public static void engine(int[] arr, boolean[] mask, int index, int k, int sum) {

        // pruning (allowed only when all numbers are positive)
        if (sum > k) return;

        if (index == arr.length) {
            if (sum == k) printArr(arr, mask);
            return;
        }

        // include arr[index]
        mask[index] = true;
        engine(arr, mask, index + 1, k, sum + arr[index]);

        // exclude arr[index]
        mask[index] = false;
        engine(arr, mask, index + 1, k, sum);
    }
    public static void engine2(int[] arr, Stack<Integer> st, int index, int k) {
        int sum = st.pop();
        
        if (index == arr.length){
            if(sum==k)printSt(st);
            st.push(sum);
            return;
        }
        // pruning (allowed only when all numbers are positive)
        if (sum > k){
            st.push(sum);
            return;
        } 
        if(sum==k){
            printSt(st);
            //if we havent 0 then keel thes 2 line uncommented
            st.push(sum);
            return;
        }

        // include arr[index]
        st.push(arr[index]);
        int nextSum = sum+arr[index];
        st.push(nextSum);
        engine2(arr,st,index+1,k);

        // exclude arr[index]
        st.pop();
        st.pop();
        nextSum -= arr[index];
        st.push(nextSum);
        engine2(arr,st,index+1,k);
    }

    public static void printSt(Stack<Integer> st){
        System.out.print("-> ");
        for (Integer integer : st) {
            System.out.print(integer);
        }
        System.out.println();
    }

    public static void printArr(int[] arr, boolean[] mask) {
        System.out.print("-> ");
        for (int i = 0; i < arr.length; i++) {
            if (mask[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5};   // test array
        int k = 5;                  // target sum

        Stack<Integer> st = new Stack<>();
        st.push(0);                 // initial sum at top

        engine2(arr, st, 0, k);
    }
}
