package work.icql.icm.product.b.server.doc.code.algorithm.链表;

import java.util.Stack;

public class 链表_0155_最小栈 {

    /**
     * 辅助栈的作用：每次push都在辅助栈push一个当前栈中的最小值
     */
    static class MinStack1 {

        private Stack<Integer> stack;

        private Stack<Integer> minStack;

        public MinStack1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if (stack.size() == 0) {
                stack.push(val);
                minStack.push(val);
            } else {
                Integer min = minStack.peek();
                if (val < min) {
                    minStack.push(val);
                } else {
                    minStack.push(min);
                }
                stack.push(val);
            }
        }

        public void pop() {
            if (stack.size() == 0) {
                return;
            }
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    static class MinStack2 {

        private Stack<Integer> stack;

        private int min;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
            } else {
                int diff = val - min;
                stack.push(diff);
                if (val < min) {
                    min = val;
                }
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();
            if (stack.isEmpty()) {
                return;
            }
            int top = top();
            if (top < min) {
                min = top;
            }
        }

        public int top() {
            Integer diff = stack.peek();
            return diff + min;
        }

        public int getMin() {
            return min;
        }
    }


    public static void main(String[] args) {
        work.icql.java.algorithm.链表.MinStack minStack = new work.icql.java.algorithm.链表.MinStack();
        System.out.println();
    }
}
