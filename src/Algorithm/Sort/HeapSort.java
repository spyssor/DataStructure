package Algorithm.Sort;

import DataStructure.Heap.MaxHeap;

public class HeapSort {

    // 我们的算法类不允许产生任何实例
    private HeapSort(){}

    // 对整个arr数组使用HeapSort1排序
    // HeapSort, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap<>(arr);

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Algorithm.Sort.HeapSort", arr);

        return;
    }
}