package easy.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 主要考查树的深度遍历：递归和迭代两种方法。
 *
 * @author ChenZT
 */
public class leafSimilar_872 {
    public static void main(String[] args) {

    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 深度遍历两棵树，把叶子结点的值保存到l1、l2两个list中
        dfs(root1, l1);
        dfs(root2, l2);
        // 比较两个list的值顺序是否一致
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    //方法一：递归
    static void dfs(TreeNode root, List<Integer> list) {
        // 0 ms	36.2 MB
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static boolean leafSimilar2(TreeNode t1, TreeNode t2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        process(t1, l1);
        process(t2, l2);
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    // 方法二：迭代
    // 迭代其实就是使用「栈」来模拟递归过程，也属于树的遍历中的常见实现形式。
    static void process(TreeNode root, List<Integer> list) {
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            // 左右子结点为空，到达叶子结点，添加入数组中。
            if (root.left == null && root.right == null) list.add(root.val);
            root = root.right;
        }
    }
}
