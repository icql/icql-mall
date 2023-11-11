package work.icql.icm.product.b.server.doc.code.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 稀疏图
 * 邻接表实现
 */
public class SparseGraph {

    /**
     * 顶点数
     */
    private int vertexNum;

    /**
     * 边数
     */
    private int edgeNum;

    /**
     * 是否为有向图
     */
    private boolean isDirected;

    /**
     * 图的具体数据
     */
    private LinkedList<Integer>[] data;

    public SparseGraph(int vertexNum, boolean directed) {
        assert vertexNum >= 0;
        this.vertexNum = vertexNum;
        //初始化没有任何边
        this.edgeNum = 0;
        this.isDirected = directed;
        //data 初始化为 vertexNum 个空的 ArrayList
        //表示每一个data[i]都为空, 即没有任和边
        data = new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /**
     * 返回结点个数
     *
     * @return
     */
    public int V() {
        return vertexNum;
    }

    /**
     * 返回边的个数
     *
     * @return
     */
    public int E() {
        return edgeNum;
    }

    /**
     * 向图中添加一个边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        assert i >= 0 && i < vertexNum;
        assert j >= 0 && j < vertexNum;
        data[i].add(j);
        if (i != j && !isDirected) {
            data[j].add(i);
        }
        edgeNum++;
    }

    /**
     * i到j是否有边
     *
     * @param i
     * @param j
     * @return
     */
    boolean hasEdge(int i, int j) {
        assert i >= 0 && i < vertexNum;
        assert j >= 0 && j < vertexNum;
        for (int k = 0; k < data[k].size(); k++) {
            if (data[k].get(k) == j) {
                return true;
            }
        }
        return false;
    }

    /**
     * 广度优先遍历
     *
     * @param start
     * @param end
     */
    public void bfs(int start, int end) {
        if (start == end) {
            return;
        }
        //记录已经访问过的顶点
        boolean[] visited = new boolean[vertexNum];
        visited[start] = true;
        //用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        //用来记录搜索路径
        int[] prev = new int[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int curVertex = queue.poll();
            //访问顶点相连的顶点
            for (int i = 0; i < data[curVertex].size(); ++i) {
                int linkedVertex = data[curVertex].get(i);
                if (!visited[linkedVertex]) {
                    prev[linkedVertex] = curVertex;
                    if (linkedVertex == end) {
                        print(prev, start, end);
                        return;
                    }
                    visited[linkedVertex] = true;
                    queue.add(linkedVertex);
                }
            }
        }
    }

    /**
     * 递归打印 s->t 的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[vertexNum];
        int[] prev = new int[vertexNum];
        for (int i = 0; i < vertexNum; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    boolean found = false;

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < data[w].size(); ++i) {
            int q = data[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    public static void main(String[] args) {
        SparseGraph graph = new SparseGraph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        graph.bfs(0, 4);
        graph.dfs(0, 4);
    }
}
