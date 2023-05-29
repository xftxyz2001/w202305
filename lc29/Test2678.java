public class Test2678 {
    // 手机号码0-9 性别10 年龄11-12 座位号13-14
    // 7868190130 M 75 22
    public int countSeniors(String[] details) {
        int res = 0;
        for (String string : details) {
            String substring = string.substring(11, 13);
            if (Integer.parseInt(substring) > 60) {
                res++;
            }
        }

        return res;
    }

}
