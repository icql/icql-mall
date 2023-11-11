package work.icql.icm.product.b.server.doc.code.algorithm.排序.isnotN;

/**
 * 选择排序：
 * 1）不稳定排序
 * 2）算法思想
 * 实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序
 * 每次会从未排序区间中找到最小的元素，将其与已排序区间的末尾元素进行交换
 * 3）平均时间复杂度：O(n^2)，平均空间复杂度：O(1)
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(int[] data) {
        int count = data.length;
        for (int i = 0; i < count - 1; i++) {
            // 寻找[i, 数组末尾)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
}
