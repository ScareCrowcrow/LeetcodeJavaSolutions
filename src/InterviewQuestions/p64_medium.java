package InterviewQuestions;

// TAG: 递归

public class p64_medium {
    public int sumNums(int n) {
        if(n == 1) return 1;
        return n + sumNums(n - 1);
    }
}
