package medium.hashmap;

import java.util.*;

/**
 * @author ChenZT
 */
public class displayTable_1418 {
    public static void main(String[] args) {
        Set<String> test = new HashSet<>();
        List<List<String>> orders = new ArrayList<>();
        //[["David","3","Ceviche"],
        List<String> list1 = new ArrayList<>();
        list1.add("David");
        list1.add("3");
        list1.add("Ceviche");
        orders.add(list1);
        // ["Corina","10","Beef Burrito"],
        List<String> list2 = new ArrayList<>();
        list2.add("Corina");
        list2.add("10");
        list2.add("Beef Burrito");
        orders.add(list2);
        // ["David","3","Fried Chicken"],
        List<String> list3 = new ArrayList<>();
        list3.add("David");
        list3.add("3");
        list3.add("Fried Chicken");
        orders.add(list3);
        // ["Carla","5","Water"],
        List<String> list4 = new ArrayList<>();
        list4.add("Carla");
        list4.add("5");
        list4.add("Water");
        orders.add(list4);
        // ["Carla","5","Ceviche"],
        List<String> list5 = new ArrayList<>();
        list5.add("Carla");
        list5.add("5");
        list5.add("Ceviche");
        orders.add(list5);
        // ["Rous","3","Ceviche"]]
        List<String> list6 = new ArrayList<>();
        list6.add("Rous");
        list6.add("3");
        list6.add("Ceviche");
        orders.add(list6);
        List<List<String>> list = displayTable(orders);
    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        // 38 ms 63.1 MB
        Set<String> nameSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2)); // 添加食物名
            int id = Integer.parseInt(order.get(1)); // 获取桌号
            // 获取每桌食物的点餐次数
            Map<String, Integer> foodMap = foodsCnt.getOrDefault(id, new HashMap<String, Integer>());
            // 点餐次数+1
            foodMap.put(order.get(2), foodMap.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, foodMap);
        }
        // 餐品名称排个序
        List<String> nameList = new ArrayList<String>(nameSet);
        Collections.sort(nameList);

        // 桌号排个序
        List<Integer> tableId = new ArrayList<Integer>(foodsCnt.keySet());
        Collections.sort(tableId);

        // 填写返回值：点菜展示表
        List<List<String>> result = new ArrayList<>();

        // 打印第一行
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(nameList);
        result.add(header);

        // 打印食物次数
        for (int i = 0; i < foodsCnt.size(); i++) {
            List<String> row = new ArrayList<String>();
            int id = tableId.get(i);
            Map<String, Integer> map = foodsCnt.get(id);
            row.add(Integer.toString(id));
            for (String s : nameList) {
                row.add(Integer.toString(map.getOrDefault(s, 0)));
            }
            result.add(row);
        }
        return result;
    }
}
