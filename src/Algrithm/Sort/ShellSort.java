package Algrithm.Sort;

public class ShellSort {

    // 我们的算法类不允许产生任何实例
    private ShellSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        int h = 1;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        while(h < n/3){
            h = h*3+1;
        }

        while(h >= 1){

            // h-sort the array
            for (int i = h; i < n; i ++){

                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j-h]) < 0; j-=h){
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }

            h /= 3;
        }
    }
}
