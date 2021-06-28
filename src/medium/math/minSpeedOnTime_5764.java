package medium.math;

/**
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。
 * 要到达办公室，你必须按给定次序乘坐 n 趟列车。
 * 另给你一个长度为 n 的整数数组 dist,其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速
 *
 * @author ChenZT
 */
public class minSpeedOnTime_5764 {
    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 6;
        System.out.println(minSpeedOnTime(dist, hour));
    }

    // 用二分法找出速度
    public static int minSpeedOnTime(int[] dist, double hour) {
        // 223 ms 52.8 MB
        if (hour < dist.length - 1) return -1;
        int l = 1;
        int r = 10000000;

        while (l < r) {
            double time = 0;
            int mid = (l + r - 1) / 2; // 时速
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    time += dist[i] * 1.0 / mid;
                } else {
                    time += Math.ceil(dist[i] * 1.0 / mid);
                }
            }
            if (time <= hour) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int minSpeedOnTime2(int[] dist, double hour) {
        // 超时了
        if (hour < dist.length - 1) return -1;
        int result = 1;

        while (true) {
            double time = 0;
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    time += dist[i] * 1.0 / result;
                } else {
                    time += Math.ceil(dist[i] * 1.0 / result);
                }

            }
            if (time <= hour) break;
            result++;
        }
        return result;
    }
}
