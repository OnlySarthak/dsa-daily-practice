package Recursion;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Rec3 {

    public void engine(int[] arr, int ind, int target, int sum, Stack<Integer> comb, List<List<Integer>> ans) {
        if (ind == arr.length)
            return;

        if(sum<target)engine(arr, ind+1)

        comb.push(arr[ind]);
        sum +=arr[ind];

    }

    public static List<Integer> checkAndReturn(Stack<Integer> st) {
        return new ArrayList<>(st);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    }
}