package leetcode801_900;

import java.util.ArrayList;
import java.util.HashMap;

public class L815_BusRoutes_hard {
    // https://leetcode-cn.com/problems/bus-routes/
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        // key : 车站
        // value : list -> 该车站拥有哪些线路！
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
        ArrayList<Integer> queue = new ArrayList<>();
        boolean[] set = new boolean[n];
        for (int route : map.get(source)) {
            queue.add(route);
            set[route] = true;
        }
        int len = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> nextLevel = new ArrayList<>();
            for (int route : queue) {
                int[] bus = routes[route];
                for (int station : bus) {
                    if (station == target) {
                        return len;
                    }
                    for (int nextRoute : map.get(station)) {
                        if (!set[nextRoute]) {
                            nextLevel.add(nextRoute);
                            set[nextRoute] = true;
                        }
                    }
                }
            }
            queue = nextLevel;
            len++;
        }
        return -1;
    }
}
