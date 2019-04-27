package SwordOffer;

import java.util.ArrayList;

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
// 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字             1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class S19_PrintMatrix {

    private ArrayList<Integer> res;

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        res = new ArrayList<>();
        if (row == 0 || col == 0){
            return res;
        }

        int left = 0, top = 0, right = col-1, bottom = row-1;
        while (left <= right && top <= bottom){

            for (int i = left; i <= right; i ++){
                res.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i ++){
                res.add(matrix[i][right]);
            }
            if (top != bottom){
                for (int i = right-1; i >= left; i --){
                    res.add(matrix[bottom][i]);
                }
            }
            if (left != right){
                for (int i = bottom-1; i > top; i --){
                    res.add(matrix[i][left]);
                }
            }

            top++;left++;right--;bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int num = 1;
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                matrix[i][j] = num++;
            }
        }

        ArrayList<Integer> arrayList = new S19_PrintMatrix().printMatrix(matrix);
        System.out.println(arrayList);
    }
}
