package leetcode1201_1300;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1257_SmallestCommonRegion_medium {
    // https://leetcode.cn/problems/smallest-common-region/
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        // 最近公共祖先
        Map<String, String> faMap = new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                faMap.put(region.get(i), region.get(0));
            }
        }
        // LCA
        String p1 = region1;
        String p2 = region2;
        while (!p1.equals(p2)) {
            p1 = faMap.getOrDefault(p1, region2);
            p2 = faMap.getOrDefault(p2, region1);
        }
        return p1;
    }
}
