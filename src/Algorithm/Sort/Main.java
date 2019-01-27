package Algorithm.Sort;

import java.util.Arrays;

public class Main {

    // 比较SelectionSort, InsertionSort和BubbleSort和ShellSort四种排序算法的性能效率
    // ShellSort是这四种排序算法中性能最优的排序算法
    public static void main(String[] args) {

        int N1 = 20000;

        //小数据集测试
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N1 + " , random range [0, " + N1 + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N1, 0, N1);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr8 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Algorithm.Sort.SelectionSort2", arr1);
        SortTestHelper.testSort("Algorithm.Sort.InsertionSort", arr2);
        SortTestHelper.testSort("Algorithm.Sort.BubbleSort2", arr3);
        SortTestHelper.testSort("Algorithm.Sort.ShellSort", arr4);
        SortTestHelper.testSort("Algorithm.Sort.MergeSort", arr5);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort2Ways", arr6);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort3Ways", arr7);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr8);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N1 + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N1, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);
        arr8 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Algorithm.Sort.SelectionSort2", arr1);
        SortTestHelper.testSort("Algorithm.Sort.InsertionSort", arr2);
        SortTestHelper.testSort("Algorithm.Sort.BubbleSort2", arr3);
        SortTestHelper.testSort("Algorithm.Sort.ShellSort", arr4);
        SortTestHelper.testSort("Algorithm.Sort.MergeSort", arr5);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort2Ways", arr6);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort3Ways", arr7);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr8);

        System.out.println();


        //大数据集测试
        int N2 = 1000000;

        // 测试3 一般性测试
        System.out.println("Test for random array, size = " + N2 + " , random range [0, " + N2 + "]");

        arr1 = SortTestHelper.generateRandomArray(N2, 0, N2);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Algorithm.Sort.MergeSort", arr1);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort2Ways", arr2);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort3Ways", arr3);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr4);

        System.out.println();


        // 测试4 测试近乎有序的数组
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N2 + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N2, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("Algorithm.Sort.MergeSort", arr1);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort2Ways", arr2);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort3Ways", arr3);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr4);

        System.out.println();


        // 测试5 测试存在包含大量相同元素的数组
        System.out.println("Test for big amount of same random elements array, size = " + N2 + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N2, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Algorithm.Sort.MergeSort", arr1);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort2Ways", arr2);
        SortTestHelper.testSort("Algorithm.Sort.QuickSort3Ways", arr3);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr4);

        return;
    }
}