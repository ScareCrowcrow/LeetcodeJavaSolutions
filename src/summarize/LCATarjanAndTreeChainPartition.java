package summarize;

import java.util.HashSet;

public class LCATarjanAndTreeChainPartition {
    // 给定数组tree大小为N，表示一共有N个节点
    // tree[i] = j 表示点i的父亲是点j，tree一定是一棵树而不是森林
    // queries是二维数组，大小为M*2，每一个长度为2的数组都表示一条查询
    // [4,9], 表示想查询4和9之间的最低公共祖先
    // [3,7], 表示想查询3和7之间的最低公共祖先
    // tree和queries里面的所有值，都一定在0~N-1之间
    // 返回一个数组ans，大小为M，ans[i]表示第i条查询的答案

    // 暴力方法
    public static int[] query1(int[] father, int[][] queries) {
        int M = queries.length;
        int[] ans = new int[M];
        HashSet<Integer> path = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int jump = queries[i][0];
            while (father[jump] != jump) {
                path.add(jump);
                jump = father[jump];
            }
            path.add(jump);
            jump = queries[i][1];
            while (!path.contains(jump)) {
                jump = father[jump];
            }
            ans[i] = jump;
            path.clear();
        }
        return ans;
    }

    // 离线批量查询最优解 -> Tarjan + 并查集
    // 如果有M条查询，时间复杂度O(N + M)
    // 但是必须把M条查询一次给全，不支持在线查询
    public static int[] query2(int[] father, int[][] queries) {
        int N = father.length;
        int M = queries.length;
        int[] help = new int[N];
        int h = 0;
        for (int i = 0; i < N; i++) {
            if (father[i] == i) {
                h = i;
            } else {
                help[father[i]]++;
            }
        }
        int[][] mt = new int[N][];
        for (int i = 0; i < N; i++) {
            mt[i] = new int[help[i]];
        }
        for (int i = 0; i < N; i++) {
            if (i != h) {
                mt[father[i]][--help[father[i]]] = i;
            }
        }
        for (int i = 0; i < M; i++) {
            if (queries[i][0] != queries[i][1]) {
                help[queries[i][0]]++;
                help[queries[i][1]]++;
            }
        }
        int[][] mq = new int[N][];
        int[][] mi = new int[N][];
        for (int i = 0; i < N; i++) {
            mq[i] = new int[help[i]];
            mi[i] = new int[help[i]];
        }
        for (int i = 0; i < M; i++) {
            if (queries[i][0] != queries[i][1]) {
                mq[queries[i][0]][--help[queries[i][0]]] = queries[i][1];
                mi[queries[i][0]][help[queries[i][0]]] = i;
                mq[queries[i][1]][--help[queries[i][1]]] = queries[i][0];
                mi[queries[i][1]][help[queries[i][1]]] = i;
            }
        }
        int[] ans = new int[M];
        UnionFind uf = new UnionFind(N);
        process(h, mt, mq, mi, uf, ans);
        for (int i = 0; i < M; i++) {
            if (queries[i][0] == queries[i][1]) {
                ans[i] = queries[i][0];
            }
        }
        return ans;
    }

    // 当前来到head点
    // mt是整棵树 head下方有哪些点 mt[head] = {a,b,c,d} head的孩子是abcd
    // mq问题列表 head有哪些问题 mq[head] = {x,y,z} (head，x) (head，y) (head z)
    // mi得到问题的答案，填在ans的什么地方 {6,12,34}
    // uf 并查集
    public static void process(int head, int[][] mt, int[][] mq, int[][] mi, UnionFind uf, int[] ans) {
        for (int next : mt[head]) { // head有哪些孩子，都遍历去吧！
            process(next, mt, mq, mi, uf, ans);
            uf.union(head, next);
            uf.setTag(head, head);
        }
        // 解决head的问题！
        int[] q = mq[head];
        int[] i = mi[head];
        for (int k = 0; k < q.length; k++) {
            // head和谁有问题 q[k] 答案填哪 i[k]
            int tag = uf.getTag(q[k]);
            if (tag != -1) {
                ans[i[k]] = tag;
            }
        }
    }

    public static class UnionFind {
        private int[] f; // father -> 并查集里面father信息，i -> i的father
        private int[] s; // size[] -> 集合 --> i size[i]
        private int[] t; // tag[] -> 集合 ---> tag[i] = ?
        private int[] h; // 栈？并查集搞扁平化

        public UnionFind(int N) {
            f = new int[N];
            s = new int[N];
            t = new int[N];
            h = new int[N];
            for (int i = 0; i < N; i++) {
                f[i] = i;
                s[i] = 1;
                t[i] = -1;
            }
        }

        private int find(int i) {
            int j = 0;
            // i -> j -> k -> s -> a -> a
            while (i != f[i]) {
                h[j++] = i;
                i = f[i];
            }
            // i -> a
            // j -> a
            // k -> a
            // s -> a
            while (j > 0) {
                h[--j] = i;
            }
            // a
            return i;
        }

        public void union(int i, int j) {
            int fi = find(i);
            int fj = find(j);
            if (fi != fj) {
                int si = s[fi];
                int sj = s[fj];
                int m = si >= sj ? fi : fj;
                int l = m == fi ? fj : fi;
                f[l] = m;
                s[m] += s[l];
            }
        }

        // 集合的某个元素是i，请把整个集合打上统一的标签，tag
        public void setTag(int i, int tag) {
            t[find(i)] = tag;
        }

        // 集合的某个元素是i，请把整个集合的tag信息返回
        public int getTag(int i) {
            return t[find(i)];
        }

    }

    // 在线查询最优解 -> 树链剖分
    // 空间复杂度O(N), 支持在线查询，单次查询时间复杂度O(logN)
    // 如果有M次查询，时间复杂度O(N + M * logN)
    public static int[] query3(int[] father, int[][] queries) {
        TreeChain tc = new TreeChain(father);
        int M = queries.length;
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            // x y ?
            // x x x
            if (queries[i][0] == queries[i][1]) {
                ans[i] = queries[i][0];
            } else {
                ans[i] = tc.lca(queries[i][0], queries[i][1]);
            }
        }
        return ans;
    }

    public static class TreeChain {
        private int n;
        private int h;
        private int[][] tree;
        private int[] fa;
        private int[] dep;
        private int[] son;
        private int[] siz;
        private int[] top;

        public TreeChain(int[] father) {
            initTree(father);
            dfs1(h, 0);
            dfs2(h, h);
        }

        private void initTree(int[] father) {
            n = father.length + 1;
            tree = new int[n][];
            fa = new int[n];
            dep = new int[n];
            son = new int[n];
            siz = new int[n];
            top = new int[n--];
            int[] cnum = new int[n];
            for (int i = 0; i < n; i++) {
                if (father[i] == i) {
                    h = i + 1;
                } else {
                    cnum[father[i]]++;
                }
            }
            tree[0] = new int[0];
            for (int i = 0; i < n; i++) {
                tree[i + 1] = new int[cnum[i]];
            }
            for (int i = 0; i < n; i++) {
                if (i + 1 != h) {
                    tree[father[i] + 1][--cnum[father[i]]] = i + 1;
                }
            }
        }

        private void dfs1(int u, int f) {
            fa[u] = f;
            dep[u] = dep[f] + 1;
            siz[u] = 1;
            int maxSize = -1;
            for (int v : tree[u]) {
                dfs1(v, u);
                siz[u] += siz[v];
                if (siz[v] > maxSize) {
                    maxSize = siz[v];
                    son[u] = v;
                }
            }
        }

        private void dfs2(int u, int t) {
            top[u] = t;
            if (son[u] != 0) {
                dfs2(son[u], t);
                for (int v : tree[u]) {
                    if (v != son[u]) {
                        dfs2(v, v);
                    }
                }
            }
        }

        public int lca(int a, int b) {
            a++;
            b++;
            while (top[a] != top[b]) {
                if (dep[top[a]] > dep[top[b]]) {
                    a = fa[top[a]];
                } else {
                    b = fa[top[b]];
                }
            }
            return (dep[a] < dep[b] ? a : b) - 1;
        }
    }
}
