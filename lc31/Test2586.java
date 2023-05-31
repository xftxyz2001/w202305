package lc31;

public class Test2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            // ans += check(words[i]);
            if (check(words[i].charAt(0)) && check(words[i].charAt(words[i].length() - 1))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    // private int check(String string) {
    // for (int i = 0; i < string.length(); i++) {
    // switch (string.charAt(i)) {
    // case 'a':
    // case 'e':
    // case 'i':
    // case 'o':
    // case 'u':
    // continue;
    // default:
    // return 0;
    // }
    // }
    // return 1;
    // }

}
