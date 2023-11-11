package work.icql.icm.product.b.server.doc.code.datastructure.graph;

/**
 * 稠密图
 * 邻接矩阵实现
 */
public class DenseGraph {

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
    private boolean[][] data;

    /**
     * 构造函数
     *
     * @param vertexNum
     * @param isDirected
     */
    public DenseGraph(int vertexNum, boolean isDirected) {
        assert vertexNum >= 0;
        this.vertexNum = vertexNum;
        //初始化没有任何边
        this.edgeNum = 0;
        this.isDirected = isDirected;
        //data 初始化为 vertexNum*vertexNum 的布尔矩阵
        //每一个data[i][j]均为false, 表示没有任何边
        data = new boolean[vertexNum][vertexNum];
    }

    /**
     * 返回顶点个数
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
        if (hasEdge(i, j)) {
            return;
        }
        data[i][j] = true;
        if (!isDirected) {
            data[j][i] = true;
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
    public boolean hasEdge(int i, int j) {
        assert i >= 0 && i < vertexNum;
        assert j >= 0 && j < vertexNum;
        return data[i][j];
    }
}
