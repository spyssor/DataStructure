package DataStructure.Array;

public class Array<E> {

    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构建Array
    public Array(int capacity){

        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造函数，默认数组的容量capacity=10
    public Array(){

        data = (E[]) new Object[10];
        size = 0;
    }

    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];
        size = arr.length;
    }

    //获取数组容量
    public int getCapacity(){

        return data.length;
    }

    //获取数组中的元素个数
    public int getSize(){

        return size;
    }

    //返回数组是否为空
    public Boolean isEmpty(){

        return size == 0;
    }

    //在index索引的位置插入一个新元素e
    public void add(int index, E e){

        if (index < 0 || index > size){
            throw new IllegalArgumentException("add fail");
        }
        if (size == data.length){
            resize(2*data.length);
        }
        for (int i = size - 1; i >= index; i --){
            data[i+1] = data[i];
        }
        data[index] = e;

        size ++;
    }

    //在数组最后插入元素e
    public void addLast(E e){

        add(size, e);
    }

    //在数组开头插入元素e
    public void addFirst(E e){

        add(0, e);
    }

    //获取index索引位置的元素
    public E get(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("get failed");
        }
        return data[index];
    }

    public E getLast(){

        return get(size - 1);
    }

    public E getFirst(){

        return get(0);
    }

    //修改index索引位置的元素为e
    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("set failed");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean Contains(E e){

        for (int i = 0; i < size; i ++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在，则返回-1
    public int find(E e){
        for (int i = 0; i < size; i ++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        if (size == data.length / 4){
            resize(data.length / 2);
        }

        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){

        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){

        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    //将数组空间的容量编程newCapacity大小
    private void resize(int newCapacity){

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j){

        if (i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index is illegal");
        }

        E t = data[j];
        data[j] = data[i];
        data[i] = t;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("DataStructure.Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
