package work.icql.icm.product.b.server.algorithm.排序.isnotN;

import java.util.Arrays;

/**
 * 归并排序：
 * 1）稳定排序
 * 2）算法思想
 * 分治思想，要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了
 * 3）平均时间复杂度：O(nlogn)，平均空间复杂度：O(n)
 */
public class MergeSort {

    private MergeSort() {
    }

    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int left, int right) {
        //不再继续分解
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //左
        sort(data, left, mid);
        //右
        sort(data, mid + 1, right);
        //合并
        merge(data, left, right, mid);
    }

    private static void merge(int[] data, int left, int right, int mid) {
        //临时数组，用来保存当前用以归并的数据
        int[] arr = Arrays.copyOfRange(data, left, right + 1);
        int leftIndex = 0;
        int leftIndexEnd = mid - left;
        int rightIndex = leftIndexEnd + 1;
        int rightIndexEnd = arr.length - 1;
        //遍历重新设置 原数组 [left,right] 的值使之有序
        for (int k = left; k <= right; k++) {
            //左边元素已经处理完
            if (leftIndex > leftIndexEnd) {
                data[k] = arr[rightIndex];
                rightIndex++;
                continue;
            }
            //右边元素已经处理完
            if (rightIndex > rightIndexEnd) {
                data[k] = arr[leftIndex];
                leftIndex++;
                continue;
            }
            //如果左边所指元素 <= 右边所指元素
            if (arr[leftIndex] <= arr[rightIndex]) {
                data[k] = arr[leftIndex];
                leftIndex++;
                continue;
            }
            //如果左边所指元素 > 右边所指元素
            data[k] = arr[rightIndex];
            rightIndex++;
        }
    }
}
