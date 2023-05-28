import java.util.List;

public class Test1773 {
    // items[i] = [typei, colori, namei]
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;

        int ki = -1;
        switch (ruleKey) {
            case "type":
                ki = 0;
                break;
            case "color":
                ki = 1;
                break;
            case "name":
                ki = 2;
                break;
        }

        for (List<String> list : items) {
            if (list.get(ki).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
