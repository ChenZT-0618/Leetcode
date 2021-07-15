package medium.array;

/**
 * 请你判断一个 9x9 的数独是否有效。
 * 只需要根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * @author ChenZT
 */
public class isValidSudoku_36 {
    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
        System.out.println(25 & 26 & 17 & 18);
    }

    public static boolean isValidSudoku(char[][] board) {
        // 1 ms 38.6 MB
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] block = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                int blockIndex = 3 * (i / 3) + (j / 3);
                // 判断：
                // 数字 1-9 在每一行只能出现一次。
                // 数字 1-9 在每一列只能出现一次。
                // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
                if (row[i][num] > 0 || col[j][num] > 0 || block[blockIndex][num] > 0) return false;
                row[i][num]++;
                col[j][num]++;
                block[blockIndex][num]++;
            }
        }
        return true;
    }
}
