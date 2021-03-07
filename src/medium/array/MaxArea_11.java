package medium.array;

/**
 * @author ChenZT
 */
public class MaxArea_11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        // 超时：时间复杂度O(n^2)
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * (Math.min(height[i], height[j]));
                area = Math.max(area, tempArea);
            }
        }
        return area;
    }

    // 双指针思想：
    // https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
    public int maxArea2(int[] height) {
        // 	5 ms	52.3 MB
        int area = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int tempArea = (j - i) * (Math.min(height[i], height[j]));
            area = Math.max(area, tempArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }

}
