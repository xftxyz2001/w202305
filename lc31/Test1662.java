package lc31;

public class Test1662 {
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1i = 0, w1j = 0, w2i = 0, w2j = 0;
        while (w1i < word1.length && w2i < word2.length) {
            if (word1[w1i].charAt(w1j) != word2[w2i].charAt(w2j)) {
                return false;
            }
            w1j++;
            w2j++;
            if (w1j == word1[w1i].length()) {
                w1i++;
                w1j = 0;
            }
            if (w2j == word2[w2i].length()) {
                w2i++;
                w2j = 0;
            }
        }
        return w1i == word1.length && w2i == word2.length;
    }

}
