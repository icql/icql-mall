package work.icql.icm.product.b.server.algorithm.搜索;

/**
 * @author icql
 * @version 1.0
 * @date 2019/1/21 9:18
 * @intitle 有序表查找算法
 * @Description OrderedSearch
 */
public class OrderedSearch {

    /**
     * 二分查找
     *
     * @param arr
     * @param num
     * @return
     */
    public static int binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] > num) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }


    /**
     * 插值查找
     * 在二分查找的基础上，改进mid计算公式
     * 二分查找  mid = (high + low) / 2 = low + 1/2 *(high - low);
     * 改进 1/2 系数 为 (key - datastructureold[low]) / (datastructureold[high] - datastructureold[low])
     **/
    public static int InsertValueSearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = Math.round(low + ((num - arr[low]) / (arr[high] - arr[low])) * (high - low));
            if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] > num) {
                high = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

    //斐波那契查找
}
