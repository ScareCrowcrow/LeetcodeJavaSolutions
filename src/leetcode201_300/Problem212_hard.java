package leetcode201_300;

/*
运用了前缀树和图的深度优先遍历算法
*/

import java.util.ArrayList;
import java.util.List;

public class Problem212_hard {
    // https://leetcode-cn.com/problems/word-search-ii/
    public static class TrieNode {
        public TrieNode[] children;
        public String word; //节点直接存当前的单词

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static class Trie {
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] array = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                // 当前孩子是否存在
                if (cur.children[array[i] - 'a'] == null) {
                    cur.children[array[i] - 'a'] = new TrieNode();
                }
                cur = cur.children[array[i] - 'a'];
            }
            // 当前节点结束，存入当前单词
            cur.word = word;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        //将所有单词存入前缀树中
        List<String> res = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }
        int rows = board.length;
        if (rows == 0) {
            return res;
        }
        int cols = board[0].length;
        //从每个位置开始遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                existRecursive(board, i, j, trie.root, res);
            }
        }
        return res;
    }

    private void existRecursive(char[][] board, int row, int col, TrieNode node, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char cur = board[row][col];//将要遍历的字母
        //当前节点遍历过或者将要遍历的字母在前缀树中不存在
        if (cur == '$' || node.children[cur - 'a'] == null) {
            return;
        }
        node = node.children[cur - 'a'];
        //判断当前节点是否是一个单词的结束
        if (node.word != null) {
            //加入到结果中
            res.add(node.word);
            //将当前单词置为 null，防止重复加入
            node.word = null;
        }
        char temp = board[row][col];
        //上下左右去遍历
        board[row][col] = '$';
        existRecursive(board, row - 1, col, node, res);
        existRecursive(board, row + 1, col, node, res);
        existRecursive(board, row, col - 1, node, res);
        existRecursive(board, row, col + 1, node, res);
        board[row][col] = temp;
    }
}