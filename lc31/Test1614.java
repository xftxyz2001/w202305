package lc31;

/**
 * Test1614
 */
public class Test1614 {

    public int maxDepth(String s) {
        int max = 0;
        for(int i=0, cur=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cur++;
                max = Math.max(max, cur);
            }else if(s.charAt(i) == ')'){
                cur--;
            }
        }

        return max;
    }
}