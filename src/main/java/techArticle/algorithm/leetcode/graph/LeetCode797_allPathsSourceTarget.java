package techArticle.algorithm.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by crist on 2021/3/26
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * @author cc
 */
public class LeetCode797_allPathsSourceTarget {

    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 添加节点 s 到路径
        path.addLast(s);
        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }
        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        // 从路径移出节点 s
        path.removeLast();
    }

    //graph = [[1,2],[3],[3],[]]
    public static void main(String[] args) {
        int [][] graph = {{1,2},{3},{3},{}};
        LeetCode797_allPathsSourceTarget t = new LeetCode797_allPathsSourceTarget();
        t.allPathsSourceTarget(graph);
        System.out.println(t.res);
    }

}