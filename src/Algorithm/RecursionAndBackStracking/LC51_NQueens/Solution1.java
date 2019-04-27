package Algorithm.RecursionAndBackStracking.LC51_NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/// 51. N-Queens
/// https://leetcode.com/problems/n-queens/description/
/// 时间复杂度: O(n^n)
/// 空间复杂度: O(n)
public class Solution1 {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();

        col = new boolean[n];
        dia1 = new boolean[n*2-1];
        dia2 = new boolean[n*2-1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);

        return res;
    }

    private void putQueen(int n, int index, LinkedList<Integer> row){
        if (index == n){
            res.add(generateBoard(n, row));
            return;
        }

        //列
        for (int i = 0; i < n; i ++){
            if (!col[i] && !dia1[index + i] && !dia2[index-i + n - 1]){
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }

        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row){
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i ++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(String.valueOf(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 2;
        List<List<String>> res = (new Solution1()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
        System.out.println("====================================");
        System.out.println(res.size());
    }
}
