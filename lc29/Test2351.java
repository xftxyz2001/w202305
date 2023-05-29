public class Test2351 {
    public char repeatedCharacter(String s) {
        int xor = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((xor & 1 << (s.charAt(i) - 'a')) != 0) {
                return s.charAt(i);
            }
            xor |= 1 << (s.charAt(i) - 'a');

        }
        return 'a';
    }

    public static void main(String[] args) {
        Test2351 test2351 = new Test2351();
        char repeatedCharacter = test2351.repeatedCharacter("abccbaacz");
        System.out.println(repeatedCharacter);
    }

}
