package medium.priorityqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author ChenZT
 */
public class topKFrequent_347 {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }


    public static int[] topKFrequent(int[] nums, int k) {
        // 15 ms 40.6 MB
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 错误的地方在于，我里面存放的是数字，但是用于比较的是出现的次数
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (int[] m, int[] n) -> m[1] - n[1]);
        for (int num : count.keySet()) {
            int cnt = count.get(num);
            if (queue.size() < k) {
                // 如果队列没满，直接存放
                queue.offer(new int[]{num, cnt});
            } else {
                // 满了，则比较堆顶的大小
                if (cnt > queue.peek()[1]) {
                    // 次数比堆顶的多，先删除堆顶元素，再入堆
                    queue.poll();
                    queue.offer(new int[]{num, cnt});
                }
            }

        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
