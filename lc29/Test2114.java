public class Test2114 {
    // split
    public int mostWordsFound1(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] split = sentences[i].split(" ");
            if (split.length > max) {
                max = split.length;
            }

        }
        return max;
    }

    // 数空格
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            int tmp = 1;
            for (int j = sentences[i].length() - 1; j >= 0; j--) {
                if (sentences[i].charAt(j) == ' ') {
                    tmp++;
                }
            }
            if (tmp > max) {
                max = tmp;
            }

        }
        return max;
    }
}
