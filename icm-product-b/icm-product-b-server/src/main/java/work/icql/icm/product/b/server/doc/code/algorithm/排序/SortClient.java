package work.icql.icm.product.b.server.doc.code.algorithm.排序;

import java.util.Arrays;

public class SortClient {

    public static void main(String[] args) throws Exception {

//        int dataCount = 100000;
//        int[] data = new int[dataCount];
//        Random random = new Random();
//        for (int i = 0; i < dataCount; i++) {
//            data[i] = random.nextInt(dataCount);
//        }

//        int[] data = new int[]{3, 2, 4, 5, 1};
        int[] data = new int[]{6, 4, 7, 1, 9, 0, 2};
        long start = System.currentTimeMillis();

        //冒泡排序第一版
        //BubbleSort.sort1(data);

        //冒泡排序第二版
        //BubbleSort.sort2(data);

        //冒泡排序第三版
        //BubbleSort.sort3(data);

        //插入排序第一版
        //InsertionSort.sort1(data);

        //插入排序第二版
        //InsertionSort.sort2(data);

        //选择排序
        //SelectionSort.sort(data);

        //归并排序
        //MergeSort.sort(data);

        //快速排序
        //QuickSort.sort(data);

        sort3(data, 0, data.length - 1);


        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(data) + "" + (end - start) + "ms");
    }

    public static void sort1(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                int a = data[j];
                int b = data[j + 1];
                if (a > b) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }

    public static void sort2(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort2(data, left, mid);
        sort2(data, mid + 1, right);
        merge(data, left, right, mid);
    }

    private static void merge(int[] data, int left, int right, int mid) {
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

    public static void sort3(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(data, left, right);
        sort3(data, left, partition - 1);
        sort3(data, partition + 1, right);
    }

    private static int partition(int[] data, int left, int right) {
        //选取分区点，右边界
        int pivotIndex = right;
        int pivotValue = data[pivotIndex];
        int boarderIndex = left;
        int borderValue = data[boarderIndex];
        //遍历一遍
        for (int i = left; i <= right; i++) {
            int current = data[i];
            //当游标值小于分区点值时，交换边界点和游标值
            if (current < pivotValue) {
                data[i] = borderValue;
                data[boarderIndex] = current;
                //更新边界点和边界索引
                boarderIndex++;
                borderValue = data[boarderIndex];
            }
        }
        data[right] = borderValue;
        data[boarderIndex] = pivotValue;
        pivotIndex = boarderIndex;
        return pivotIndex;
    }
}
