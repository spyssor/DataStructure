package SwordOffer;

public class S1_FindInTwoDimensionalArrays {

    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    // 每一列都按照从上到下递增的顺序排序。
    // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    //1  4  7  11  15
    //2  5  8  12  19
    //3  6  9  16  22
    //10 13 14 17  24
    //18 21 23 26  30
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        int startR = 0;
        int startC = col - 1;
        while (startR <= row - 1 && startC >= 0){
            if (array[startR][startC] == target){
                return true;
            }
            else if (array[startR][startC] > target){
                startC --;
            }
            else{
                startR ++;
            }
        }
        return false;
    }
}
