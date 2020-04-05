package InterviewQuestions;

public class p17_01_simple {
    public int add(int a, int b) {
        return (a^b) + ((a&b) << 1);
    }
}
