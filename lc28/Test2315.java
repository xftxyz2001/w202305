public class Test2315 {
    public int countAsterisks(String s) {
        // 计数标志
        boolean flag = true;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag && s.charAt(i) == '*') {
                // 计数开启且为*
                counter++;
            } else if (s.charAt(i) == '|') {
                // 遇到|切换计数开关状态
                flag = !flag;
            }

        }
        return counter;

    }
}
