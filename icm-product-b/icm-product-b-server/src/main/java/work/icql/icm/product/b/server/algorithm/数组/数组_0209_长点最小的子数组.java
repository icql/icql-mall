package work.icql.icm.product.b.server.algorithm.数组;

public class 数组_0209_长点最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        if (target < 0 || nums.length == 0) {
            return min;
        }
        int sum = 0;
        int start = 0;
        int end = 0;

        boolean needSum = true;
        while (end < nums.length) {
            int v = nums[end];
            if (needSum) {
                sum += v;
                needSum = false;
            }
            if (sum >= target) {
                int len = end - start + 1;
                min = min == 0 ? len : Math.min(min, len);
                sum -= nums[start];
                start++;
                if (start > end) {
                    end++;
                    needSum = true;
                }
            } else {
                end++;
                needSum = true;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        //示例 2：
        //
        //输入：target = 4, nums = [1,4,4]
        //输出：1
        //示例 3：
        //
        //输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        //输出：0

        数组_0209_长点最小的子数组 o = new 数组_0209_长点最小的子数组();

        //int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        //int out = o.minSubArrayLen(7, nums);

        int[] nums = new int[]{1, 4, 4};
        int out = o.minSubArrayLen(4, nums);

        //int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        //int out = o.minSubArrayLen(7, nums);


        System.out.println(out);
    }
}
