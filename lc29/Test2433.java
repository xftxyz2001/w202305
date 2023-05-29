public class Test2433 {
    // 超时
    public int[] findArray1(int[] pref) {

        for (int i = 0; i < pref.length; i++) {
            for (int j = 0; j < i; j++) {
                pref[i] ^= pref[j];
            }
        }
        return pref;
    }

    public int[] findArray2(int[] pref) {

        int xor = 0;
        int i = 0;
        while (true) {
            xor ^= pref[i];
            i++;
            if (i >= pref.length) {
                break;
            }
            pref[i] ^= xor;
        }

        return pref;
    }

    public int[] findArray(int[] pref) {

        int xor = 0;
        int i = 0;
        do {
            pref[i] ^= xor;
            xor ^= pref[i];
            i++;
        } while (i < pref.length);

        return pref;
    }
}
