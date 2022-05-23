package leetcode101_200;

import java.util.Stack;

public class L155_MinStack_easy {
    // https://leetcode.cn/problems/min-stack/
    class MinStack {

        /** initialize your data structure here. */
        // 需要2个栈，一个为数据栈，一个为保存最小数的栈
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int val) {
            if(this.stackMin.isEmpty()) {
                this.stackMin.push(val);
            } else if(val <= this.getMin()) {
                this.stackMin.push(val);
            }
            this.stackData.push(val);
        }

        public void pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
        }

        public int top() {
            return this.stackData.peek();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
}
