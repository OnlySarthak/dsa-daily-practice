public class Rec1 {
    public static void engine(int[] arr, boolean[] mask, int index) {
        if (index == arr.length) {
            printArr(arr, mask);
            return;
        }

        // include arr[index]
        mask[index] = true;
        engine(arr, mask, index + 1);

        // exclude arr[index]
        mask[index] = false;
        engine(arr, mask, index + 1);
    }

    public static void printArr(int[] arr, boolean[] mask) {
        System.out.print("-> ");
        for (int i = 0; i < arr.length; i++) {
            if (mask[i]) System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean[] mask = new boolean[5];
        int[] arr = {1, 2, 3, 4, 5};
        engine(arr, mask, 0);
    }
}
