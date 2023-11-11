package work.icql.icm.product.b.server.doc.code.algorithm.排序.isnotN;

/**
 * 快速排序：
 * 1）不稳定排序
 * 2）算法思想
 * 分治思想，取任意点作为分区点，将小于分区点的数据放在分区点左边，将大于分区点的数据放在分区点右边
 * 再分别对分区点两侧的数据做同样的操作，依次类推
 * 3）平均时间复杂度：O(nlogn)，平均空间复杂度：O(1)
 */
public class QuickSort {

    private QuickSort() {
    }

    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        //分区点，分区方法里 小于分区点-分区点-大于分区点
        int pivot = partition(data, left, right);
        sort(data, left, pivot - 1);
        sort(data, pivot + 1, right);
    }

    /**
     * 原地分区方法
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] data, int left, int right) {
        //选取分区点，右边界
        int pivotValue = data[right];
        //比较区边界点（类似选择排序，左边小于，右边含边界点大于等于）
        int comparedBoarderIndex = left;
        int comparedBoarderValue = data[comparedBoarderIndex];
        //遍历一遍
        for (int cursor = left; cursor <= right; cursor++) {
            int current = data[cursor];
            //当游标值小于分区点值时，交换边界点和游标值
            if (current < pivotValue) {
                data[cursor] = comparedBoarderValue;
                data[comparedBoarderIndex] = current;
                comparedBoarderIndex++;
                comparedBoarderValue = data[comparedBoarderIndex];
            }
        }
        //交换分区点和比较区边界点
        data[right] = comparedBoarderValue;
        data[comparedBoarderIndex] = pivotValue;
        return comparedBoarderIndex;
    }

    /**
     * 非原地分区方法
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private static int partitionWithExtraSpace(int[] data, int left, int right) {
        int startIndex = left;
        int size = right - left;
        int[] greater = new int[size];
        int greaterSize = 0;
        int[] less = new int[size];
        int lessSize = 0;
        int[] equals = new int[size];
        int equalsSize = 0;

        int pivotIndex = left;
        int pivot = data[pivotIndex];
        while (left < pivotIndex) {
            int value = data[left];
            if (value == pivot) {
                equals[equalsSize++] = value;
            } else if (value > pivot) {
                greater[greaterSize++] = value;
            } else {
                less[lessSize++] = value;
            }
            left++;
        }
        while (right > pivotIndex) {
            int value = data[right];
            if (value == pivot) {
                equals[equalsSize++] = value;
            } else if (value > pivot) {
                greater[greaterSize++] = value;
            } else {
                less[lessSize++] = value;
            }
            right--;
        }
        for (int i = 0; i < lessSize; i++) {
            data[startIndex++] = less[i];
        }
        int returnPivotIndex = startIndex++;
        data[returnPivotIndex] = pivot;
        for (int i = 0; i < equalsSize; i++) {
            data[startIndex++] = equals[i];
        }
        for (int i = 0; i < greaterSize; i++) {
            data[startIndex++] = greater[i];
        }
        return returnPivotIndex;
    }

}
