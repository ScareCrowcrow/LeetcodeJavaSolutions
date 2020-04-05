package InterviewQuestions;

// 单调递增栈，后序遍历反过来就是 root->right->left, 即翻转后的先序遍历

import java.util.Deque;
import java.util.LinkedList;

public class p33_medium {
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int preElem = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--){
            if (postorder[i] > preElem) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                preElem = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
