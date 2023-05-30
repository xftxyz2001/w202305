package lc30;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    int index;
    String[] list;

    public OrderedStream(int n) {
        this.list = new String[n+1];
        this.index = 0;
    }

    public List<String> insert(int idKey, String value) {
        this.list[idKey - 1] = value;
        List<String> res = new ArrayList<>();
        while (this.list[this.index] != null) {
            res.add(this.list[this.index++]);
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */