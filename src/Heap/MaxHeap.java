package Heap;

import Array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){

        data = new Array<E>(capacity);
    }

    public MaxHeap(){

        data = new Array<E>();
    }

    //将任意数组整理成堆 heapify
    public MaxHeap(E[] arr){

        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    public int size(){

        return data.getSize();
    }

    public boolean isEmpty(){

        return data.isEmpty();
    }

    private int parent(int index){

        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }

        return (index-1) / 2;
    }

    private int leftChild(int index){

        return index * 2 + 1;
    }

    private int rightChild(int index){

        return index * 2 + 2;
    }

    public void add(E e){

        data.addLast(e);
        siftUp(data.getSize() - 1);

    }

    private void siftUp(int k){

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax(){

        if (data.isEmpty()){
            throw new IllegalArgumentException("can not findMax when heap is empty");
        }
        return data.getFirst();
    }

    public E extractMax(){

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
            //默认左孩子最大
            int j = leftChild(k);
            //如果有右孩子&&右孩子>左孩子  默认为右孩子最大
            if (j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            //判断当前节点是否比左或右孩子大  是：停止siftDown
            if (data.get(k).compareTo(data.get(j)) > 0){
                break;
            }
            //否：交换位置继续siftDown
            data.swap(k, j);
            k = j;
        }
    }

    //取出同时再放入一个元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);

        return ret;
    }



























}
