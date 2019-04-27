package DataStructure.Queue;

import DataStructure.Array.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {

        array = new Array<E>(capacity);
    }

    public ArrayQueue(){

        array = new Array<E>();
    }

    public int getCapacity(){

        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {

        array.addLast(e);
    }

    @Override
    public E dequeue() {

        return array.removeFirst();
    }

    @Override
    public E getFront() {

        return array.getFirst();
    }

    @Override
    public int getSize() {

        return array.getSize();
    }

    @Override
    public boolean isEmpty() {

        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("DataStructure.Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
