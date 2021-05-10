package medium.array;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author ChenZT
 */
public class searchMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    // 思路：从左下角找起，如果小则找上一行，如果大则找右边那列
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int num = matrix[row][col];
            if (target == num) {
                return true;
            } else if (target < num) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
