package algorithms;

import java.util.Arrays;

public class TestAlgorithms {
    public static void main(String[] args) {
        int[] seq = {2, 3, 10, 1, 2, 4, 7, 5, 9, 12, 0, 1, 1, 30, 8};
        
        System.out.println(Arrays.toString(seq));
        Sort.quickSort(seq);
        System.out.println(Arrays.toString(seq));
    }
}