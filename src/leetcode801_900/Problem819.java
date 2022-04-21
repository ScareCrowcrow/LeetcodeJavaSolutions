package leetcode801_900;

import java.util.HashMap;
import java.util.Map;

public class Problem819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase();
        paragraph=paragraph.replace('!',' ').replace('?',' ').replace('\'',' ').replace(',',' ').replace(';',' ').replace('.',' ').trim();
        String[] s = paragraph.split(" ");
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        //被禁用的单词放入map1
        for(String str:banned){
            map1.put(str,1);
        }
        //把没有禁用的单词放入map2
        for(String str : s){
            if(!map1.containsKey(str)&&!str.equals("")){
                map2.put(str,map2.getOrDefault(str,0)+1);
            }
        }
        //在map2找出出现最多的单词
        int max=-1;
        String res=null;
        for(String str:map2.keySet()){
            if(map2.get(str)>max){
                max=map2.get(str);
                res=str;
            }
        }
        return res;
    }
}
