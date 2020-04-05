package InterviewQuestions;

import java.util.Arrays;

public class p11_simple {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        int start = 0;
        int end = numbers.length - 1;
        Arrays.sort(numbers);
        if (numbers[end] > numbers[0]) {
            return numbers[0];
        }
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (numbers[mid] > numbers[mid + 1]) return numbers[mid+1];
            if (numbers[mid - 1] > numbers[mid]) return numbers[mid];
            if (numbers[mid] > numbers[0]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if (numbers[start] >= numbers[0] && numbers[start] <= numbers[numbers.length-1]) return numbers[start];
        if (numbers[end] >= numbers[0] && numbers[end] <= numbers[numbers.length-1]) return numbers[end];
        return -1;
    }
}
