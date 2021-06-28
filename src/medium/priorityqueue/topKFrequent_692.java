package medium.priorityqueue;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 *k* 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出**现频率由高到低排序**。如果不同的单词有相同出现频率，**按字母顺序排序**。
 *
 * @author ChenZT
 */
public class topKFrequent_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // 统计个数
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 第一位放置次数，第二位放置单词
        PriorityQueue<Object[]> q = new PriorityQueue<>(k, (a, b) -> {
            // 如果词频不同，根据词频升序
            int c1 = (Integer) a[0], c2 = (Integer) b[0];
            if (c1 != c2) return c1 - c2;
            // 如果词频相同，根据字典序倒序
            String s1 = (String) a[1], s2 = (String) b[1];
            return s2.compareTo(s1);
        });

        for (String s : map.keySet()) {
            int count = map.get(s);
            if (q.size() < k) {
                q.add(new Object[]{count, s});
            } else {
                Object[] peek = q.peek();
                if (count > (Integer) peek[0]) {
                    q.poll();
                    q.add(new Object[]{count, s});
                } else if (count == (Integer) peek[0]) {
                    String top = (String) peek[1];
                    if (s.compareTo(top) < 0) {
                        q.poll();
                        q.add(new Object[]{count, s});
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add((String) q.poll()[1]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
