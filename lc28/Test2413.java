public class Test2413 {
    public int smallestEvenMultiple(int n) {
        // return n % 2 == 0 ? n : 2 * n;
        // return (n & 1) == 0 ? n : n << 1;
        return n << (n & 1);
    }
}
