package work.icql.icm.product.b.server.doc.code.algorithm.排序.isnotN;

/**
 * 插入排序：
 * 1）稳定排序
 * 2）算法思想
 * 数据分为两个区间，已排序区间和未排序区间
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序
 * 重复这个过程，直到未排序区间中元素为空
 * 3）平均时间复杂度：O(n^2)，平均空间复杂度：O(1)
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static void sort1(int[] data) {
        int count = data.length;
        for (int i = 1; i < count; i++) {
            //已排序区间的最后一个元素
            int orderedIndex = i - 1;
            int current = data[i];
            while (orderedIndex >= 0 && current < data[orderedIndex]) {
                data[orderedIndex + 1] = data[orderedIndex];
                orderedIndex--;
            }
            data[orderedIndex + 1] = current;
        }
    }

    public static void sort2(int[] data) {
        int count = data.length;
        for (int i = 1; i < count; i++) {
            //已排序区间的最后一个元素
            int orderedIndex = i - 1;
            int current = data[i];
            for (; orderedIndex >= 0; orderedIndex--) {
                int prev = data[orderedIndex];
                if (current < prev) {
                    data[orderedIndex + 1] = prev;
                } else {
                    break;
                }
            }
            data[orderedIndex + 1] = current;
        }
    }
}
