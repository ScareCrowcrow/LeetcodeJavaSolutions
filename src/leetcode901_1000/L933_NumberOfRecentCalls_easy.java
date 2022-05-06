package leetcode901_1000;

public class L933_NumberOfRecentCalls_easy {
    // https://leetcode-cn.com/problems/number-of-recent-calls/
    class RecentCounter {
        int calls[]=new int[10005];
        int p;
        public RecentCounter() {
            p=0;
        }

        public int ping(int t) {
            calls[p]=t;
            p++;
            int l=0,r=p-1;
            while(l<r){
                int mid=(l+r)>>1;
                if(calls[mid]<t-3000){l=mid+1;}
                else{r=mid;}
                if(l==r-1){
                    if(calls[l]>=t-3000){r=l;}
                    break;
                }
            }
            return p-r;
        }
    }
}
