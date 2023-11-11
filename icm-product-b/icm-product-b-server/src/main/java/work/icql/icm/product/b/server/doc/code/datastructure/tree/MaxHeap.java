package work.icql.icm.product.b.server.doc.code.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    //堆化，将数组堆化，O(n)，一个一个add，O(nlogn)
    public MaxHeap(int[] arr) {
        data = new ArrayList<>();
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    //向堆中添加元素
    //添加到数组尾部，上浮堆尾
    public void add(int e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k) {
        int parent = parent(k);
        while (k > 0 && data.get(parent) < data.get(k)) {
            swap(k, parent);
            k = parent;
        }
    }

    //看堆中的最大元素
    public int findMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException();
        }
        return data.get(0);
    }

    //取出堆中最大元素
    //交换堆顶和尾部，删除堆尾，下沉堆顶
    public int removeMax() {
        int ret = findMax();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            //在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j + 1 < data.size() &&
                    data.get(j + 1) > data.get(j)) {
                j++;
            }
            //data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k) >= data.get(j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int aVal = data.get(a);
        int bVal = data.get(b);
        data.set(a, bVal);
        data.set(b, aVal);
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException();
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
