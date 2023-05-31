package lc31;

public class Test1812 {
    public boolean squareIsWhite(String coordinates) {
        int char0 = coordinates.charAt(0) - 'a';
        char char1 = coordinates.charAt(1);
        return (char0 + char1) % 2 == 0;
        // return ((coordinates.charAt(0) - 'a' + coordinates.charAt(1)) & 1) != 1;
    }

}
