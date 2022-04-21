package others;

public class Problem16_16 {
    public int[] subSort(int[] array) {
        if (array == null || array.length < 2) {
            return new int[]{-1, -1};
        }
        int N = array.length;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (max > array[i]) {
                right = i;
            }
            max = Math.max(max, array[i]);
        }
        int min = Integer.MAX_VALUE;
        int left = N;
        for (int i = N - 1; i >= 0; i--) {
            if (min < array[i]) {
                left = i;
            }
            min = Math.min(min, array[i]);
        }
        if(left >= right){
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }
}
