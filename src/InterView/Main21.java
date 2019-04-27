package InterView;

import java.util.Scanner;

public class Main21 {

    private static int score = 0;
    private static int reduce = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];
        for (int i = 0; i < n; i ++){
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i ++){
            B[i] = sc.nextInt();
        }
        sort(A);
        sort(B);
        calcMax(A, B);

    }

    public static void calcMax(Comparable[] A, Comparable[] B){

        int indexA = A.length-1, indexB = B.length-1;
        while (indexA >= 0 && indexB >= 0){
            if (A[indexA].compareTo(B[indexB]) > 0){
                score += 100;
                indexA --;
                indexB --;
            }
            else if (A[indexA].compareTo(B[indexB]) < 0){
                indexB --;
                reduce += 100;
            }
            else{
                if (indexA == 0 || indexB == 0){
                    indexA --;
                    indexB --;
                }
                else{
                    indexB --;
                    reduce += 100;
                }

            }
        }

        int res = score - reduce;

        System.out.println(res);
    }


    public static void sort(Comparable[] arr){

        int n = arr.length;
        int h = 1;

        while(h < n/3){
            h = h*3+1;
        }

        while(h >= 1){
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
