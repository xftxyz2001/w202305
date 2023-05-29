public class Test771 {
    public int numJewelsInStones(String jewels, String stones) {
        int len = stones.length();
        for (int i = 0; i < jewels.length(); i++) {
            stones = stones.replace(jewels.substring(i, i + 1), "");
        }
        return len - stones.length();
    }

    public static void main(String[] args) {

    }
}
