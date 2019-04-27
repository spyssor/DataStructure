package Algorithm.RecursionAndBackStracking.LC51_NQueens;

import java.util.concurrent.*;

public class solution {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private static int count = 0;
    public int totalNQueens(int n) {

        col = new boolean[n];
        dia1 = new boolean[n*2-1];
        dia2 = new boolean[n*2-1];

        putQueen(n, 0);

        return count;
    }

    private void putQueen(int n, int index){
        if (index == n){
            count ++;
            return;
        }

        //列
        for (int i = 0; i < n; i ++){
            if (!col[i] && !dia1[index + i] && !dia2[index-i + n - 1]){
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }

        return;
    }

    public static void main(String[] args) {
        System.out.println(new solution().totalNQueens(3));
    }
}
