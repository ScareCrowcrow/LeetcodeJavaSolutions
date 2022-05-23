package leetcode701_800;

import java.util.ArrayList;
import java.util.List;

public class L733_FloodFill_easy {
    // https://leetcode.cn/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        List<String> visited = new ArrayList<>();
        dfs(image, sr, sc, newColor, original, visited);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int original, List<String> visited) {
        if (visited.contains(sr + "+" + sc)) return;
        visited.add(sr + "+" + sc);
        //超出数组范围
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (original == image[sr][sc]) {
            image[sr][sc] = newColor;

            dfs(image, sr - 1, sc, newColor, original, visited);
            dfs(image, sr + 1, sc, newColor, original, visited);
            dfs(image, sr, sc - 1, newColor, original, visited);
            dfs(image, sr, sc + 1, newColor, original, visited);
        }
    }
}
