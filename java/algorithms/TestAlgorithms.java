package algorithms;

import java.util.Arrays;

public class TestAlgorithms {
    public static void main(String[] args) {
        testQuickSort();
    }

    private static void testQuickSort() {
        int[] seq = {2, 3, 10, 1, 2, 4, 7, 5, 9, 12, 0, 1, 1, 30, 8};
        var seq_copy = seq.clone(); // 使用拷贝方法避免地址引用导致对象内容被修改

        System.out.println("Using qsort:\nBefore: " + Arrays.toString(seq));
        Sort.quickSort(seq);
        System.out.println("After: " + Arrays.toString(seq));
        
        System.out.println("\nUsing Array.sort():\nBefore: " + Arrays.toString(seq_copy));
        Arrays.sort(seq_copy);
        System.out.println("After: " + Arrays.toString(seq_copy));
    }
}
