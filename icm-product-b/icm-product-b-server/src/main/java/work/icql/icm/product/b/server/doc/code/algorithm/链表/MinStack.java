package work.icql.icm.product.b.server.doc.code.algorithm.链表;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;

    private Integer min;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min == null || x < min) {
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(min)) {
            min = null;
            if (stack.size() == 0) {
                return;
            }
            for (int i = 0; i < stack.size(); i++) {
                Integer integer = stack.get(i);
                if (min == null || integer < min) {
                    min = integer;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
//        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        stack.top();
        stack.pop();
        stack.getMin();
        stack.pop();
    }
}
