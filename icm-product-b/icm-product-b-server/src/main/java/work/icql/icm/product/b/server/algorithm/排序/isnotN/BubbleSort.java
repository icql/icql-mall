package work.icql.icm.product.b.server.algorithm.排序.isnotN;

/**
 * 冒泡排序：
 * 1）稳定排序
 * 2）算法思想
 * 只会操作相邻两个数据，每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换
 * 每一遍都会将当前未排序中最大的数排在最后面
 * 3）平均时间复杂度：O(n^2)，平均空间复杂度：O(1)
 */
public class BubbleSort {

    private BubbleSort() {
    }

    /**
     * 第一版
     *
     * @param data
     */
    public static void sort1(int[] data) {
        //循环次数
        //第一层循环，最大趟数 = length - 1
        //第二层循环，最大交换次数 = length - 1 - 外层循环计数器，因为数组末尾的有序区长度就是外层循环计数器的值
        int count = data.length - 1;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                //相邻位置 比较 交换
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 第二版：内层循环没有交换元素，则说明已经全部有序，所以直接返回
     *
     * @param data
     */
    public static void sort2(int[] data) {

        int count = data.length - 1;
        for (int i = 0; i < count; i++) {
            boolean isSorted = true;
            for (int j = 0; j < count - i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    isSorted = false;
                }
            }

            if (isSorted) {
                return;
            }
        }
    }

    /**
     * 第三版：优化数组末尾的有序边界，有序边界应该为内层循环最后一次改变位置的地方
     *
     * @param data
     */
    public static void sort3(int[] data) {

        int count = data.length - 1;
        int sortBorder = count;
        int lastExchangeIndex = 0;

        for (int i = 0; i < count; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }

            sortBorder = lastExchangeIndex;
            if (isSorted) {
                return;
            }
        }
    }

}
