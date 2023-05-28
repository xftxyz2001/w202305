public class Test6457 {
    public String removeTrailingZeros(String num) {
        // 从最后一位向前检查0
        int i = num.length() - 1;
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i + 1);
    }
}
