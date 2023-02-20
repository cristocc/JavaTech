package techArticle.algorithm.leetcode.tree;

/**
 * Created by crist on 2021/4/27
 *
 * @author cc
 */
public class LeetCode684_findRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            int find1 = find(parent, node1);
            int find2 = find(parent, node2);
            if (find1 != find2) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        LeetCode684_findRedundantConnection test = new LeetCode684_findRedundantConnection();
        int[][] edges = {{1,2},{1,3},{2,3}};
        test.findRedundantConnection(edges);
    }
}
