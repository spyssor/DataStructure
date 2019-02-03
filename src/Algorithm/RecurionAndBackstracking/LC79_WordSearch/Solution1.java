package Algorithm.RecurionAndBackstracking.LC79_WordSearch;

/// 79. Word Search
/// Source : https://leetcode.com/problems/word-search/description/
///
/// 回溯法
/// 时间复杂度: O(m*n*m*n)
/// 空间复杂度: O(m*n)
public class Solution1 {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0;i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY){

        //如果匹配到word的最后一个字母的时候，判断是否与当前位置的值相等
        if (index == word.length()-1){
            return board[startX][startY] == word.charAt(index);
        }

        //如果当前值与word的在index位置的值相等，进入条件中
        if (board[startX][startY] == word.charAt(index)){
            //将该点先置为访问过状态
            visited[startX][startY] = true;
            //分别判断该点的四个方向的点是否能跟index+1位置的word字母匹配
            for (int i = 0; i < 4; i ++){
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (isArea(newX, newY) && !visited[newX][newY] && searchWord(board, word, index + 1, newX, newY)){
                    return true;
                }
            }
            //四个方向都不匹配，将该点置为未被访问状态
            visited[startX][startY] = false;
        }
        //回退到上一个点位置
        return false;
    }

    private boolean isArea(int newX, int newY){
        if (newX >= 0 && newX < m && newY >= 0 && newY < n){
            return true;
        }
        return false;
    }

    public static void main(String args[]){

        char[][] b1 = { {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};

        String words[] = {"ABCCED", "SEE", "ABCB", "AB" };
        for(int i = 0 ; i < words.length ; i ++)
            if((new Solution1()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if((new Solution1()).exist(b2,"AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
