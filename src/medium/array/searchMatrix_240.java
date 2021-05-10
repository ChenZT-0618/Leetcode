package medium.array;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author ChenZT
 */
public class searchMatrix_240 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {
                18, 21, 23, 26, 30}};

        int target = 5;
        System.out.println(searchMatrix(matrix, target));


    }

    // 选左上角，往右走和往下走都增大，不能选
    // 选右下角，往上走和往左走都减小，不能选
    // 选左下角，往右走增大，往上走减小，可选
    // 选右上角，往下走增大，往左走减小，可选
    // 思路：从左下角找起，如果小则找上一行，如果大则找右边那列
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 7 ms	44.3 MB
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

    public boolean searchMatrix2(int[][] matrix, int target) {
        // 6 ms 44.1 MB
        //从矩阵右上角开始搜索
        int col = matrix[0].length - 1;//列
        int row = 0;//行

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                //如果找到就直接返回
                return true;
            } else if (target < matrix[row][col]) {
                //如果查找的值大了，下一步往左找
                col--;
            } else if (target > matrix[row][col]) {
                //如果查找的值小了，下一步往下找
                row++;
            }
        }
        return false;
    }
}
