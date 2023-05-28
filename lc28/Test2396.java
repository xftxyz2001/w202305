public class Test2396 {

    // 对于任意大于4的整数n，其n-2进制表示为12为非回文数字
    // 4的2进制表示为100为非回文数字
    // 所以不存在题目要求的严格回文数字
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }

    // public boolean isStrictlyPalindromic(int n) {
    //     for (int i = 2; i <= n - 2; i++) {
    //         // 检查各个进制
    //         if (!check(Integer.toString(n, i))) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // // 检查字符串是不是回文的
    // private boolean check(String string) {
    //     for (int i = 0; i < string.length() / 2; i++) {
    //         if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
