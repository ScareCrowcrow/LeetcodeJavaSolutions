package InterviewQuestions;

/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
*
* a+b <==> (a^b)+((a&b)<<1)
* */

public class p65_simple {
    public int add(int a, int b) {
        return (a^b) + ((a&b) << 1);
    }
}
