/**
 * Test2391
 */
public class Test2391 {

    // 遍历garbage，记录'M''P''G'的出现次数和'M''P''G'的最后出现的位置即可。
    // 又因为每个字符串中只有上述三个字母，因此可直接加上字符串的全部长度。

    public int garbageCollection(String[] garbage, int[] travel) {
        // 出现该种垃圾的最后一个位置
        int indexM = 0, indexP = 0, indexG = 0;
        // 垃圾总数
        int total = 0;

        for (int i = 0; i < garbage.length; i++) {
            // 更新垃圾总数
            total += garbage[i].length();
            // 更新每种最后垃圾出现位置
            if (garbage[i].contains("M")) {
                indexM = i;
            }
            if (garbage[i].contains("P")) {
                indexP = i;
            }
            if (garbage[i].contains("G")) {
                indexG = i;
            }

        }
        int time = 0;
        for (int i = 0; i < travel.length; i++) {
            time += i < indexM ? travel[i] : 0;
            time += i < indexP ? travel[i] : 0;
            time += i < indexG ? travel[i] : 0;
        }
        time += total;
        return time;
    }
}