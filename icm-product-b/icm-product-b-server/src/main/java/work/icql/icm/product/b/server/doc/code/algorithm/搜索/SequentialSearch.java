package work.icql.icm.product.b.server.doc.code.algorithm.搜索;

/**
 * @author icql
 * @version 1.0
 * @date 2019/1/12 16:32
 * @Title 顺序表查找算法
 * @Description SequentialSearch
 */
public class SequentialSearch {
    public static Object search(Object[] array, Object obj) {
        for (Object item : array) {
            if (item.equals(obj)) {
                return obj;
            }
        }
        return null;
    }
}
