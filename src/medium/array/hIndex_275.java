package medium.array;

/**
 * @author ChenZT
 */
public class hIndex_275 {
    public static void main(String[] args) {
        int[] num = {0, 1, 3, 5, 6};
        System.out.println(hIndex(num));
    }

    public static int hIndex(int[] citations) {
        // 遍历
        int length = citations.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int temp = citations[i]; // 每篇论文的引用次数
            // 如果剩下的长度大于temp，说明H指数至少是temp
            if (temp <= length - i) ans = temp;
        }
        return ans;
    }
}
