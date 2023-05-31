package lc31;

public class Test1732 {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int h = 0;
        for (int i : gain) {
            h += i;
            if (h > ans)
                ans = h;
        }
        return ans;
    }

}
