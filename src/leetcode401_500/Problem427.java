package leetcode401_500;

public class Problem427 {
    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    // 提交以下
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    public Node construct(int[][] grid, int startRow, int startColumn, int number) {
        if (isAllOneOrZero(grid, startRow, startColumn, number)) {
            return new Node(grid[startRow][startColumn] == 1, true);
        }

        int middle = number / 2;

        Node left = construct(grid, startRow, startColumn, middle);
        Node right = construct(grid, startRow, startColumn + middle, middle);
        Node bottomLeft = construct(grid, startRow + middle, startColumn, middle);
        Node bottomRight = construct(grid, startRow + middle, startColumn + middle, middle);

        return new Node(true, false, left, right, bottomLeft, bottomRight);
    }

    private boolean isAllOneOrZero(int[][] grid, int startRow, int startColumn, int number) {
        int first = grid[startRow][startColumn];
        for (int row = startRow; row < startRow + number; row++) {
            for (int column = startColumn; column < startColumn + number; column++) {
                if (grid[row][column] != first) {
                    return false;
                }
            }
        }

        return true;
    }
}

